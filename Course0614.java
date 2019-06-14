//输入一个链表，输出该链表中倒数第k个结点
/*public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class Solution {
    public ListNode FindKthToTail(ListNode head,int k) {
        ListNode a = head;
		int length = 0;
		while(a != null){
			a = a.next;
			++length;
    }
	if(length < k){
		return null;
	}
	int n = length - k;
	ListNode kth = head;
	for(int i = 0; i < n; i++) {
		kth = kth.next;
	}
	return kth;
    }
}