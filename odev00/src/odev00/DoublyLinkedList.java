package odev00;

public class DoublyLinkedList {
    private Node head;
    private Node tail;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    // Listenin sonuna bir düğüm ekleme
    public void addLast(Process proses) {
        Node newNode = new Node(proses);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    // Listenin başından bir düğüm silme
    public Process removeFirst() {
        if (head == null) return null;

        Node temp = head;
        head = head.next;

        if (head == null) {
            tail = null;
        } else {
            head.prev = null;
        }

        return temp.proses;
    }

    // Liste boş mu kontrol etme
    public boolean isEmpty() {
        return head == null;
    }

    // Liste içeriğini yazdırma (isteğe bağlı)
    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.println(current.proses);
            current = current.next;
        }
    }
}
