package solution;

public class ReverseLinkedList {
	//Reverse a singly linked list.
	// Input: 1->2->3->4->5->NULL
	// Output: 5->4->3->2->1->NULL
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
		ListNode prev = null;
		while (head != null) {
			ListNode next = head.next;
			head.next = prev;
			prev = head;
			head = next;
		}
		return prev;
	}
	public ListNode reverseRecursively(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode newHead = reverseRecursively(head.next);
		head.next.next = head;
		head.next = null;
		return newHead;
	}
}
