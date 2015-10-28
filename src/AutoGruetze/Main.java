package AutoGruetze;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by dneubauer on 28.10.2015.
 */
public class Main {


    public static void main(String[] args) {
        List<String> zeilen = new ArrayList<>();
        String zeile = null;
        String datei = "Y:\\3_XI/XI_6/302_SOP_OOP/Autos/Autos_";
        /*String datei = "Autos_";*/
        int counter = 0;
        int anzahl=1;
        while (counter < 255) {
            counter++;
            String pfad = datei+counter;

            try (BufferedReader br = new BufferedReader(new FileReader(pfad+".txt"))) {

                while ((zeile = br.readLine()) != null) {
                    zeilen.add(zeile);
                    System.out.println("hinzugefügt");
                    // mach irgendwas
                    //System.out.println(zeile);
                }

                System.out.println("Anzahl:"+anzahl++);

            } catch (IOException e) {
                System.out.println("Datei gibt es nicht");
            }
        }
      /*  // inhalt ausgeben
        for(String s: zeilen)
            System.out.println(s);*/
        // jetzt auswerten
        List<Auto> fuhrpark = new ArrayList<>();

        // Liste mit matchern / regexes
        List<String> regularAusdruecke = new ArrayList<>();
        String matcherSchaltung="^Schaltgetriebe$|^Halbautomatik$|^Automatik$";
        String matcherAnbieter="^Händler$|^Privatanbieter$|^Firmenfahrzeuge$";
        String matcherEZ="^EZ .*\\d{4}$";
        String matcherHU="^HU .*\\d{4}$";
        String matcherKM="^\\d*.*km\\s*$|^\\d*\\.\\d*.*km\\s$";
        String matcherPreis="^\\d*.*\\d*.*€\\s*$";
        regularAusdruecke.add(matcherAnbieter);
        regularAusdruecke.add(matcherEZ);
        regularAusdruecke.add(matcherHU);
        regularAusdruecke.add(matcherKM);
        regularAusdruecke.add(matcherPreis);
        regularAusdruecke.add(matcherSchaltung);



        for (int index=0; index<zeilen.size(); index++) {

            String ort = zeilen.get(index);
            if (ort.matches("^DE - \\d{5} .*")) {

                String  name = zeilen.get(index-1);
                String  typ = zeilen.get(++index);
                index++;
                String aktuell;
                List<String> tmp= new ArrayList<>();
                for(String s:regularAusdruecke){
                    tmp.add(s);
                }


                for( ;;index++){

                    aktuell=zeilen.get(index);
                    if(aktuell.matches("^FinanzierungVersicherungParken$"))
                        break;
                    int count =0;
                    while( count<tmp.size()){
                        if(aktuell.matches(tmp.get(count))){
                            tmp.set(count,aktuell);


                        }
                        count++;
                    }
                }
                // Auto anlegen wegspeichern und variablen nullen
                for(int i=0;i<tmp.size();i++){
                    if(tmp.get(i).equals(regularAusdruecke.get(i)))
                        tmp.set(i," / ");
                }
                Auto neu = new Auto(name,ort,tmp.get(5),tmp.get(0),tmp.get(1),tmp.get(2),tmp.get(3),tmp.get(4),typ);
                fuhrpark.add(neu);

            }
        }

        for(Auto a:fuhrpark)
            System.out.println(a);

    }




}
