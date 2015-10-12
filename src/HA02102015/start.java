package HA02102015;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dneubauer on 30.09.2015.
 */
public class start {
    public static void main(String[] args) {


        List<byte []> liste = new ArrayList<>();

        try(BufferedReader br = new BufferedReader(new FileReader("editor.txt"))) {

            String zeile;

            while((zeile=br.readLine())!=null) {
               zeile = zeile.split(": ")[1];
                zeile = zeile.split("  ")[0];

                String[] array = zeile.split(" ");

                byte[] bytearray = new byte[array.length];

                for (int i = 0; i<bytearray.length ; i++) {
                    bytearray[i] = (byte)Integer.parseInt(array[i], 16);
                }

                liste.add(bytearray);

            }

        } catch (IOException e) {
            System.out.println("Fehler beim Lesen ...");
        }

        try(BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("kopie.jpg"))){

            for (byte [] b : liste){
                bos.write(b);
            }

        } catch (IOException e) {
            System.out.println("Fehler beim Schreiben ...");
        }

    }
}
