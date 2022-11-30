public class Universite {
    private String univercity;
    private String bolum;
    private  int ogrSyisi;
    private int notOrt;

    //parametresiz contructor
    public Universite() {
    }

    //parametreli  constructor
    public Universite(String univercity, String bolum, int ogrSyisi, int notOrt) {
        this.univercity = univercity;
        this.bolum = bolum;
        this.ogrSyisi = ogrSyisi;
        this.notOrt = notOrt;
    }

    //GETTER SETTER
    public String getUnivercity() {
        return univercity;
    }

    public void setUnivercity(String univercity) {
        this.univercity = univercity;
    }

    public String getBolum() {
        return bolum;
    }

    public void setBolum(String bolum) {
        this.bolum = bolum;
    }

    public int getOgrSyisi() {
        return ogrSyisi;
    }

    public void setOgrSyisi(int ogrSyisi) {
        this.ogrSyisi = ogrSyisi;
    }

    public int getNotOrt() {
        return notOrt;
    }

    public void setNotOrt(int notOrt) {
        this.notOrt = notOrt;
    }

    @Override
    public String toString() {
        return "Universite{" +
                "univercity='" + univercity + '\'' +
                ", bolum='" + bolum + '\'' +
                ", ogrSyisi=" + ogrSyisi +
                ", notOrt=" + notOrt +
                '}';
    }
}
