/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pooveterinaria;
import java.io.IOException;

public class VET_Library {
//-----------------------------------------------
public VET_Library() {
}
//-----------------------------------------------
public String Replicate(char E, int N) {
String T;
    T = "";
    for(int i=1;i<=N;i++) {
    	T = T + E;
    }
    return T;
}
//-----------------------------------------------
public void ClearScreen() throws IOException, InterruptedException {
    new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
} 
//-----------------------------------------------
public int PosicionIzquierda(String CADENA, char E) {
int i,P,L;
    L = CADENA.length();
    P = -1;
    i = 0;
    while((i<=L-1)&&(P==-1)) {
       if(CADENA.charAt(i)==E) {
          P = i;
       }
       i++;
    }
    return P;
}
//-----------------------------------------------
public int TotalOcurrencias(String CADENA, char E) {
int C,L;
    L = CADENA.length();
    C = 0;
    for(int i=0;i<=L-1;i++) {
        if(CADENA.charAt(i)==E) {
           C = C + 1;
        }
    }
    return C;
}
//-----------------------------------------------
public boolean EsCadenaNumerica(String CAD) {
/*int i,L;
char E;
boolean Sw;
    L = CAD.length();
    Sw = true;
    i = 0;
    while((i<=L-1)&&(Sw==true)) {
      E = CAD.charAt(i);
      if(!(('0'<=E)&&(E<='9'))) {
         Sw = false;
      }
      i++;
    }
    return Sw;*/
    return InRange(CAD,"0123456789");
}

public boolean EsCadenaAlfabetica(String CAD) {
/*int i,L;
char E;
boolean Sw;
    L = CAD.length();
    Sw = true;
    i = 0;
    while((i<=L-1)&&(Sw==true)) {
      E = CAD.charAt(i);
      if(!((('a'<=E)&&(E<='z'))||
           (('A'<=E)&&(E<='Z'))
          )) {
         Sw = false;
      }
      i++;
    }
    return Sw;*/
    return InRange(CAD,"ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz");
}
//-----------------------------------------------
public boolean InRange(String CADENA, String RANGO){
int L,N,k,i;
char E;
boolean Sw,Hk;
    L = CADENA.length();
    N = RANGO.length();
    Sw = true;
    k = 0;
    while((k<=L-1)&&(Sw==true)){
        E = CADENA.charAt(k);
        Hk = false;
        i = 0;
        while((i<=N-1)&&(Hk==false)){
            if(RANGO.charAt(i)==E){
                Hk = true;
            }
            i++;
        }
        Sw = Hk;
        k++;
    }
    return Sw;
}
//-----------------------------------------------
public boolean ValidacionOK(String CADENA, String HKGZ,int SIZE1, int SIZE2, String RANGO) {
int L;
boolean Sw;
    Sw = false;
    L = CADENA.length();
    if(L>0) {
       if((SIZE1<=L)&&(L<=SIZE2)) {
          if(InRange(CADENA,RANGO)==true) {
              Sw = true;
          }
          else {
              if(HKGZ.length()>0) {
                 System.out.println("ERROR: " + HKGZ + " contiene caracteres incorrectos!!!");
              }
          }
       }
       else {
          if(HKGZ.length()>0) {
             System.out.println("ERROR: " + HKGZ + " tiene Longitud Incorrecta!!!");
          }
       }
    }
    else {
       if(HKGZ.length()>0) {
          System.out.println("ERROR: " + HKGZ + " tiene Longitud 0!!!");
       }
    }
    return Sw;
}
//-----------------------------------------------
public boolean FechaOK(String FECHA, int MinYear, int MaxYear, boolean HK) {
boolean Sw;
String DD,MM,YYYY;
int P,T,L,YEAR,MONTH,DAY,TOTAL=0;
    L = FECHA.length();
    Sw = false;
    if((8<=L)&&(L<=10)) {
       T = TotalOcurrencias(FECHA,'/');
       P = PosicionIzquierda(FECHA,'/');
       if((T==2)&&(0<P)&&(P<L-6)&&(FECHA.charAt(L-5)=='/')) {
           DD   = FECHA.substring(0,P);
           MM   = FECHA.substring(P+1,L-5);
           YYYY = FECHA.substring(L-4,L);
           if((EsCadenaNumerica(DD)==true)&&
                 (EsCadenaNumerica(MM)==true)&&
                 (EsCadenaNumerica(YYYY)==true)) {
               YEAR = Integer.parseInt(YYYY);
               if((MinYear<=YEAR)&&(YEAR<=MaxYear)) {
                   MONTH = Integer.parseInt(MM);
                   if((1<=MONTH)&&(MONTH<=12)) {
                      DAY = Integer.parseInt(DD);
                      if((MONTH==1)||(MONTH==3)||(MONTH==5)||(MONTH==7)||(MONTH==8)||(MONTH==10)||(MONTH==12)) {
                          TOTAL = 31;
                      }
                      else {
                         if((MONTH==4)||(MONTH==6)||(MONTH==9)||(MONTH==11)) {
                               TOTAL = 30;
                         }
                         else {
                            TOTAL =(((YEAR%4==0)&&(YEAR%100!=0))||((YEAR%400==0)&&(YEAR%100==0))?29:28);
                         }
                      }
                      Sw = ((1<=DAY)&&(DAY<=TOTAL));
                      if(!Sw&&HK) {
                          System.out.println("ERROR: El Dia es Incorrecto!!!"); 
                      }
                   }
                   else {
			    	   if(HK==true) {
                          System.out.println("ERROR: El Mes es Incorrecto!!!");
			           } 
                   }
               }
               else {
		    	   if(HK==true) {
                      System.out.println("ERROR: El Año es Incorrecto!!!");
		           } 
               }
           }
           else {
	     	   if(HK==true) {
                  System.out.println("ERROR: Existen Caracteres No Numericos");
	           } 
           }
       }
       else {
      	   if(HK==true) {
              System.out.println("ERROR: Los Delimitadores de Fecha son incorrectos!!!");
           } 
       }
    }
    else {
    	 if(HK==true) {
            System.out.println("ERROR: Longitud/Tamaño de Fecha es Incorrecta!!!");
         } 
    }
    return Sw;
}

//-----------------------------------------------
public byte[] StringToBuffer(String CADENA, int W) {
byte[] BUFFER = new byte[W];
int L = CADENA.length();
    for(int i=0;i<=L-1;i++) {
        BUFFER[i] = (byte)CADENA.charAt(i);
    }
   return BUFFER;
}
//-----------------------------------------------
public String BufferToString(byte[] BUFFER) {
String CADENA="";
int L = BUFFER.length;
   for(int i=0;i<=L-1;i++) {
       CADENA = CADENA + (char)BUFFER[i];
   }
   return CADENA;
}
//-----------------------------------------------
} //class
