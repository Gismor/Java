package bmpOeffnenUndSpeichern;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dneubauer on 25.09.2015.
 */
public class start {

    public static void main(String[] args) {

        List<byte[]> bytes = new ArrayList<>();


        try (BufferedInputStream bis = new BufferedInputStream(
                new FileInputStream("mond.bmp"))) {
            byte[] puffer = new byte[16];
            int anzahl;
            while ((anzahl = bis.read(puffer)) != -1 ){
                byte[] toStore = new byte[anzahl];
                for (int i = 0; i < anzahl ; i++) {
                    toStore[i] = puffer[i];
                    bytes.add(toStore);
                }
            }
        } catch (IOException e) {
            System.out.println("Fehler beim auslesen ...");
        }


        try (BufferedOutputStream bos = new BufferedOutputStream(
                new FileOutputStream("test_mond1.bmp"))){

            for (byte[] bs : bytes)
                bos.write(bs);


        } catch (IOException e){
            System.out.println("Fehler beim auslesen ...");
        }


    }
}
