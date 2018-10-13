package solution;

public class RemoveFromEndOfList {
	// Given a linked list, remove the n-th node from the end of list and return its head.
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { 
			val = x; 
		}
	}
	public ListNode removeNthFromEnd(ListNode head, int n) {
		// assume n is smaller than the length of the linked list
		if (head == null) {
			return head;
		}
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode slow = dummy;
		ListNode fast = dummy;
		while (n > 0) {
			fast = fast.next;
			n--;
		}
		while (fast.next != null) {
			fast = fast.next;
			slow = slow.next;
		}
		slow.next = slow.next.next;
		return dummy.next;
	}
}
