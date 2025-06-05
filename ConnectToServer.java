/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pooveterinaria;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class ConnectToServer {
    
    public static void main(String args[]){
        
    }
    public Connection conn;
    public void conectaSql() throws ClassNotFoundException, SQLException{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        // CAMBIAR ANTES DE LA PRESENTACION A LA COMPU DEL PROFE / COMPU QUE PRESENTA
        String hostname = "AO2300221";
        String instance = "DATA";
        String DB = "POO";
        // Specify the connection URL, username, and password
        //String url = "jdbc:sqlserver://DESKTOP-HELL75I\\MYSQL;databaseName=TestLogin;TrustServerCertificate=True;";
        String url = "jdbc:sqlserver://" + hostname + "\\" + instance + ";databaseName=" + DB + ";TrustServerCertificate=True;";
        String username = "sa";
        String password = "123456789";
        conn = DriverManager.getConnection(url, username, password);
    }
    public ResultSet querySql(String query) throws SQLException{
        PreparedStatement pst = conn.prepareStatement(query);
        ResultSet rs = pst.executeQuery();
        if(!rs.next()){
            JOptionPane.showMessageDialog(null, "No hay datos");
            return null;
        }else{
            return rs;
        }
    }
    // Para creacion de DATOS
    public int nextId(String tipo) throws SQLException{
        // Tipo tiene que venir de una combo box
         String t = "", tabla = "";
         switch (tipo){
             case "Empleado":
                 t = "1";
                 tabla = "Empleado";
                 break;
             case "Cliente":
                 t = "2";
                 tabla = "Cliente";
                 break;
             case "Paciente":
                 t = "3";
                 tabla = "Paciente";
                 break;
             case "Registro":
                 t = "4";
                 tabla = "Registro";
                 break;
             case "Tipo Diagnostico":
                 t = "5";
                 tabla = "Tipos_Diagnostico";
                 break;
         }
         String q = "Select top 1 Id from " + tabla + " where left(Id,1) == " + t + " order by 1 desc";
         int id = querySql(q).getInt(0);
         int nextId = id + 1;
         return nextId;

    }
    public boolean verifLogin(String Usr, String psw) throws SQLException{
        String q = "select usuario, contra from Accesos where usuario == " + Usr + " and contra == " + psw;
        boolean verif = false;
        ResultSet veri = querySql(q);
        if(!veri.next()){
            JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos");
        }else{
            verif = true;
        }
        return verif;
    }
    // PLACEHOLDER EDITAR EN CASITA
    public void editTABLA(String a, String b, String c, String d){
        // cambia mascotas(edad,fecvha muerte), clientes(edad, residencia), empelados(contrato, rol), accesos(conrta, usuario)
        // obvio funciones separadas que weba jutnar 3 tablas en una func
    }
    public void crearEmpleado  (String nombre, String apellidos, String fechaNac, 
                                String genero, String tipoDoc, String numDoc,
                                String direc, String telef, String correo) throws SQLException{
        String ID, q;
        VET_Library LIB = new VET_Library();
        ID = nextId("Empleado") + "";
        q = "insert into Empleado (" + 
                ID + "," +
                nombre + "," +
                apellidos + "," +
                ((LIB.FechaOK(fechaNac, 1969, 2025, true))? fechaNac: null) + "," +
                genero + "," +
                tipoDoc + "," +
                numDoc + "," +
                direc + "," +
                telef + "," +
                correo + "," +
                ")";
        try {
            PreparedStatement creacion = conn.prepareStatement(q);
            creacion.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex);
        }
        JOptionPane.showMessageDialog(null, "Empleado registrado con exito");
    }
    public void crearCliente   (String estado_cliente, String nombre , String apellidos , 
                                String fecha_nacimiento, String genero, String tipo_doc,
                                String num_documento, String direccion , String telefono ,
                                String correo, String ciudad, String distrito) throws SQLException{
        String ID, q;
        VET_Library LIB = new VET_Library();
        ID = nextId("Cliente") + "";
        q = "insert into Cliente (" + 
                ID + "," +
                estado_cliente + "," +
                nombre + "," +
                apellidos + "," +
                ((LIB.FechaOK(fecha_nacimiento, 1969, 2025, true))? fecha_nacimiento: null) + "," +
                genero + "," +
                tipo_doc + "," +
                num_documento + "," +
                direccion + "," +
                telefono + "," +
                correo + "," +
                ciudad + "," +
                distrito + "," + // nop se si TENGO que añadir fecha registro al tener val default
                ")";
        try {
            PreparedStatement creacion = conn.prepareStatement(q);
            creacion.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex);
        }
        JOptionPane.showMessageDialog(null, "Cliente registrado con exito");
    }
    public void crearPaciente  (String estado_cliente, String nombre , String apellidos , 
                                String tipo ,String fecha_nacimiento,String fecha_fallecimiento,
                                String sexo, String color ,String esterilizado, String longitud  ,String altura,
                                String peso, String morfologia , String grupo_sanguineo  ,
                                String microchip , String tatuaje , String observaciones ) throws SQLException{
        String ID, q;
        VET_Library LIB = new VET_Library();
        ID = nextId("Paciente") + "";
        q = "insert into Cliente (" + 
                ID + "," +
                estado_cliente + "," +
                nombre + "," +
                apellidos + "," +
                ((LIB.FechaOK(fecha_nacimiento, 1969, 2025, true))? fecha_nacimiento: null) + "," +
                sexo + "," +
                color + "," + 
                esterilizado + "," +
                longitud + "," +
                altura + "," +
                peso + "," +
                morfologia + "," +
                grupo_sanguineo + "," + 
                microchip + "," +
                tatuaje + "," +
                observaciones + "," +
                ")";
        try {
            PreparedStatement creacion = conn.prepareStatement(q);
            creacion.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex);
        }
        JOptionPane.showMessageDialog(null, "Paciente registrado con exito");
    }
    public void crearRegistro  (String ID_mascota, String ID_empleado) throws SQLException{
        String ID, q;
        VET_Library LIB = new VET_Library();
        ID = nextId("Registro") + "";
        q = "insert into Cliente (" + 
                ID + "," +
                ID_mascota + "," +
                ID_empleado + "," +
                ")";
        try {
            PreparedStatement creacion = conn.prepareStatement(q);
            creacion.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex);
        }
        JOptionPane.showMessageDialog(null, "Registro registrado con exito");
    }
    public void crearTipoDiagnostico  (String diagnostico) throws SQLException{
        String ID, q;
        VET_Library LIB = new VET_Library();
        ID = nextId("Tipo Diagnostico") + "";
        q = "insert into Cliente (" + 
                ID + "," +
                diagnostico + "," +
                ")";
        try {
            PreparedStatement creacion = conn.prepareStatement(q);
            creacion.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex);
        }
        JOptionPane.showMessageDialog(null, "Tipo Diagnostico registrado con exito");
    }
}
