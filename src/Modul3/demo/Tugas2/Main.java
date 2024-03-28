package Modul3.demo.Tugas2;

import java.util.Scanner;
import java.util.Random;

class Tiket {
    private int noPemesanan;
    private int idTiket;
    private String nama;
    private int banyakTiket;

    public Tiket(String nama, int banyakTiket, int noPemesanan) {
        this.idTiket = generateTicketId();
        this.nama = nama;
        this.banyakTiket = banyakTiket;
        this.noPemesanan = noPemesanan;
    }

    private int generateTicketId() {
        Random random = new Random();
        return random.nextInt(1000);
    }

    public int getNoPemesanan() {
        return noPemesanan;
    }

    public int getIdTiket() {
        return idTiket;
    }

    public String getNama() {
        return nama;
    }

    public int getBanyakTiket() {
        return banyakTiket;
    }

    @Override
    public String toString() {
        return "ID tiket : "+ idTiket +", Nomor pemesanan : " + noPemesanan + ", Nama : " + nama + ", Banyak tiket : " + banyakTiket;
    }
}

class Queue {
    private static final int maxSize = 10;
    private Tiket[] queueArray;
    private int front;
    private int rear;
    private int nItem;

    public Queue() {
        queueArray = new Tiket[maxSize];
        front = 0;
        rear = -1;
        nItem = 0;
    }

    public void enqueue(Tiket tiket) {
        if (nItem == maxSize-1) {
            System.out.println("Antrian sudah penuh, tidak bisa menambahkan pesanan baru.");
            return;
        }
        rear = rear + 1;
        queueArray[rear] = tiket;
        nItem++;
        System.out.println("Tiket berhasil dipesan: " + tiket);
    }

    public Tiket dequeue(int ticketId) {
        if (isEmpty()) {
            System.out.println("Antrian kosong, tidak ada yang bisa dibatalkan.");
            return null;
        }
        int index = front;
        while (queueArray[index].getIdTiket() != ticketId) {
            index = (index + 1) % maxSize;
            if (index == rear) {
                System.out.println("Id tiket tidak ditemukan.");
                return null;
            }
        }
        Tiket removedTiket = queueArray[index];
        for (int i = index; i != rear; i = (i + 1) % maxSize) {
            queueArray[i] = queueArray[(i + 1) % maxSize];
        }
        rear = (rear - 1 + maxSize) % maxSize;
        nItem--;
        return removedTiket;
    }

    public void display() {
        System.out.println("Daftar Pemesanan Tiket:");
        if (isEmpty()) {
            System.out.println("Antrian kosong.");
            return;
        }
        int count = 0;
        int index = front;
        while (count < nItem) {
            System.out.println(queueArray[index]);
            index = (index + 1) % maxSize;
            count++;
        }
    }

    public boolean isEmpty() {
        return nItem == 0;
    }
}

public class Main {
    public static void main(String[] args) {
        Queue bookingQueue = new Queue();
        Scanner sc = new Scanner(System.in);
        int nomorPesanan = 1;
        while (true) {
            System.out.println("======================");
            System.out.println("\tAstral Express");
            System.out.println("======================");
            System.out.println("Menu:");
            System.out.println("1. Pesan Tiket");
            System.out.println("2. Lihat Pemesanan");
            System.out.println("3. Batalkan Pemesanan");
            System.out.println("0. Keluar");
            System.out.print("Pilih opsi: ");
            int choice = sc.nextInt();



            switch (choice) {
                case 1:
                    System.out.print("Masukkan nama pemesan: ");
                    String name = sc.next();
                    System.out.print("Masukkan jumlah tiket: ");
                    int quantity = sc.nextInt();
                    bookingQueue.enqueue(new Tiket(name, quantity,nomorPesanan++));
                    break;
                case 2:
                    bookingQueue.display();
                    break;
                case 3:
                    if (!bookingQueue.isEmpty()) {
                        System.out.print("Masukkan ID tiket yang ingin dibatalkan: ");
                        int ticketId = sc.nextInt();
                        Tiket canceledTiket = bookingQueue.dequeue(ticketId);
                        if (canceledTiket != null) {
                            System.out.println("Pemesanan tiket dibatalkan: " + canceledTiket);
                        }
                    } else {
                        System.out.println("Antrian masih kosong, tidak ada yang bisa dibatalkan.");
                    }
                    break;
                case 0:
                    System.out.println("Terima kasih!");
                    sc.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        }
    }
}