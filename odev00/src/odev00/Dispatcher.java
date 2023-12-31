package odev00;public class Dispatcher {
    private DoublyLinkedList realTimeQueue;
    private DoublyLinkedList userProcessQueue;

    // Sistem kaynakları
    private Resource printer;
    private Resource scanner;
    private Resource modem;
    private Resource cdDrive;

    public Dispatcher() {
        realTimeQueue = new DoublyLinkedList();
        userProcessQueue = new DoublyLinkedList();
        // Kaynakların başlangıç değerleri
        printer = new Resource(2);
        scanner = new Resource(1);
        modem = new Resource(1);
        cdDrive = new Resource(2);
    }

    // Prosesi uygun kuyruğa ekleyen metod
    public void addProcess(Process proses) {
        if (proses.getOncelik() == 0) {
            realTimeQueue.addLast(proses);
        } else {
            userProcessQueue.addLast(proses);
        }
    }

    // Kaynak tahsisini kontrol etme
    public boolean checkResourceAvailability(Process proses) {
        return printer.isAvailable(proses.getPrinterNeeds()) &&
               scanner.isAvailable(proses.getScannerNeeds()) &&
               modem.isAvailable(proses.getModemNeeds()) &&
               cdDrive.isAvailable(proses.getCdDriveNeeds());
    }

    // Proses için kaynak tahsis etme
    public void allocateResources(Process proses) {
        printer.allocate(proses.getPrinterNeeds());
        scanner.allocate(proses.getScannerNeeds());
        modem.allocate(proses.getModemNeeds());
        cdDrive.allocate(proses.getCdDriveNeeds());
    }

    // Proses kaynaklarını serbest bırakma
    public void releaseResources(Process proses) {
        printer.release(proses.getPrinterNeeds());
        scanner.release(proses.getScannerNeeds());
        modem.release(proses.getModemNeeds());
        cdDrive.release(proses.getCdDriveNeeds());
    }

    // Prosesleri çalıştırma (basit bir örnek)
    public void dispatchProcesses() {
        System.out.println("Gerçek Zamanlı Prosesler İşleniyor...");
        while (!realTimeQueue.isEmpty()) {
            Process proses = realTimeQueue.removeFirst();
            if (checkResourceAvailability(proses)) {
                allocateResources(proses);
                System.out.println("Çalıştırılan Gerçek Zamanlı Proses: " + proses);
                releaseResources(proses);
            }
        }

        System.out.println("Kullanıcı Prosesleri İşleniyor...");
        while (!userProcessQueue.isEmpty()) {
            Process proses = userProcessQueue.removeFirst();
            if (checkResourceAvailability(proses)) {
                allocateResources(proses);
                System.out.println("Çalıştırılan Kullanıcı Prosesi: " + proses);
                releaseResources(proses);
            }
        }
    }


    // Diğer yardımcı metodlar ve işlevsellikler...
}
