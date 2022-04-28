public class CLinkedList {

    public CLinkedList() {
        this.tail = null;
        this.head = null;
    }

    public Node head;
    public Node tail;

    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
            newNode.next = head;
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head;
        }
    }

    public void add(int data, int index) {
        Node newNode = new Node(data);
        Node suanki = head;
        Node yedek = head;
        if (head == null) {
            head = newNode;
            tail = newNode;
            newNode.next = head;
        } else {
            index = index % this.size() - 1;
            for (int i = 0; i < index - 1; i++) {
                suanki = suanki.next;
                yedek = yedek.next;
            }
            yedek = yedek.next;
            suanki.next = newNode;
            newNode.next = yedek;
        }
    }


    public int size() {
        int size = 0;
        Node suanki = head;
        if (head != null) {
            do {
                size++;
                suanki = suanki.next;
            } while (suanki != head);
        }
        return size;
    }

    public void show() {
        Node suanki = head;
        if (head == null) {
            System.out.println("Liste malesef boş");
        } else {
            do {
                System.out.print(" " + suanki.data);
                suanki = suanki.next;
            } while (suanki != head);
            System.out.println();
        }
    }

    public void delete(int index) {
        Node suanki = head;
        Node yedek = head;
        if (head != null) {
            index = index % this.size() - 1;
            for (int i = 0; i < index - 1; i++) {
                suanki = suanki.next;
            }
            for (int i = 0; i < index + 1; i++) {
                yedek = yedek.next;
            }
            suanki.next = yedek;

        } else {
            System.out.println("Bu Liste Zaten Boş");
        }

    }

    public static void main(String[] args) {
        CLinkedList cl = new CLinkedList();
        cl.add(1);
        cl.add(2);
        cl.add(3);
        cl.add(4);
        System.out.println("*********");
        System.out.println(cl.size());
        System.out.println("*********");
        cl.delete(15);
        cl.show();
    }
}

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
    }
}
