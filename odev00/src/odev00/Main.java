package odev00;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Dispatcher dispatcher = new Dispatcher();

        System.out.println("Prosesler okunuyor ve Dispatcher'a ekleniyor...");
        readAndDispatchProcesses("giris.txt", dispatcher);

        System.out.println("Prosesler işlenmeye başlıyor...");
        dispatcher.dispatchProcesses();

        System.out.println("Tüm prosesler işlendi.");
    }

    private static void readAndDispatchProcesses(String fileName, Dispatcher dispatcher) {
        try {
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);

            int id = 1; // ID'yi 1'den başlatıyoruz ve her proses için artırıyoruz

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(", ");

                int varisZamani = Integer.parseInt(parts[0]);
                int oncelik = Integer.parseInt(parts[1]);
                int calisacagiSure = Integer.parseInt(parts[2]);
                int bellekIhtiyaci = Integer.parseInt(parts[3]);
                int printerNeeds = Integer.parseInt(parts[4]);
                int scannerNeeds = Integer.parseInt(parts[5]);
                int modemNeeds = Integer.parseInt(parts[6]);
                int cdDriveNeeds = Integer.parseInt(parts[7]);

                Process process = new Process(id, varisZamani, oncelik, calisacagiSure, bellekIhtiyaci,
                                              printerNeeds, scannerNeeds, modemNeeds, cdDriveNeeds);
                dispatcher.addProcess(process);

                id++; // Sonraki proses için ID'yi artır
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
