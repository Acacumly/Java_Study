class Node {
    public int val;
    public Node next = null;
    public Node(int val) {
        this.val = val;
    }
    public Node(int val, Node next) {
        this(val);
        this.next = next;
    }
    public String toString(){
        return String.format("Node(%d)", val);
    }
}
public class List {
    public Node reverse(Node head) {
        //遍历和head代表的链表
        //把每个结点头插到一个新的链表上
        Node rhead = null;
        Node cur = head;
        while(cur != null) {
            Node next= cur.next;
            cur.next = rhead;
            rhead = cur;
            cur = next;
        }
        return rhead;
    }
    private static Node createList(){
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        n1. next = n2; n2.next = n3; n3.next = n4;
        return n1;
    }
    public static void main(String[] args) {
        Node n1 = createList();
        Node rhead = new List().reverse(n1);
        for(Node c = rhead; c != null; c = c.next) {
            System.out.println(c);
        }
    }
}

