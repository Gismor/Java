package Autos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

/**
 * Created by dneubauer on 23.10.2015.
 */
public class Hilfsmethoden {

    public List<String> einlesen (List<String> liste){
        String zeile = "";
        String pfad = "Y:\\3_XI\\XI_6\\302_SOP_OOP\\Autos\\Autos_";
        int nummer = 0;

        while (nummer++ < 17) {

            try (BufferedReader br = new BufferedReader(new FileReader(pfad+ nummer + ".txt"))) {

                while ((zeile = br.readLine()) != null){
                    liste.add(zeile);
                }

            }  catch (IOException e) {
            }
        }
        return liste;
    }
}