package Modul3.demo.Tugas1;

import java.util.ArrayList;
import java.util.Scanner;

class MyStack {
    private ArrayList<String> historyURL;
    private int currIdx;

    public MyStack() {
        historyURL = new ArrayList<>();
        currIdx = -1;
    }

    public void enterURL(String url) {
        historyURL.subList(currIdx + 1, historyURL.size()).clear(); // Menghapus riwayat setelah URL saat ini
        historyURL.add(url);
        currIdx++;
        System.out.println("\nMasuk ke URL: " + url);
    }



    public void maju() {
        if (currIdx < historyURL.size() - 1) {
            currIdx++;
            System.out.println("\nMaju ke URL : " + historyURL.get(currIdx));
        } else {
            System.out.println("\nTidak ada URL yang bisa dimajukan lagi");
        }
    }

    public void mundur() {
        if (currIdx > 0) {
            currIdx--;
            System.out.println("\nKembali ke URL : " + historyURL.get(currIdx));
        } else {
            System.out.println("\nTidak ada URL yang bisa dimundurkan lagi");
        }
    }

    public String displayURL() {
        if (currIdx >= 0 && currIdx < historyURL.size()) {
            return historyURL.get(currIdx);
        } else {
            return "\nNo URL currently accessed";
        }
    }
}

public class Main {
    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        Scanner sc = new Scanner(System.in);


        boolean isRunning = true;
        try {
            while (isRunning) {
                System.out.println("\n=======================");
                System.out.println("\tTerra Brain WEB");
                System.out.println("=======================");
                System.out.println("1. Masukkan URL");
                System.out.println("2. Maju");
                System.out.println("3. Mundur");
                System.out.println("4. Display URL");
                System.out.println("0. Exit");
                System.out.println("=====================");
                System.out.println("Pilih salah satu");
                System.out.println("=====================");

                int pilihan = sc.nextInt();
                switch (pilihan) {
                    case 1:
                        System.out.println("Masukkan URL yang diinginkan : ");
                        String URL = sc.next();
                        myStack.enterURL(URL);
                        break;
                    case 2:
                        myStack.maju();
                        break;
                    case 3:
                        myStack.mundur();
                        break;
                    case 4:
                        System.out.println("\nURL Sekarang: " + myStack.displayURL());
                        break;
                    case 0:
                        isRunning = false;
                        break;
                    default:
                        System.out.println("Input salah");
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}

