public class Heilpflanze {
    protected String intName;
    protected String name;
    protected String teename;
    protected String phytopharmakum;
    protected String zubereitungsmethode;
    protected String indikation;
    protected String kontraindikation;
    protected String bild;
    protected String nebenwirkungen;
    protected String stammpflanze;
    protected String pflanzenfamilie;
    protected String rechteAmBild;

    public Heilpflanze(String intName, String name, String teename, String phytopharmakum, String zubereitungsmethode,
                       String indikation, String kontraindikation, String bild, String nebenwirkungen,
                       String stammpflanze, String rechteAmBild, String pflanzenfamilie) {
        this.intName = intName;
        this.name = name;
        this.teename = teename;
        this.phytopharmakum = phytopharmakum;
        this.zubereitungsmethode = zubereitungsmethode;
        this.indikation = indikation;
        this.kontraindikation = kontraindikation;
        this.bild = bild;
        this.nebenwirkungen = nebenwirkungen;
        this.stammpflanze = stammpflanze;
        this.pflanzenfamilie = pflanzenfamilie;
        this.rechteAmBild = rechteAmBild;
    }

    public void printInfo() {
        System.out.println("\n--- " + name + " ---");
        System.out.println("Teename: " + teename);
        System.out.println("Phytopharmakum: " + phytopharmakum);
        System.out.println("Zubereitungsmethode: " + zubereitungsmethode);
        System.out.println("Indikation: " + indikation);
        System.out.println("Kontraindikation: " + kontraindikation);
        System.out.println("Bild: " + bild);
        System.out.println("Nebenwirkungen: " + nebenwirkungen);
        System.out.println("Stammpflanze: " + stammpflanze);
        System.out.println("Pflanzenfamilie: " + pflanzenfamilie);
        System.out.println("Rechte am Bild: " + rechteAmBild);
        System.out.println("--------------------------");
    }
}