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


            Pattern p = Pattern.compile("((\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])\\.){3}(25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]\\d|\\d)");
            String zeile;
            int zaehler = 0;

            while ((zeile = br.readLine()) != null) {
                Matcher m = p.matcher(zeile);

                while (m.find())
                    zaehler ++;

            }

            System.out.println(zaehler);



            }catch(IOException e){
                System.out.println("Datei wurde nicht gefunden....");
            }



        }
    }

