import java.util.*;
public class Course0611 {
	int val;
	ListNode next = null;
	ListNode(int val) {
		this.val = val;
	}
}

/**编写代码，以给定值x为基准将链表分割成两部分，
   所有小于x的结点排在大于或等于x的结点之前
   给定一个链表的头指针 ListNode* pHead，请
   返回重新排列后的链表的头指针。
   注意：分割以后保持原来的数据顺序不变。
	                 9 5 3 2 7 6 1
	                    x = 3
          small	                     big
    cur.val < x	2 1         cur.val >= x 9 5 3 7 6
	      拼接起来 2 1 9 5 3 7 6
*/

public class Partition {
	public  ListNode partition (ListNode head, int x) {
		ListNode small = null;
		ListNode smallLast = null;
		ListNode big = null;
		ListNode bigLast = null;
		for(ListNode cur = pHead; cur != null; cur = cur.next) {
			if(cur.val < x) {
				if(small == null) {
					small = cur;
				} else {
					smallLast.next = cur;
				}
				smallLast = cur;
			}
			//if(cur.val > = x){
			 else { 
					if(big == null) {
						big = cur;
					} else {
					bigLast.next = cur;
				}
				bigLast = cur;
			}
		}
		
		//拼起来
		//没有小于x的结点
		if(small == null) {
			return big;
		} else {
			//smalllast.next = big 即使没有大于等于x的结点（即big为null），
			//这样也表示出了拼接后最后一个节点更新为null
			smallLast.next = big;
			//最后一个节点需更新为null
			if(bigLast != null) {
				bigLast.next = null;
			}
			return small;
		}
	}
}
		
		

	
	
	

	
	
			
		