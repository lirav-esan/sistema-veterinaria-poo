/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package patitas_vet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static pooveterinaria.VET_Demo.ID;
import pooveterinaria.VET_Library; // Solo una vez

/**
 *
 * @author Usuario
 */
public class ConnectToServer {

    // No es necesario un main aquí a menos que quieras probar la conexión directamente.
    // public static void main(String args[]){ }

    public Connection conn;

    public void conectaSql() throws ClassNotFoundException, SQLException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

        String hostname = "DESKTOP-HELL75I";
        String DB = "PatitasVet";

        // Para instancia con nombre 'EE', es mejor usar instanceName
        // Asegúrate que el SQL Server Browser Service esté corriendo en tu servidor
        String url = "jdbc:sqlserver://" + hostname + ";instanceName=MYSQL;databaseName=" + DB + ";encrypt=True;TrustServerCertificate=True;";
        
        // Si tu instancia 'EE' está escuchando en el puerto 1433 y no quieres usar instanceName
        // String url = "jdbc:sqlserver://" + hostname + ":1433;databaseName=" + DB + ";encrypt=True;TrustServerCertificate=True;";

        String username = "sa";
        String password = "123456789"; // ¡Recuerda cambiar esto por una contraseña segura en producción!

        conn = DriverManager.getConnection(url, username, password);
        // Opcional: Mostrar mensaje de éxito en la conexión (solo para depuración)
        // JOptionPane.showMessageDialog(null, "Conexión a la base de datos exitosa!");
    }

    public void cierraSql() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al cerrar la conexión: " + ex.getMessage());
            Logger.getLogger(ConnectToServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Método para ejecutar consultas SELECT. Devuelve null si no hay datos o hay error.
    public ResultSet querySql(String query, Object... params) throws SQLException {
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = conn.prepareStatement(query);
            for (int i = 0; i < params.length; i++) {
                pst.setObject(i + 1, params[i]);
            }
            rs = pst.executeQuery();
            // No devolver null si no hay datos aquí, dejar que el código que llama maneje si rs.next() es false
            return rs;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en la consulta SQL: " + ex.getMessage());
            Logger.getLogger(ConnectToServer.class.getName()).log(Level.SEVERE, null, ex);
            if (pst != null) pst.close(); // Asegurarse de cerrar el PreparedStatement
            return null; // En caso de error, devuelve null
        }
    }
    
    // Nuevo método para ejecutar INSERT, UPDATE, DELETE
    public int executeUpdate(String query, Object... params) throws SQLException {
        PreparedStatement pst = null;
        try {
            pst = conn.prepareStatement(query);
            for (int i = 0; i < params.length; i++) {
                pst.setObject(i + 1, params[i]);
            }
            return pst.executeUpdate(); // Retorna el número de filas afectadas
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al ejecutar la actualización SQL: " + ex.getMessage());
            Logger.getLogger(ConnectToServer.class.getName()).log(Level.SEVERE, null, ex);
            throw ex; // Relanzar la excepción para que el llamador la maneje
        } finally {
            if (pst != null) {
                pst.close();
            }
        }
    }

    // Para creacion de IDs
    public int nextId(String tipo) throws SQLException {
        String t = "";
        String tabla = "";
        String idColumna = "ID"; // Asumiendo que la columna ID se llama 'Id'

        switch (tipo) {
            case "Empleado":
                t = "E";
                tabla = "Empleado";
                break;
            case "Cliente":
                t = "C";
                tabla = "Cliente";
                break;
            case "Paciente":
                t = "M";
                tabla = "Paciente";
                break;
            case "Registro":
                t = "R";
                tabla = "Registro";
                break;
            case "Tipo Diagnostico":
                t = "0";
                tabla = "Tipos_Diagnostico"; // Asegúrate que este sea el nombre correcto de la tabla
                break;
            default:
                JOptionPane.showMessageDialog(null, "Tipo de entidad no reconocido para generar ID.");
                return -1; // O lanzar una excepción
        }

        // Corrección de la consulta SQL: usar '=' en lugar de '==' y comillas simples para el tipo 't'
        // Además, asegúrate que 'Id' sea el nombre correcto de la columna.
        // Y usar PreparedStatement para mayor seguridad.
        String q = "SELECT TOP 1 " + idColumna + " FROM " + tabla + " WHERE LEFT(" + idColumna + ",1) = ? ORDER BY " + idColumna + " DESC";
        ResultSet rs = null;
        int nextId = -1; // Valor por defecto en caso de no encontrar IDs

        try {
            rs = querySql(q, t); // Pasa el parámetro 't' al método querySql

            if (rs != null && rs.next()) {
                // Obtener el ID como String para manejar prefijos (si los hay)
                String lastIdStr = rs.getString(idColumna); 
                // Asumiendo que el ID es un número después del primer dígito
                // Si el ID es "1001", y 't' es "1", quieres el siguiente número después de "001"
                // Esto es una lógica de negocio específica y puede necesitar ajuste.
                
                try {
                    // Si los IDs son puramente numéricos como 1001, 1002, etc.
                    nextId = Integer.parseInt(lastIdStr.substring(1)) + 1;
                } catch (NumberFormatException e) {
                    // Si los IDs tienen prefijos alfanuméricos como "E001", "C001"
                    // Necesitarás una lógica más sofisticada para extraer la parte numérica.
                    // Por ahora, solo maneja IDs puramente numéricos.
                    JOptionPane.showMessageDialog(null, "Error al generar el ID: formato de ID inesperado.");
                    Logger.getLogger(ConnectToServer.class.getName()).log(Level.SEVERE, "Formato de ID inesperado: " + lastIdStr, e);
                    return -1; 
                }
            } else {
                // Si no hay IDs existentes para ese tipo, genera el primero
                // Por ejemplo, para tipo "1", el primer ID sería "1001" (si es un formato de 4 dígitos)
                // O simplemente el tipo 't' seguido de un 0 o 1, depende de tu convención.
                nextId = Integer.parseInt(t + "001"); // Ejemplo: Si t="1", primer ID="1001"
                JOptionPane.showMessageDialog(null, "No se encontraron IDs existentes. Generando el primer ID para " + tabla + ": " + nextId);
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            // No se cierra el PreparedStatement aquí, se maneja en querySql.
        }
        return nextId;
    }

    public boolean verifLogin(String Usr, String psw) throws SQLException {
        // Corrección: Usar PreparedStatement para evitar SQL Injection
        // Corrección: Usar '=' en lugar de '=='
        String q = "SELECT usuario, contra FROM Accesos WHERE usuario = ? AND contra = ?";
        ResultSet veri = null;
        boolean verif = false;
        try {
            veri = querySql(q, Usr, psw); // Pasa los parámetros Usr y psw
            if (veri != null && veri.next()) { // Mover veri.next() aquí para verificar si hay resultados
                verif = true;
            } else {
                JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos");
            }
        } finally {
            if (veri != null) {
                veri.close();
            }
            // No se cierra el PreparedStatement aquí, se maneja en querySql.
        }
        return verif;
    }

    // PLACEHOLDER EDITAR EN CASITA
    public void AddColumnFromTable(String TABLA, String COLUMNA, String TIPO, String LEN) throws SQLException {
        String q = "ALTER TABLE " + TABLA.trim() + " ADD " + COLUMNA.trim() + " " + TIPO.trim();
        if (TIPO.equalsIgnoreCase("varchar") || TIPO.equalsIgnoreCase("char") || TIPO.equalsIgnoreCase("decimal")) {
            if (TIPO.equalsIgnoreCase("decimal") && !LEN.contains(",")) {
                JOptionPane.showMessageDialog(null, "Formato inadecuado para variable decimal \n (a,b)");
                return;
            }
            q += "(" + LEN + ")";
        }
        // Este tipo de consulta DDL (ALTER TABLE) no puede usar PreparedStatement con marcadores de posición para nombres de tablas/columnas
        // Se asume que TABLA, COLUMNA, TIPO y LEN son nombres de objetos de base de datos validados y no provienen directamente de entrada de usuario.
        // Si provienen de UI, deben ser validados fuertemente contra una lista blanca o ser seleccionados de listas predefinidas.
        // executeUpdate es adecuado para DDL.
        executeUpdate(q);
        JOptionPane.showMessageDialog(null, "Columna '" + COLUMNA + "' añadida a la tabla '" + TABLA + "' con éxito.");
    }

    public void EditColumnFromTable(String TABLA, String COLUMNA, String TIPO, String LEN) throws SQLException {
        String q = "ALTER TABLE " + TABLA.trim() + " ALTER COLUMN " + COLUMNA.trim() + " " + TIPO.trim();
        if (TIPO.equalsIgnoreCase("varchar") || TIPO.equalsIgnoreCase("char") || TIPO.equalsIgnoreCase("decimal")) {
            if (TIPO.equalsIgnoreCase("decimal") && !LEN.contains(",")) {
                JOptionPane.showMessageDialog(null, "Formato inadecuado para variable decimal \n (a,b)");
                return;
            }
            q += "(" + LEN + ")";
        }
        executeUpdate(q);
        JOptionPane.showMessageDialog(null, "Columna '" + COLUMNA + "' modificada en la tabla '" + TABLA + "' con éxito.");
    }

    public void DropColumnFromTable(String TABLA, String COLUMNA) throws SQLException { // LEN no es necesario
        String q = "ALTER TABLE " + TABLA.trim() + " DROP COLUMN " + COLUMNA.trim();
        executeUpdate(q);
        JOptionPane.showMessageDialog(null, "Columna '" + COLUMNA + "' eliminada de la tabla '" + TABLA + "' con éxito.");
    }

    public void UpdateColumnFromTable(String TABLA, String COLUMNA, String DATA, String ID) throws SQLException {
        // Corrección de la sintaxis SQL: quitar 'table', 'column' y usar parámetros
        String q = "UPDATE " + TABLA.trim() + " SET " + COLUMNA.trim() + " = ? WHERE ID = ?";
        // Los nombres de tabla y columna siguen siendo concatenados, asumiendo validación externa.
        // Si DATA no es una cadena, deberías tratarlo como un Object y el PreparedStatement lo manejará.
        executeUpdate(q, DATA, ID);
        
    }

    public void crearEmpleado(String nombre, String apellidos, String fechaNac,
            String genero, String tipoDoc, String numDoc,
            String direc, String telef, String correo) throws SQLException {
        
        // Asumiendo que el ID se genera de forma consecutiva y es numérico o un varchar de números.
        // Si el ID es una clave primaria autoincremental en SQL Server, NO deberías insertarlo.
        // Si es un ID compuesto o generado por tu lógica, sí.
        int generatedId = nextId("Empleado");
        if (generatedId == -1) {
            JOptionPane.showMessageDialog(null, "No se pudo generar el ID para el Empleado.");
            return;
        }
        String ID = String.valueOf(generatedId);

        VET_Library LIB = new VET_Library();
        
        // Corrección de la sintaxis INSERT y uso de PreparedStatement
        // Asegúrate que la cantidad de columnas y parámetros coincida con tu tabla Empleado
        String q = "INSERT INTO Empleado (Id, nombre, apellidos, fechaNac, genero, tipoDoc, numDoc, direc, telef, correo) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        // Conversión de fecha de String a java.sql.Date si es necesario
        java.sql.Date sqlFechaNac = null;
        if (LIB.FechaOK(fechaNac, 1969, 2025, true)) {
            // Asume que FechaOK te da un String en formato "YYYY-MM-DD" o similar
            // Puedes necesitar una función de VET_Library para convertir String a java.sql.Date
            try {
                 sqlFechaNac = java.sql.Date.valueOf(fechaNac);
            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null, "Error al convertir fecha de nacimiento: " + e.getMessage());
                return;
            }
        }
        
        try {
            executeUpdate(q, ID, nombre, apellidos, sqlFechaNac, genero, tipoDoc, numDoc, direc, telef, correo);
            JOptionPane.showMessageDialog(null, "Empleado registrado con exito");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al registrar Empleado: " + ex.getMessage());
            Logger.getLogger(ConnectToServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void crearCliente(String estado_cliente, String nombre, String apellidos,
            String fecha_nacimiento, String genero, String tipo_doc,
            String num_documento, String direccion, String telefono,
            String correo, String ciudad, String distrito) throws SQLException {

        int generatedId = nextId("Cliente");
        if (generatedId == -1) {
            JOptionPane.showMessageDialog(null, "No se pudo generar el ID para el Cliente.");
            return;
        }
        String ID = "C" + String.valueOf(generatedId);

        VET_Library LIB = new VET_Library();
        
        // Ajusta los nombres de las columnas y la cantidad de parámetros según tu tabla Cliente
        String q = "INSERT INTO Cliente (Id, estado_cliente, nombre, apellidos, fecha_nacimiento, genero, tipo_doc, num_documento, direccion, telefono, correo, ciudad, distrito) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        /*java.sql.Date sqlFechaNac = null;
        if (LIB.FechaOK(fecha_nacimiento, 1969, 2025, true)) {
            try {
                 sqlFechaNac = java.sql.Date.valueOf(fecha_nacimiento);
            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null, "Error al convertir fecha de nacimiento del cliente: " + e.getMessage());
                return;
            }
        }*/

        try {
            executeUpdate(q, ID, estado_cliente, nombre, apellidos, fecha_nacimiento, genero, tipo_doc, num_documento, direccion, telefono, correo, ciudad, distrito);
            JOptionPane.showMessageDialog(null, "Cliente registrado con exito");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al registrar Cliente: " + ex.getMessage());
            Logger.getLogger(ConnectToServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void crearPaciente(String ID_titular, String nombre, String apellidos,
            String tipo, String fecha_nacimiento, // 'tipo' no se usaba antes
            String sexo, String color, String esterilizado, String longitud, String altura,
            String peso, String morfologia, String grupo_sanguineo,
            String microchip, String tatuaje, String observaciones) throws SQLException {
        
        int generatedId = nextId("Paciente");
        if (generatedId == -1) {
            JOptionPane.showMessageDialog(null, "No se pudo generar el ID para el Paciente.");
            return;
        }
        String ID = "M" + String.valueOf(generatedId);
        
        VET_Library LIB = new VET_Library();

        // Ajusta los nombres de las columnas y la cantidad de parámetros según tu tabla Paciente
        // Agregué 'tipo' como parámetro ya que lo tenías definido. Si no va en la tabla, quítalo.
        String q = "INSERT INTO Paciente (Id, ID_titular, nombre, apellidos, tipo, fecha_nacimiento, sexo, color, esterilizado, longitud, altura, peso, morfologia, grupo_sanguineo, microchip, tatuaje, observaciones) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

               
        try {
            executeUpdate(q, ID, ID_titular, nombre, apellidos, tipo, fecha_nacimiento, sexo, color, esterilizado, longitud, altura, peso, morfologia, grupo_sanguineo, microchip, tatuaje, observaciones);
            JOptionPane.showMessageDialog(null, "Paciente registrado con exito");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al registrar Paciente: " + ex.getMessage());
            Logger.getLogger(ConnectToServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void crearRegistro(String ID_mascota, String ID_empleado) throws SQLException {
        int generatedId = nextId("Registro");
        if (generatedId == -1) {
            JOptionPane.showMessageDialog(null, "No se pudo generar el ID para el Registro.");
            return;
        }
        String ID = "R" + String.valueOf(generatedId);

        // Ajusta los nombres de las columnas y la cantidad de parámetros según tu tabla Registro
        String q = "INSERT INTO Registro (Id, ID_mascota, ID_empleado) VALUES (?, ?, ?)";
        
        try {
            executeUpdate(q, ID, ID_mascota, ID_empleado);
            JOptionPane.showMessageDialog(null, "Registro registrado con exito");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al registrar Registro: " + ex.getMessage());
            Logger.getLogger(ConnectToServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void crearEstetica(String ID_registro, String ID_Concepto) throws SQLException{
        try {     
            conectaSql();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnectToServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        String query = "SELECT ID FROM Registro WHERE ID = " + ID_registro;
        ResultSet veri = querySql(query);
        
        if (veri != null){
            
            query = "INSERT INTO Estetica (ID, Concepto) VALUES (?, ?)";           
            executeUpdate(query, ID_registro, ID_Concepto);
            JOptionPane.showMessageDialog(null, "Tipo Diagnostico registrado con exito");           
            
        }
        cierraSql();
        
    }

    public void crearTipoDiagnostico(String diagnostico) throws SQLException {
        int generatedId = nextId("Tipo Diagnostico");
        if (generatedId == -1) {
            JOptionPane.showMessageDialog(null, "No se pudo generar el ID para el Tipo Diagnostico.");
            return;
        }
        String ID = "0" + String.valueOf(generatedId);

        // Ajusta los nombres de las columnas y la cantidad de parámetros según tu tabla Tipos_Diagnostico
        String q = "INSERT INTO Tipos_Diagnostico (Id, diagnostico) VALUES (?, ?)";
        
        try {
            executeUpdate(q, ID, diagnostico);
            JOptionPane.showMessageDialog(null, "Tipo Diagnostico registrado con exito");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al registrar Tipo Diagnostico: " + ex.getMessage());
            Logger.getLogger(ConnectToServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}