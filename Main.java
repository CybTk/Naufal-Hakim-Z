// Main.java
import java.util.Scanner;

class Barang { // Parent class
    String kodeBarang;
    String namaBarang;
    double hargaBarang;

    public Barang(String kodeBarang, String namaBarang, double hargaBarang) {
        this.kodeBarang = kodeBarang;
        this.namaBarang = namaBarang;
        this.hargaBarang = hargaBarang;
    }

    public double hitungTotal(int jumlahBeli) {
        return jumlahBeli * hargaBarang;
    }
}

class Faktur extends Barang { // Child class inheriting Barang
    String noFaktur;

    public Faktur(String noFaktur, String kodeBarang, String namaBarang, double hargaBarang) {
        super(kodeBarang, namaBarang, hargaBarang); // Call parent class constructor
        this.noFaktur = noFaktur;
    }

    public void cetakFaktur(int jumlahBeli) {
        double total = hitungTotal(jumlahBeli);
        System.out.println("\n=== Faktur Pembelian ===");
        System.out.println("No Faktur   : " + noFaktur);
        System.out.println("Kode Barang : " + kodeBarang);
        System.out.println("Nama Barang : " + namaBarang);
        System.out.println("Harga Barang: Rp " + hargaBarang);
        System.out.println("Jumlah Beli : " + jumlahBeli);
        System.out.println("Total       : Rp " + total);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            // Input No Faktur
            System.out.print("Masukkan No Faktur: ");
            String noFaktur = scanner.nextLine();

            // Input Kode Barang
            System.out.print("Masukkan Kode Barang: ");
            String kodeBarang = scanner.nextLine();

            // Input Nama Barang
            System.out.print("Masukkan Nama Barang: ");
            String namaBarang = scanner.nextLine();

            // Input Harga Barang
            System.out.print("Masukkan Harga Barang: ");
            double hargaBarang = Double.parseDouble(scanner.nextLine());
            if (hargaBarang < 0) {
                throw new IllegalArgumentException("Harga barang tidak boleh negatif!");
            }

            // Input Jumlah Beli
            System.out.print("Masukkan Jumlah Beli: ");
            int jumlahBeli = Integer.parseInt(scanner.nextLine());
            if (jumlahBeli <= 0) {
                throw new IllegalArgumentException("Jumlah beli harus lebih dari 0!");
            }

            // Membuat objek Faktur
            Faktur faktur = new Faktur(noFaktur, kodeBarang, namaBarang, hargaBarang);

            // Cetak Faktur
            faktur.cetakFaktur(jumlahBeli);
        } catch (NumberFormatException e) {
            System.out.println("Input harus berupa angka untuk harga barang atau jumlah beli!");
        } catch (IllegalArgumentException e) {
            System.out.println("Kesalahan: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Terjadi kesalahan: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
