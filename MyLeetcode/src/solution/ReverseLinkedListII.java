package solution;

public class ReverseLinkedListII {
	// reverse a linked list in pairs
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { 
			val = x; 
		}
	}
	public ListNode reverseIteratively(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode dummy = new ListNode(-1);
		ListNode prev = dummy;
		prev.next = head;
		ListNode cur = head;
		while (cur != null && cur.next != null) {
			prev.next = cur.next;
			cur.next = cur.next.next;
			prev.next.next = cur;
			prev = cur;
			cur = cur.next;
		}
		return dummy.next;
	}
	public ListNode reverseRecursively(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		// The order matters
		ListNode newHead = head.next;
	    head.next = reverseRecursively(head.next.next);
	    newHead.next = head;
		return newHead;
	}
}
