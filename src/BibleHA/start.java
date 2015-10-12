package BibleHA;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by dneubauer on 07.10.2015.
 */
public class start {

    public static void main(String[] args) {


        HashMap<String, Integer> bibleMap = new HashMap<>();


        try (BufferedReader br = new BufferedReader(new FileReader("bibel.txt"))) {

            Pattern p = Pattern.compile("\\b([A-ZÖÄÜß]|[a-zöäüß])+\\b");
            String zeile;
            while ((zeile = br.readLine()) != null) {
                Matcher m = p.matcher(zeile);
                while (m.find()) {
                    String wort = m.group().toLowerCase();

                   if(bibleMap.containsKey(wort)){
                      int z = bibleMap.get(wort);
                       z++;
                       bibleMap.put(wort,z);
                   }else{
                       bibleMap.put(wort,1);

                   }

                }
            }

            TreeSet<Integer> werte = new TreeSet<>();


            for(Integer zahl: bibleMap.values()){
                werte.add(zahl);
            }

            for(Integer z:werte){

                for(String wort: bibleMap.keySet()){

                    if(bibleMap.get(wort)==z)
                        System.out.println(wort+ "  "+z);

                }
            }




        } catch (IOException e) {
            System.out.println("Datei wurde nicht gefunden");
        }

    }
}
