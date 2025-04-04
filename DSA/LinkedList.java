package DSA;

class Main {

    public static void main(String[] args) {

        LinkedList ll = new LinkedList();

        ll.add(2);
        ll.add(3);
        ll.print();

    }

}

class LinkedList {

    private Node head;

    LinkedList() {
        this.head = null;
    }

    public void add(int data) {

        Node newNode = new Node(data);

        if (this.head == null) {
            this.head = newNode;
        } else {

            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }

    }

    public void print() {
        Node temp = this.head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    // delete(){
    // }

    // append(){

    // }

}

class Node {

    protected int data;
    protected Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}