package Modul3.codelab;

import java.util.LinkedList;
import java.util.Queue;
public class ContohQueue {
    public static void main(String[] args) {
        Queue q = new LinkedList();

        q.add("Nergigante");
        q.add("Malzeno");
        q.add("Safi'jiva");
        q.add("Alatreon");
        q.add("Fatalis");
        q.add("Gozmagorn");

        System.out.println("Peek : " + q.peek());
        System.out.println("Elder Dragon : " + q);

        q.poll();
        q.poll();

        System.out.println("Elder Dragon : " + q);
    }
}
