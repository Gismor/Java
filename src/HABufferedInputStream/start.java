package HABufferedInputStream;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by dneubauer on 22.09.2015.
 */
public class start {
    public static void main(String[] args) {

        byte[] array = new byte[16];
        int anzahlRestBytes;
        int zahl;
        String text="";
        int zaehler = 0;


        try (BufferedInputStream bis = new BufferedInputStream(
                    new FileInputStream("Nationalhymne.txt"))){


            while((anzahlRestBytes=bis.read(array))==16){       // schreibt das array mit den bytes voll 16 alles was drunter ist wird in den rest bytes eingetragen und kommt zu for schleife

                System.out.print("\t" + Integer.toHexString(zaehler)+"\t|\t");  // 1 mal 16 bytes = zähler +1

                for(byte b:array){


                  zahl = ((int) b < 0) ? (int)b &0xFF : (int)b;    //  alles wird auf int gecastet wird geprüft ob negativ oder postitiv bei negativ ist bei negativ +255
                   String hex = Integer.toHexString(zahl).toUpperCase(); // wird in den string abgespeichert und großbuchstaben
                    if(hex.length()<2) {  // wenn kleiner als 2 wird ne 0 davor geschrieben
                        hex = "0"+hex;
                    }



                    System.out.print(hex+" "); // gibt hex mit 2 leerzeichen aus


                    if(zahl>31  &&zahl<127) {  //jeder integer wird wieder zum buchstaben konventiert und schaut in der utf 8
                        char c = (char) zahl;  // jedes wird einzeln abgeprüft und immer in den string abgespeichert
                        text = text + c;


                    }else{
                        text=text+".";  // alles was nicht zwischen 31 und 127 ist wird als punkt dargestellt
                    }

                }



                System.out.println("  |  "+text);  // text wird übertragen
                text="";   // string wird leer gemacht

                zaehler=zaehler+16;
            }

            System.out.print("\t" + Integer.toHexString(zaehler)+"\t|\t");

            for (int i = 0; i < anzahlRestBytes ; i++) {
                zahl = ((int)array[i] < 0) ? (int)array[i] &0xFF : (int)array[i];
                String hex = Integer.toHexString(zahl).toUpperCase();
                if(hex.length()<2) {
                    hex = "0"+hex;
                }
                System.out.print(hex+" ");


                if(zahl>31  &&zahl<127) {
                    char c = (char) zahl;
                    text = text + c;
                }else{
                    text=text+".";
                }

            }

            for (int i = 16-anzahlRestBytes; i > 0 ; i--) {
                System.out.print("   ");
            }
            System.out.print("  |  "+text);









        } catch (IOException e) {
            System.out.println("Datei nicht gefunden");
        }


    }
}
