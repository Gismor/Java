package Autos;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dneubauer on 23.10.2015.
 */
public class main {

    public static void main(String[] args) {

        List<String> zeilen = new ArrayList<>();
        Hilfsmethoden hilfsmethoden = new Hilfsmethoden();
        Auto auto = new Auto();

        zeilen = hilfsmethoden.einlesen(zeilen);

        for (String i : zeilen)
            System.out.println(i);

        for (int index=0; index<zeilen.size(); index++) {
            String ort = zeilen.get(index);
            if (ort.matches("^DE.\\d{5}.*")) {
                auto.setName(zeilen.get(index - 1));
                int stelle = 0;
                if(ort.length() != ort.indexOf(","))
                    stelle = ort.indexOf(",");
                else stelle = ort.length();
                auto.setOrt(ort.substring(0, stelle));
                /*auto.setPreis(zeilen.get(index+1));*/
                for (int i=index+1; ;i++) {
                    String zeile = zeilen.get(i);
                    if (zeile.startsWith("Finanzierung, Versicherung"))
                        break;
                    else
                        System.out.println(zeile);

                }
            }
        }


        for (int index=0; index<zeilen.size(); index++) {
            String preis = zeilen.get(index);
            if (preis.matches("^\\d+\\s€$")) {
                auto.setPreis(preis);

                for (int i=index+1; ;i++) {
                    String zeile = zeilen.get(i);
                    if (zeile.startsWith("Finanzierung, Versicherung"))
                        break;
                    else
                        System.out.println(zeile);

                }
            }
        }

        System.out.println("Auto: "+auto.getName());
        System.out.println("Ort: "+auto.getOrt());
        System.out.println("Preis: "+auto.getPreis());

    }

}
