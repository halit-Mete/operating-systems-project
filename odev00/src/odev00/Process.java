package odev00;public 
class Process {
    private int id;
    private int varisZamani; // Varış zamanı
    private int oncelik; // Öncelik
    private int calisacagiSure; // Çalışacağı süre
    private int bellekIhtiyaci; // Bellek ihtiyacı

    // Kaynak ihtiyaçları
    private int printerNeeds;
    private int scannerNeeds;
    private int modemNeeds;
    private int cdDriveNeeds;

    // Constructor
    public Process(int id, int varisZamani, int oncelik, int calisacagiSure, int bellekIhtiyaci, 
                   int printerNeeds, int scannerNeeds, int modemNeeds, int cdDriveNeeds) {
        this.id = id;
        this.varisZamani = varisZamani;
        this.oncelik = oncelik;
        this.calisacagiSure = calisacagiSure;
        this.bellekIhtiyaci = bellekIhtiyaci;
        this.printerNeeds = printerNeeds;
        this.scannerNeeds = scannerNeeds;
        this.modemNeeds = modemNeeds;
        this.cdDriveNeeds = cdDriveNeeds;
    }

    // Getter ve Setter metodları
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVarisZamani() {
        return varisZamani;
    }

    public void setVarisZamani(int varisZamani) {
        this.varisZamani = varisZamani;
    }

    public int getOncelik() {
        return oncelik;
    }

    public void setOncelik(int oncelik) {
        this.oncelik = oncelik;
    }

    public int getCalisacagiSure() {
        return calisacagiSure;
    }

    public void setCalisacagiSure(int calisacagiSure) {
        this.calisacagiSure = calisacagiSure;
    }

    public int getBellekIhtiyaci() {
        return bellekIhtiyaci;
    }

    public void setBellekIhtiyaci(int bellekIhtiyaci) {
        this.bellekIhtiyaci = bellekIhtiyaci;
    }

    public int getPrinterNeeds() {
        return printerNeeds;
    }

    public void setPrinterNeeds(int printerNeeds) {
        this.printerNeeds = printerNeeds;
    }

    public int getScannerNeeds() {
        return scannerNeeds;
    }

    public void setScannerNeeds(int scannerNeeds) {
        this.scannerNeeds = scannerNeeds;
    }

    public int getModemNeeds() {
        return modemNeeds;
    }

    public void setModemNeeds(int modemNeeds) {
        this.modemNeeds = modemNeeds;
    }

    public int getCdDriveNeeds() {
        return cdDriveNeeds;
    }

    public void setCdDriveNeeds(int cdDriveNeeds) {
        this.cdDriveNeeds = cdDriveNeeds;
    }

    // toString Metodu (Proses bilgilerini yazdırmak için)
    @Override
    public String toString() {
        return "Process{" +
                "id=" + id +
                ", varisZamani=" + varisZamani +
                ", oncelik=" + oncelik +
                ", calisacagiSure=" + calisacagiSure +
                ", bellekIhtiyaci=" + bellekIhtiyaci +
                ", printerNeeds=" + printerNeeds +
                ", scannerNeeds=" + scannerNeeds +
                ", modemNeeds=" + modemNeeds +
                ", cdDriveNeeds=" + cdDriveNeeds +
                '}';
    }
}
