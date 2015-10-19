package regexIP;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by dneubauer on 08.10.2015.
 */
public class start {

    public static void main(String[] args) {


        try (BufferedReader br = new BufferedReader(new FileReader("neu.log"))) {


            Pattern p = Pattern.compile("(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])\\." +
                    "(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])\\." +
                    "(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])\\. " +
                    "(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])");


            int zaehler = 0;


            String zeile;
            while ((zeile = br.readLine()) != null) {

                Matcher m = p.matcher(zeile);




            while (m.find()) {
                System.out.printf("%02X.%02X.%02X.%02X\n",
                        Integer.parseInt(m.group(1)),
                        Integer.parseInt(m.group(2)),
                        Integer.parseInt(m.group(3)),
                        Integer.parseInt(m.group(4)));


            }

            }


        } catch (IOException e) {
            System.out.println("Datei wurde nicht gefunden....");
        }


    }
}

