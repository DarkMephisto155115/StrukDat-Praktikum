package Modul3.codelab;
import java.util.Stack;
public class StackLibrary {
    public static void main(String[] args) {
        Stack s = new Stack();

        System.out.println(s.empty());

        s.push("Nergigante");
        s.push("Malzeno");
        s.push("Safi'jiva");
        s.push("Alatreon");
        s.push("Fatalis");
        s.push("Gozmagorn");

        System.out.println(s.empty());

        System.out.println("Peek : " + s.peek());
        System.out.println("Elder Dragon : " + s);

        s.pop();
        s.pop();

        System.out.println("Elder Dragon : "+ s);
        System.out.println("Position of Malzeno : "+ s.search("Malzeno"));

    }
}
