package Modul3.demo.Tugas2;

import java.util.Scanner;

class Tiket {
    String nama;
    int jumlahTiket;
    int nomorPemesanan;

    Tiket(String nama, int jumlahTiket, int nomorPemesanan) {
        this.nama = nama;
        this.jumlahTiket = jumlahTiket;
        this.nomorPemesanan = nomorPemesanan;
    }

    public String toString() {
        return "Nomor Pemesanan: " + nomorPemesanan + ", Nama Pemesan: " + nama + ", Jumlah Tiket: " + jumlahTiket;
    }
}

class Queue {
    public Tiket[] queueArray;
    private int maxSize;
    private int front;
    private int rear;
    public int nItems;

    public Queue(int size) {
        maxSize = size;
        queueArray = new Tiket[maxSize];
        front = 0;
        rear = -1;
        nItems = 0;
    }

    public void insert(String namaPemesan, int jumlahTiket, int nomorPemesanan) {
        if (rear == maxSize - 1) // Jika rear telah mencapai batas maksimum
            rear = -1; // Kembali ke awal array
        queueArray[++rear] = new Tiket(namaPemesan, jumlahTiket, nomorPemesanan);
        nItems++;
    }

    public Tiket remove() {
        Tiket temp = queueArray[front++];
        if (front == maxSize) // Jika front mencapai batas maksimum
            front = 0; // Kembali ke awal array
        nItems--;
        return temp;
    }

    public boolean isEmpty() {
        boolean isTrue = false;
        if (nItems == 0){
            isTrue = true;
        }
        return isTrue;
    }

    public boolean isFull() {
        boolean isTrue = false;
        if (nItems == maxSize){
            isTrue = true;
        }
        return isTrue;
    }

    public void Display(){
        int i = front;

        while (true){
            while (i != rear){
                System.out.println(queueArray[i]);
                if (i == maxSize-1){
                    i = 0;
                }else {
                    i++;
                }

            }

        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan kapasitas antrian: ");
        int maxSize = scanner.nextInt();
        Queue queue = new Queue(maxSize);

        int nomorPemesanan = 1;

        while (true) {
            System.out.println("\nPilih menu:");
            System.out.println("1. Pesan tiket");
            System.out.println("2. Lihat antrian");
            System.out.println("3. Hapus pemesanan");
            System.out.println("4. Keluar");
            System.out.print("Pilihan Anda: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    if (queue.isFull()) {
                        System.out.println("Antrian sudah penuh!");
                    } else {
                        scanner.nextLine(); // Membersihkan buffer
                        System.out.print("Masukkan nama pemesan: ");
                        String namaPemesan = scanner.nextLine();
                        System.out.print("Masukkan jumlah tiket: ");
                        int jumlahTiket = scanner.nextInt();

                        queue.insert(namaPemesan, jumlahTiket, nomorPemesanan++);
                        System.out.println("Pemesanan berhasil ditambahkan.");
                    }
                    break;
                case 2:
                    if (queue.isEmpty()) {
                        System.out.println("Antrian kosong.");
                    } else {
                        queue.Display();
                    }
                    break;
                case 3:
                    if (queue.isEmpty()) {
                        System.out.println("Antrian kosong.");
                    } else {
                        Tiket removedTiket = queue.remove();
                        System.out.println("Pemesanan dengan nomor " + removedTiket.nomorPemesanan + " telah dihapus.");
                    }
                    break;
                case 4:
                    System.out.println("Terima kasih!");
                    System.exit(0);
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }
}
