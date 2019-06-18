//单链表的逆置
class ListNode {
	int val;
	ListNode next;
}

public class Link {
	public static ListNode ReverseLink(ListNode first) {
		ListNode cur = first;
		ListNode node = null;
		ListNode result = null;
		while(cur != null) {
			node = cur;
			cur = cur.next;
			node.next = result;
		}
		return result;
	}
	public static void print(ListNode head) {
		while(head != null) {
			System.out.println(head.val);
			head = head.next;
		}
	}
	public static void main(String[] args) {
		ListNode n1 = new ListNode();
		ListNode n2 = new ListNode();
		ListNode n3 = new ListNode();
		ListNode n4 = new ListNode();
		n1.val = 1;
		n2.val = 2;
		n3.val = 3;
		n4.val = 4;
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		print(ReverseLink(n1));
	}
}