package BibelRA;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by dneubauer on 29.09.2015.
 */
public class start {
    public static void main(String[] args) {


        try (BufferedReader br = new BufferedReader(new FileReader("bibel.txt"))) {

            Pattern p = Pattern.compile("\\b([äüöÄÖÜ][a-zäöüß]+)|[a-zA-Z][a-z]*[äüöß][a-zäöüß]*");
            int zaehler = 0;


            String zeile;
            while ((zeile = br.readLine()) != null) {
                Matcher m = p.matcher(zeile);


                while (m.find())
                    zaehler++;

            }
            System.out.println("umlaute " + zaehler);


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}