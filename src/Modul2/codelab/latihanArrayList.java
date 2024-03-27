package Modul2.codelab;

import java.util.ArrayList;
public class latihanArrayList {
    public static void main(String[] args) {
        ArrayList<String> daftarNama = new ArrayList<>();

        daftarNama.add("Salam");
        daftarNama.add("Hasbi");
        daftarNama.add("Darma");
        daftarNama.add("Rusdany");

        System.out.println("Daftar Nama: ");
        for (String nama : daftarNama){
            System.out.println(nama);
        }

        System.out.println("\nElemen Pada Indeks 2: "+ daftarNama.get(2) + "\n");

        daftarNama.set(1, "Andika");

        System.out.println("Daftar Nama Setelah Perubahan: ");
        for (String nama : daftarNama){
            System.out.println(nama);
        }

        daftarNama.remove(0);

        System.out.println("\nDaftar Nama Setelah Penghapusan: ");
        for (String nama : daftarNama){
            System.out.println(nama);
        }

        System.out.println("\nJumlah Elemen Dalam ArrayList: "+ daftarNama.size());

        System.out.println("\nApakah Arraylist Kosong? "+ daftarNama.isEmpty());
    }
}
