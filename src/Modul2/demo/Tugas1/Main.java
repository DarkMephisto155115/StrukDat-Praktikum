package Modul2.demo.Tugas1;

import java.util.ArrayList;
import java.util.Scanner;

class Kontak {
    private String nama;
    private String noTelp;

    public Kontak(String name, String phoneNumber) {
        this.nama = name;
        this.noTelp = phoneNumber;
    }

    public String getNama() {
        return nama;
    }

    public String getNoTelp() {
        return noTelp;
    }
}

class ManajemenKontak {
    private ArrayList<Kontak> kontak;

    public ManajemenKontak() {
        kontak = new ArrayList<>();
    }

    public void addKontak(Kontak kontak) {
        this.kontak.add(kontak);
        System.out.println("Kontak berhasil ditambahkan");
    }

    public void displayKontak() {
        if (kontak.isEmpty()) {
            System.out.println("Daftar kontak masih kosong!!!");
        } else {
            System.out.println("Daftar Kontak:");
            for (Kontak kontak : kontak) {
                System.out.println(kontak.getNama() + ": " + kontak.getNoTelp());
            }
        }
    }

    public void searchKontak(String name) {
        boolean ditemukan = false;
        for (Kontak kontak : kontak) {
            if (kontak.getNama().equalsIgnoreCase(name)) {
                System.out.println("Kontak ditemukan:");
                System.out.println(kontak.getNama() + ": " + kontak.getNoTelp());
                ditemukan = true;
                break;
            }
        }
        if (!ditemukan) {
            System.out.println("Kontak tidak ditemukan");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ManajemenKontak manajemenKontak = new ManajemenKontak();

        boolean breakManual = false;
        while (!breakManual) {
            System.out.println("========================");
            System.out.println("\tManajemen Kontak");
            System.out.println("========================");
            System.out.println("1. Tambah Kontak");
            System.out.println("2. Tampilkan Kontak");
            System.out.println("3. Cari Kontak");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu : ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Masukkan nama kontak : ");
                    String name = sc.nextLine();
                    System.out.print("Masukkan nomor telepon kontak : ");
                    String phoneNumber = sc.nextLine();
                    manajemenKontak.addKontak(new Kontak(name, phoneNumber));
                    break;
                case 2:
                    manajemenKontak.displayKontak();
                    break;
                case 3:
                    System.out.print("Masukkan nama kontak yang ingin dicari : ");
                    String searchName = sc.nextLine();
                    manajemenKontak.searchKontak(searchName);
                    break;
                case 0:
                    System.out.println("Terima kasih Banyak!!!");
                    breakManual = true;
                    break;
                default:
                    System.out.println("Pilihan tidak invalid, Silakan sesuai pilihan diatas");
            }
        }
        sc.close();
    }
}
