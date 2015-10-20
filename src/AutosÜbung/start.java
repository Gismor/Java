package AutosÜbung;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by dneubauer on 20.10.2015.
 */
public class start {

    public static void main(String[] args) {

        String pfad = "Y:/3_XI/XI_6/302_SOP_OOP/Autos/Autos_";
        int zahl = 0;
        int anzahl = 0;

        while (zahl++ < 256) {


            try (BufferedReader br = new BufferedReader(new FileReader(pfad + zahl + ".txt"))) {
                String zeile = null;
                while ((zeile = br.readLine()) != null)
                    System.out.println(zeile);

                System.out.println("Es wurden " + anzahl++ + " Dateien eingelesen");


            } catch (IOException e) {
                System.out.println("Fehler beim Lesen ...");
            }
        }


    }
}
