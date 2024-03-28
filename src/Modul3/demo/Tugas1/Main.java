package Modul3.demo.Tugas1;

import java.util.Scanner;

class MyStack {
    private String[] data;
    private int top;
    private int size;

    public MyStack(int size) {
        this.size = size;
        data = new String[size];
        top = -1;
    }

    public void push(String newData) {
        if (!isFull()) {
            data[++top] = newData;
        } else {
            System.out.println("Stack sudah mencapai batas maksimum.");
        }
    }

    public String pop() {
        if (!isEmpty()) {
            return data[top--];
        } else {
            return null;
        }
    }

    public String peek() {
        if (!isEmpty()) {
            return data[top];
        } else {
            return null;
        }
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == size - 1;
    }

    public void reset() {
        top = -1;
    }

    public int getTop() {
        return top;
    }
}

class BrowserHistory {
    public MyStack pastStack;
    private MyStack futureStack;
    private int maxSize;

    public BrowserHistory() {
        maxSize = 10;
        pastStack = new MyStack(maxSize);
        futureStack = new MyStack(maxSize);
    }

    public void visitURL(String url) {
        pastStack.push(url);
        futureStack.reset();
        adjustStackSize();
    }

    private void adjustStackSize() {
        if (pastStack.getTop() == maxSize - 1) {
            maxSize *= 2;
            MyStack newHistoryStack = new MyStack(maxSize);
            while (!pastStack.isEmpty()) {
                newHistoryStack.push(pastStack.pop());
            }
            pastStack = newHistoryStack;
        }
    }

    public String kembali() {
        String currentURL = pastStack.pop();
        if (currentURL != null) {
            futureStack.push(currentURL);
            return currentURL;
        } else {
            return "Tidak ada URL sebelumnya dalam riwayat";
        }
    }

    public String maju() {
        String forwardURL = futureStack.pop();
        if (forwardURL != null) {
            pastStack.push(forwardURL);
            return forwardURL;
        } else {
            return "Tidak ada URL berikutnya dalam riwayat";
        }
    }

    public String getCurrentURL() {
        return pastStack.isEmpty() ? "Riwayat URL kosong" : pastStack.peek();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=============================");
        System.out.println("\t\tWandering Sea");
        System.out.println("=============================");
        System.out.println("Multiversal Search Engine");
        System.out.println("Powered by Terra Brain");
        System.out.println("=============================");
        BrowserHistory browser = new BrowserHistory();

        int pilihan = 0;
        boolean isRunning = true;
        while (isRunning) {
            System.out.println("Menu:");
            System.out.println("1. Kunjungi URL");
            System.out.println("2. Kembali");
            System.out.println("3. Maju");
            System.out.println("4. Tampilkan URL Saat Ini");
            System.out.println("5. Clear browser history");
            System.out.println("0. Keluar");

            System.out.print("Pilihan Anda: ");
            pilihan = scanner.nextInt();

            switch (pilihan) {
                case 1:
                    scanner.nextLine();
                    System.out.print("Masukkan URL: ");
                    String url = scanner.nextLine();
                    browser.visitURL(url);
                    System.out.println("Anda mengunjungi URL: " + url);
                    break;
                case 2:
                    System.out.println("Anda kembali ke URL: " + browser.kembali());
                    break;
                case 3:
                    System.out.println("Anda maju ke URL: " + browser.maju());
                    break;
                case 4:
                    System.out.println("URL Saat Ini: " + browser.getCurrentURL());
                    break;
                case 5:
                    browser.pastStack.reset();
                    System.out.println("History berhasil direset");
                    break;
                case 0:
                    System.out.println("Terima kasih!");
                    isRunning=false;
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan pilih lagi.");
            }
        }

        scanner.close();
    }
}
