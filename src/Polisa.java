import java.util.Objects;

public class Polisa {
    private String numerPolisy;
    private String klient;
    private double skladkaBazowa;
    private int poziomRyzyka;
    private double wartoscPojazdu;
    private boolean czyMaAlarm;
    private boolean czyBezszkodowyKlient;
    private static int liczbaUtworzonychPolis =0;
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

        double koncowa = skladkaBazowa + OPLATA_ADMINISTRACYJNA;
        koncowa += (poziomRyzyka*120.0);    //+za ryzyko

        if(wartoscPojazdu>500 000){     //jak droższy niz 500 000 to +150
            koncowa+=150.0
        }

        if(czyMaAlarm){
            koncowa-=25;
        }

        if(czyBezszkodowyKlient){
            koncowa*=0.90;
        }

        return Math.max(koncowa, skladkaBazowa);    //koncowa nie może być mniejsza niż bazowa
    }

    public double obliczSkladkeOdnowieniowa(){
        double biezaca = obliczSkladkeKoncowa();
        double odnowa = biezaca;

        if(poziomRyzyka == 4){
            odnowa *= 1.10;      //poziom ryzyka wiecej niz 4 = +10%
        }
        if(poziomRyzyka >=5) {
            odnowa *= 1.10;
        }

        if (wartoscPojazdu>500 000){
            odnowa += 150;
        }

        if(czyBezszkodowyKlient){
            odnowa *= 0.92;
        }

        if(czyMaAlarm){
            odnowa *= 0.95;
        }

        if(odnowa<biezaca*0.90){
            odnowa = biezaca*0.90;
        }

        if(odnowa>biezaca*1.25){
            odnowa = biezaca*1.25;
        }

        return Math.round(odnowa*100.0)/100.0;
    }

    public String pobierzPodsumowanieRyzyka(){
        return "Polisa: " +numerPolisy+ ", Poziom ryzyka: " +poziomRyzyka;
    }

    public static int pobierzLiczbeUtworzonychPolis(){
        return liczbaUtworzonychPolis;
    }


    public String getKlient() {
        return klient;
    }

    public String getNumerPolisy() {
        return numerPolisy;
    }

    public int getPoziomRyzyka() {
        return poziomRyzyka;
    }

    @Override
    public String toString(){
        return  "Polisa: "+ ", nr= " + numerPolisy + ", Klient: " +klient + ", Składka: " + obliczSkladkeKoncowa() +"zł";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o==null || getClass() != o.getClass()) return false;
        Polisa polisa = (Polisa) o;
        return Objects.equals(numerPolisy, polisa.numerPolisy);
    }

}
