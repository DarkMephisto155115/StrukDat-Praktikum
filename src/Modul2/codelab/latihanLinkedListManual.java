package Modul2.codelab;

public class latihanLinkedListManual {
    public static void main(String[] args) {
        Node head = new Node(5);

        Node second = new Node(10);
        head.next = second;

        second.next = new Node(15);

        System.out.println("Daftar angka: ");
        Node current = head;
        while (current != null){
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();

        System.out.println("Elemen kedua: \n" + head.next.data);

        head.data = 25;

        System.out.println("Daftar angka setelah perubahan: ");

        current = head;
        while (current != null){
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();

        head.next = head.next.next;

        System.out.println("Daftar angka setelah penghapusan: ");
        current = head;
        while (current != null){
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}

class Node{
    int data;
    Node next;

    public Node(int data){
        this.data = data;
        this.next = null;
    }
}