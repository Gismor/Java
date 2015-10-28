package AutoGruetze;

/**
 * Created by dneubauer on 28.10.2015.
 */
public class Auto implements Comparable<Auto> {
    String name,ort,schaltung,anbieter,ez,hu,km,preis,typ;


    public Auto(String name, String ort, String schaltung, String anbieter, String ez, String hu, String km, String preis, String typ) {
        this.name = name;
        this.ort = ort;
        this.schaltung = schaltung;
        this.anbieter = anbieter;
        this.ez = ez;
        this.hu = hu;
        this.km = km;
        this.preis = preis;
        this.typ = typ;
    }

    @Override
    public String toString() {
        return "Auto{" +
                "name='" + name + '\'' +
                ", ort='" + ort + '\'' +
                ", km='" + km + '\'' +
                ", preis='" + preis + '\'' +
                ", typ='" + typ + '\'' +
                ", schaltung='" + schaltung + '\'' +
                ", anbieter='" + anbieter + '\'' +
                ", ez='" + ez + '\'' +
                ", hu='" + hu + '\'' +
                '}';
    }



    public int compareTo(Auto a){
       /* int ret = this.vorkommen-w.getVorkommen();
        if(ret!=0)
            return ret;
        else{
            return this.name.compareTo(w.getName());
        }*/
        return 1;
    }
}