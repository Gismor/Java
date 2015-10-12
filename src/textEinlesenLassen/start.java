package textEinlesenLassen;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by dneubauer on 24.09.2015.
 */
public class start {

    public static void main(String[] args) {

        try (BufferedReader br = new BufferedReader(new FileReader("Nationalhymne.txt"))) {
            String zeile = null;
            while ((zeile = br.readLine()) != null)
                System.out.println(zeile);



        } catch (IOException e) {
            System.out.println("Fehler beim Lesen ...");
        }


    }
}
