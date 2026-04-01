public class Polisa {
    private String numerPolisy;
    private String klient;
    private double skladkaBazowa;
    private int poziomRyzyka;
    private double wartoscPojazdu;
    private boolean czyMaAlarm;
    private boolean czyBezszkodowyKlient;
    private static int liczbaUtworzonychPolis;
    private static final double OPLATA_ADMINISTRACYJNA=100;

    public Polisa(String numerPolisy, String klient, double skladkaBazowa, int poziomRyzyka,
                  double wartoscPojazdu, boolean czyMaAlarm, boolean czyBezszkodowyKlient){
        this.numerPolisy=numerPolisy;
        this.klient=klient;
        this.skladkaBazowa=skladkaBazowa;
        this.poziomRyzyka=poziomRyzyka;
        this.wartoscPojazdu=wartoscPojazdu;
        this.czyMaAlarm=czyMaAlarm;
        this.czyBezszkodowyKlient=czyBezszkodowyKlient;
        liczbaUtworzonychPolis++;
    }
    public double obliczSkladkeKoncowa(){

    }



}
