在一个排序的链表中，存在重复的结点，
请删除该链表中重复的结点，
重复的结点不保留，返回链表头指针。 
例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
/*public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/

public class Solution {
    public ListNode deleteDuplication(ListNode pHead)
    {
        if(pHead == null) {
			return null;
		}
		ListNode prev = new ListNode(0);
		prev.next = pHead;
		ListNode fake = prev;
		ListNode p1 = pHead;
		ListNode p2 = pHead.next;
		while(p2 != null) {
			if(p1.val != p2.val) {
				prev = p1;
				p1 = p1.next;
				p2 = p2.next;
			} else {
				while(p2 != null && p2.val == p1.val) {
					p2 = p2.next;
				}
				
				prev.next = p2;
				p1 = p2;
				if(p2 != null) {
					p2 = p2.next;
				}
			}
		}
        return fake.next;
    }
}