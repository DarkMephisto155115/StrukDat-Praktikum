package Modul1.demo;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("==================");
        System.out.println("   TOKO KOMPUTER");
        System.out.println("==================");

        System.out.print("Masukkan Nama: ");
        String namaBarang = sc.nextLine();

        System.out.print("Masukkan Brand: ");
        String namaBrand = sc.nextLine();

        System.out.print("Masukkan Harga: ");
        int hargaBarang = sc.nextInt();

        JenisBarang jenisBarang = null;
        while (jenisBarang == null){
            System.out.println("\nPilih Jenis Barang:");
            System.out.println("1. CPU");
            System.out.println("2. RAM");
            System.out.println("3. VGA");
            System.out.println("4. SSD");
            System.out.println("5. HDD");
            System.out.println("6. PSU");
            System.out.println("7. CASING");
            System.out.println("8. FAN");
            System.out.print("Masukkan pilihan: ");
            int pilihanAngka = sc.nextInt();
            switch (pilihanAngka) {
                case 1:
                    jenisBarang = JenisBarang.CPU;
                    break;
                case 2:
                    jenisBarang = JenisBarang.RAM;
                    break;
                case 3:
                    jenisBarang = JenisBarang.VGA;
                    break;
                case 4:
                    jenisBarang = JenisBarang.SSD;
                    break;
                case 5:
                    jenisBarang = JenisBarang.HDD;
                    break;
                case 6:
                    jenisBarang = JenisBarang.PSU;
                    break;
                case 7:
                    jenisBarang = JenisBarang.CASING;
                    break;
                case 8:
                    jenisBarang = JenisBarang.FAN;
                    break;
                default:
                    System.out.println("\nInput Invalid!!!\n");
                    break;
            }
        }

        Barang<String, Integer,String> barang = new Barang<>(namaBarang, hargaBarang, namaBrand,jenisBarang);

        System.out.println("\nInformasi Barang : ");
        System.out.println("Nama Barang : " + barang.getNama());
        System.out.println("Nama Brand : " + barang.getBrand());
        System.out.println("Harga Barang : Rp. " + barang.getHarga());
        System.out.println("Jenis Barang : " + barang.getJenis());
        System.out.println("\nBerhasil diinputkan...");
        System.out.println("Terima kasih!!!");
    }
}
enum JenisBarang {CPU, RAM, VGA, SSD, HDD, PSU, CASING, FAN}

class Barang<X, Y,Z> {
    private X nama;
    private Y harga;
    private Z brand;
    private JenisBarang jenis;

    public Barang(X nama, Y harga,Z brand, JenisBarang jenis) {
        this.nama = nama;
        this.harga = harga;
        this.jenis = jenis;
        this.brand = brand;
    }

    public X getNama() {
        return nama;
    }

    public Y getHarga() {
        return harga;
    }

    public JenisBarang getJenis() {
        return jenis;
    }

    public Z getBrand() {
        return brand;
    }
}
