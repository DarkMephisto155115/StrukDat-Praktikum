package Modul3.demo.Tugas1_tes;

import java.util.Scanner;

class Node {
    String url;
    Node next;

    public Node(String url) {
        this.url = url;
        this.next = null;
    }
}

public class MyStack {
    private Node currNode;
    private Node first;

    public MyStack() {
        currNode = null;
        first = null;
    }

    public void enterURL(String url) {
        Node newNode = new Node(url);
        if (currNode != null) {
            currNode.next = newNode;
        }
        currNode = newNode;
        if (first == null) {
            first = currNode;
        }
        System.out.println("Successfully visited URL: " + url);
    }

    public void mundur() {
        if (currNode == null || currNode == first) {
            System.out.println("No previous URL to go back to.");
        } else {
            Node temp = first;
            while (temp.next != currNode) {
                temp = temp.next;
            }
            currNode = temp;
            System.out.println("Going back to: " + currNode.url);
        }
    }

    public void maju() {
        if (currNode == null || currNode.next == null) {
            System.out.println("No forward URL available.");
        } else {
            currNode = currNode.next;
            System.out.println("Forward to: " + currNode.url);
        }
    }

    public String displayURL() {
        if (currNode != null) {
            return currNode.url;
        } else {
            return "No URL currently accessed.";
        }
    }

    public static void main(String[] args) {
        MyStack stack = new MyStack();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n1. Visit URL");
            System.out.println("2. Back");
            System.out.println("3. Forward");
            System.out.println("4. Current URL");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter URL to visit: ");
                    String url = scanner.nextLine();
                    stack.enterURL(url);
                    break;
                case 2:
                    stack.mundur();
                    break;
                case 3:
                    stack.maju();
                    break;
                case 4:
                    System.out.println("Current URL: " + stack.displayURL());
                    break;
                case 5:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
