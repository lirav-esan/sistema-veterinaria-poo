/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pooveterinaria;
import java.io.IOException;
import java.util.Scanner;
import java.io.RandomAccessFile;
import javax.swing.JOptionPane;


public class VET_Demo {
//-----------------------------------------------
private static String           ARCHIVO = "D:\\ESAN\\2025-i\\POO\\PooMantenimientoVehi\\src\\poomantenimientovehi\\Usuarios.DAT";
private static int              W       = 104;  //Longitud del Registro
private static Scanner          SCN = new Scanner(System.in);
private static RandomAccessFile RAF;
private static VET_Library      LIB = new VET_Library();
private static byte[]           BUFFER  = new byte[W];
public static String ID, NOMBRE, USUARIO, PSWD, FECHA_INI, HORA_INI, FECHA_FIN, HORA_FIN, RECORD;
public static char ESTADO;
//-----------------------------------------------
//-----------------------------------------------
private static void BuildRecord() {
                                // %-Xs es para obligar a esa parte a ser de X caracteres
   RECORD = //String.format("%-2s %-40s%-15s%-10s %s %s %s %s %c",
             ID +
             NOMBRE +
             USUARIO+ 
             PSWD+
             FECHA_INI+
             HORA_INI+
             FECHA_FIN+
             HORA_FIN+
             ESTADO;
   //);
}
//-----------------------------------------------
private static void LoadFields() {
   ID         = RECORD.substring(0, 3).trim();
   NOMBRE    = RECORD.substring(3, 43).trim();
   USUARIO    = RECORD.substring(43, 58).trim();
   PSWD     = RECORD.substring(60, 71).trim();
   FECHA_INI  = RECORD.substring(73, 79);
   HORA_INI   = RECORD.substring(80, 86);
   FECHA_FIN  = RECORD.substring(87, 95);
   HORA_FIN   = RECORD.substring(96, 102);
   ESTADO     = RECORD.charAt(103);
   
}
//-----------------------------------------------
private static void ViewFields() {
   System.out.println("ID                 : " + ID);
   System.out.println("Nombre             : " + NOMBRE);
   System.out.println("Usuario            : " + USUARIO);
   System.out.println("Contraseña         : " + PSWD);
   System.out.println("Fecha Inicial      : " + FECHA_INI.substring(6,8) + '/' + FECHA_INI.substring(4,6) + '/' + FECHA_INI.substring(0,4));
   System.out.println("Hora Inicial       : " + HORA_INI);
   System.out.println("Fecha Final        : " + FECHA_FIN.substring(6,8) + '/' + FECHA_FIN.substring(4,6) + '/' + FECHA_FIN.substring(0,4));
   System.out.println("Hora Final         : " + HORA_FIN);
   System.out.println("Estado             : " + (ESTADO == '1' ? "Activo" : "Inactivo"));
}
//-----------------------------------------------
public static long BuscarCodigo(String CODIGO) throws IOException, InterruptedException {
long i,T,N,P;
   RAF = new RandomAccessFile(ARCHIVO,"r");
   T = RAF.length();
   N = T/W;
   P = 0;
   i = 1;
   while((i<=N)&&(P==0)) {
       RAF.seek((i-1)*W);
       RAF.read(BUFFER);
       RECORD = LIB.BufferToString(BUFFER);
       LoadFields();
       if(USUARIO.equals(CODIGO)==true) {
          P = i;
       }
       i++;
   }
   RAF.close();
   return P;
}
//-----------------------------------------------
private static String RegistrarUSUARIO(String S) throws IOException, InterruptedException {
String TMP;
   
      TMP = S.trim();
   if((BuscarCodigo(TMP)>0)||(LIB.ValidacionOK(TMP,"",2,16,"ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz. -0123456789")==false))
       JOptionPane.showMessageDialog(null, "Ingrese una ID correcta");
   return TMP;
}  
//-----------------------------------------------
//-----------------------------------------------
private static String RegistrarCONTRA(String S) {
String TMP;
      
         TMP = S.trim();
      if(!LIB.ValidacionOK(TMP,"",2,20,"ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz. -0123456789"))
          JOptionPane.showMessageDialog(null, "Ingrese un nombre correcto");
      TMP = TMP + LIB.Replicate(' ',20-TMP.length());
   return TMP;
}  
//-----------------------------------------------
//-----------------------------------------------
public static void Ingreso(
    String id, String nombre, String usuario, String contra,
    String fechaIni, String horaIni, String fechaFin, String horaFin, char estado
) throws IOException, InterruptedException {

    LIB.ClearScreen();
    System.out.println("INGRESO DE USUARIOS");
    System.out.println("====================================================");

    // Validaciones mínimas (puedes agregar más con LIB.ValidacionOK si lo deseas)
    if (id.length() != 2 || estado != '1' && estado != '0') {
        JOptionPane.showMessageDialog(null, "Datos inválidos. Verifique ID y estado.");
        return;
    }

    // Asignar los campos recibidos a las variables globales
    ID         = id.trim();
    NOMBRE    = nombre.trim();
    USUARIO    = usuario.trim();
    PSWD     = contra.trim();
    FECHA_INI  = fechaIni;
    HORA_INI   = horaIni;
    FECHA_FIN  = fechaFin;
    HORA_FIN   = horaFin;
    ESTADO     = estado;

    // Rellenar campos que requieren longitud fija
    NOMBRE = String.format("%-40s", NOMBRE);
    USUARIO = String.format("%-15s", USUARIO);
    PSWD  = String.format("%-10s", PSWD);

    // Construcción del registro
    BuildRecord();

    // Escritura al archivo
    RAF = new RandomAccessFile(ARCHIVO, "rw");
    long T = RAF.length(); // Ir al final del archivo
    RAF.seek(T);
    BUFFER = LIB.StringToBuffer(RECORD, W);
    RAF.write(BUFFER);
    RAF.close();

    System.out.println("\nRegistro guardado correctamente.");
    System.out.println("Pulse [ENTER] para salir...");
    SCN.nextLine();
}
//-----------------------------------------------
/*public static void Modificacion(String s1,String s2,String s3,String s4,String s5,String s6,String s7) throws IOException, InterruptedException {
String TMP;
long P;
   LIB.ClearScreen();
   System.out.println("MODIFICACION DE PRODUCTOS");
   System.out.println("====================================================");
   //....................................................................................
   do {
      System.out.print("Id                  : ");
        TMP = s1.trim();
   } while(!LIB.ValidacionOK(TMP,"",3,3,"0123456789"));
   System.out.println("----------------------------------------------------");
   //....................................................................................
   P = BuscarCodigo(TMP);
   if(P>0) {

      RAF = new RandomAccessFile(ARCHIVO,"rw");
      RAF.seek((P-1)*W);
      RAF.read(BUFFER);
      RECORD = LIB.BufferToString(BUFFER);
      LoadFields();
      ViewFields();
      System.out.println("----------------------------------------------------");
      do {
         System.out.print  ("Desea Modificar el Registro? [S/N]: ");
         TMP = SCN.nextLine().trim();
      } while(!LIB.ValidacionOK(TMP,"",1,1,"SsNn"));
      if((TMP.charAt(0)=='S')||
         (TMP.charAt(0)=='s')) {
         //....................................................................................
         FLAG = ' ';
         USUARIO = RegistrarUSUARIO(s1);
         CONTRA = RegistrarCONTRA(s3);
         //....................................................................................
         BuildRecord();
         //....................................................................................
         RAF = new RandomAccessFile(ARCHIVO,"rw");
         RAF.seek((P-1)*W);
         BUFFER = LIB.StringToBuffer(RECORD,W);   
         RAF.write(BUFFER);
         RAF.close();
      }
   }
   else {
      System.out.println("ERROR: El codigo especificado No Existe");
   }
   System.out.println("\n\nPulse [ENTER] para Salir!!!");
   SCN.nextLine();
}*/
//-----------------------------------------------
/*public static void Eliminacion() throws IOException, InterruptedException {
String TMP;
long P;
   LIB.ClearScreen();
   System.out.println("ELIMINACION DE PRODUCTOS");
   System.out.println("====================================================");
   //....................................................................................
   do {
      System.out.print("Id                  : ");
      TMP = SCN.nextLine().trim();
   } while(!LIB.ValidacionOK(TMP,"",3,3,"0123456789"));
   System.out.println("----------------------------------------------------");
   //....................................................................................
   P = BuscarCodigo(TMP);
   if(P>0) {
      RAF = new RandomAccessFile(ARCHIVO,"rw");
      RAF.seek((P-1)*W);
      RAF.read(BUFFER);
      RECORD = LIB.BufferToString(BUFFER);
      LoadFields();
      ViewFields();
      System.out.println("----------------------------------------------------");
      do {
         System.out.print  ("Desea Eliminar el Registro? [S/N]: ");
         TMP = SCN.nextLine().trim();
      } while(!LIB.ValidacionOK(TMP,"",1,1,"SsNn"));
      if((TMP.charAt(0)=='S')||
         (TMP.charAt(0)=='s')) {
          FLAG = '*'; 
          BuildRecord();
          BUFFER = LIB.StringToBuffer(RECORD,W);   
          RAF.seek((P-1)*W);
          RAF.write(BUFFER);
          RAF.close();
          System.out.println("El Registro ha sido Eliminado!!!");
      }
   }
   else {
      System.out.println("ERROR: El codigo especificado No Existe");
   }
   System.out.println("\n\nPulse [ENTER] para Salir!!!");
   SCN.nextLine();
}*/
//-----------------------------------------------
/*
public static void Busqueda() throws IOException, InterruptedException {
String TMP;
long P;
   LIB.ClearScreen();
   System.out.println("BUSQUEDA DE PRODUCTOS");
   System.out.println("====================================================");
   //....................................................................................
   do {
      System.out.print("Id                  : ");
      TMP = SCN.nextLine().trim();
   } while(!LIB.ValidacionOK(TMP,"",3,3,"0123456789"));
   System.out.println("----------------------------------------------------");
   //....................................................................................
   P = BuscarCodigo(TMP);
   if(P>0) {
      RAF = new RandomAccessFile(ARCHIVO,"rw");
      RAF.seek((P-1)*W);
      RAF.read(BUFFER);
      RECORD = LIB.BufferToString(BUFFER);
      LoadFields();
      if(FLAG!='*') {
         ViewFields();
      }
      else {
         System.out.println("ERROR: El Registro ha sido Eliminado");
      }
      System.out.println("----------------------------------------------------");
   }
   else {
      System.out.println("ERROR: El codigo especificado No Existe");
   }
   System.out.println("\n\nPulse [ENTER] para Salir!!!");
   SCN.nextLine();
}*/
//-----------------------------------------------
public static void Listado() throws IOException, InterruptedException {
String TMP;
long T,N;
   LIB.ClearScreen();
   System.out.println("LISTADO DE usuarios");
   System.out.println("====================================================");
   //....................................................................................
   RAF = new RandomAccessFile(ARCHIVO, "r");
    T = RAF.length();
    System.out.println(T);
    N = T / W;
    System.out.println(N);
    for (int i = 1; i <= N; i++) {
        RAF.seek((i - 1) * W);
        RAF.read(BUFFER);
        RECORD = LIB.BufferToString(BUFFER);
        LoadFields();
        System.out.println(i + "!!!!!");
        if (ESTADO != '0') { // Solo mostrar si activo
            System.out.println(
                ID+ ' ' +
                NOMBRE+ ' ' +
                USUARIO+ ' ' +
                PSWD+ ' ' +
                FECHA_INI+ ' ' +
                HORA_INI+ ' ' +
                FECHA_FIN+ ' ' +
                HORA_FIN+ ' ' +
                (ESTADO == '1' ? "Activo" : "Inactivo"));
//            
        }
    }

    RAF.close();
    System.out.println("\n\nPulse [ENTER] para salir...");
    SCN.nextLine();
}
//-----------------------------------------------
public static char MenuPrincipal() throws IOException, InterruptedException {
String CAD;
      do {
         LIB.ClearScreen();
         System.out.println(" G E S T I O N   D E   P R O D U C T O S ");
         System.out.println("=========================================");
         System.out.println();
         System.out.println("      -----------------------------------");
         System.out.println("             MENU PRINCIPAL");
         System.out.println("      -----------------------------------");
         System.out.println("       1. Ingreso de Productos");
         System.out.println("       2. Modificacion de Productos");
         System.out.println("       3. Eliminacion de Productos");
         System.out.println("       4. Busqueda por Codigo/Nombre");
         System.out.println("       5. Listado de Productos");
         System.out.println("       6. Salir");
         System.out.println("      -----------------------------------");
         System.out.print  ("       SELECCIONE OPCION: ");
         CAD = SCN.nextLine();
      } while(!LIB.ValidacionOK(CAD,"",1,1,"123456"));
      return CAD.charAt(0);
}
//-----------------------------------------------

//-----------------------------------------------
} //class
