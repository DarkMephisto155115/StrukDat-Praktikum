package Modul2.demo.Tugas2;

import java.util.Scanner;

class Node {
    private String nama;
    private String noTelp;
    Node next;

    public Node(String name, String phoneNumber) {
        this.nama = name;
        this.noTelp = phoneNumber;
        this.next = null;
    }

    public String getNama() {
        return nama;
    }

    public String getNoTelp() {
        return noTelp;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}

class MylinkedList {
    private Node first;
    private Node last;
    public MylinkedList() {
        first = null;
        last = null;
    }

    public void insertFirst(Node newNode) {
        if (first == null) {
            first = newNode;
            last = newNode;
        } else {
            newNode.next = first;
            first = newNode;
        }
        System.out.println("Kontak berhasil ditambahkan");
    }

    public void displayNode() {
        if (first == null) {
            System.out.println("Daftar kontak masih kosong!!!");
        } else {
            System.out.println("Daftar Kontak :");
            Node current = first;
            while (current != null) {
                System.out.println(current.getNama() + ": " + current.getNoTelp());
                current = current.getNext();
            }
        }
    }

    public void findNode(String name) {
        boolean ditemukan = false;
        Node current = first;
        while (current != null) {
            if (current.getNama().equalsIgnoreCase(name)) {
                System.out.println("Kontak ditemukan :");
                System.out.println(current.getNama() + ": " + current.getNoTelp());
                ditemukan = true;
                break;
            }
            current = current.getNext();
        }
        if (!ditemukan) {
            System.out.println("Kontak tidak ditemukan");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MylinkedList mylinkedList = new MylinkedList();

        boolean breakManual = false;
        while (!breakManual) {
            System.out.println("========================");
            System.out.println("\tManajemen Kontak");
            System.out.println("========================");
            System.out.println("1. Tambah Kontak");
            System.out.println("2. Tampilkan Kontak");
            System.out.println("3. Cari Kontak");
            System.out.println("0. Exit");
            System.out.print("Pilih menu : ");
            int pilihan = sc.nextInt();
            sc.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan nama kontak : ");
                    String nama = sc.nextLine();
                    System.out.print("Masukkan nomor telepon : ");
                    String noTelp = sc.nextLine();
                    mylinkedList.insertFirst(new Node(nama, noTelp));
                    break;
                case 2:
                    mylinkedList.displayNode();
                    break;
                case 3:
                    System.out.print("Masukkan nama kontak yang ingin dicari : ");
                    String searchName = sc.nextLine();
                    mylinkedList.findNode(searchName);
                    break;
                case 0:
                    System.out.println("Terima kasih Banyak!!!");
                    breakManual = false;
                    break;
                default:
                    System.out.println("Pilihan tidak invalid, Silakan sesuai pilihan diatas");
            }
        }
        sc.close();
    }
}
