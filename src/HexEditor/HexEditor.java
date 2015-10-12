package HexEditor;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;


public class HexEditor {

    public static void main(String[] args) {

        int anzahl;
        byte[] array = new byte[16];
        int zaehler = 0;
        int zahl;
        String text = "";


        try (BufferedInputStream bis = new BufferedInputStream(
                new FileInputStream("Nationalhymne.txt"))) {

            System.out.println("\n\n" + "\t\t" + "Offset" + "\t" + "|" + "\t" +
                    "00  01  02  03  04  05  06  07  08  09  " +
                    "0A  0B  0C  0D  0E  0F" + "\t" + "|" + "\t\t" +
                    "UTF 8");

            System.out.println("-----------------------------------------------------" +
                    "---------------------------------------------------");

            while ((anzahl = bis.read(array)) == 16) {

                System.out.print("\t\t" + Integer.toHexString(zaehler) + "\t\t" + "|" + "\t");

                for (byte b : array) {

                    zahl = ((int) b < 0) ? (int) b & 0xFF : (int) b;        //Sorgt dafuer dass keine negativen Zahlen vorkommen

                    String hex = Integer.toHexString(zahl).toUpperCase();   //Macht aus der Zahl einen HEXString

                    hex = (hex.length() < 2) ? "0" + hex : hex;             //Aendert Strings mit nur einem Zeichen zu String mit 2 Zeichen

                    System.out.print(hex + "  ");

                    if (zahl > 31 && zahl < 127)         //Filtert Absaetze und Sonderzeichen raus
                        text = text + (char) zahl;
                    else
                        text = text + "*";

                }

                zaehler += 16;    //Zaehler fuer die OffsetSpalte
                System.out.print("|" + "  " + text + "\n");
                text = "";

            }//Ende der WhileSchleife


            //Fuer letzten Stream ohne 16 Bytes
            System.out.print("\t\t" + Integer.toHexString(zaehler) + "\t\t" + "|" + "\t");

            for(int i =0;i<anzahl;i++){

                zahl = ((int) array[i] < 0) ? (int) array[i] & 0xFF : (int) array[i];

                String hex = Integer.toHexString(zahl).toUpperCase();

                hex = (hex.length() < 2) ? "0" + hex : hex;

                System.out.print(hex + "  ");

                if (zahl > 31 && zahl < 127)
                    text = text + (char) zahl;
                else
                    text = text + "*";
            }


            //Fuellt Letzte Zeile am Ende mit Leerzeichen auf
            for(int i=16-anzahl;i>0;i--){
                System.out.print("    ");
            }

            //Fuellt den UTF-8 Text in der letzten Zeile auf
            System.out.println("|  "+text);

        } catch (IOException e) {
            System.out.println("Datei wurde nicht gefunden");
        }


    }


}






