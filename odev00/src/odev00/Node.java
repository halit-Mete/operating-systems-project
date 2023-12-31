package odev00;

public class Node {
    Process proses;
    Node next;
    Node prev;

    public Node(Process proses) {
        this.proses = proses;
        this.next = null;
        this.prev = null;
    }
}
