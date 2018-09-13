package solution;

public class SortList {
	// Sort a linked list in O(n log n) time using constant space complexity.
	//Merge sort
	class ListNode {
		public int value;
		public ListNode next;
		public ListNode(int value) {
			this.value = value;
			next = null;
		}
	}
	public ListNode mergeSort(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		// find the mid node using two pointers, "mid" is defined as the latter ListNode for linked lists with even number of nodes
		// prev is used to mark the end of the first linked list and cut it
		ListNode prev = null;
		ListNode slow = head;
		ListNode fast = head;
		while (fast != null && fast.next != null) {
			prev = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		prev.next = null;
		
		// sort each half of linked list
		ListNode one = mergeSort(head);
		ListNode two = mergeSort(slow);
		
		return merge(one, two);
	}
	private ListNode merge(ListNode one, ListNode two) {
		ListNode dummy = new ListNode(0);
		ListNode cur = dummy;
		while (one != null && two != null) {
			if (one.value < two.value) {
				cur.next = one;
				one = one.next;
			} else {
				cur.next = two;
				two = two.next;
			}
			cur = cur.next;
		}
		if (one != null) {
			cur.next = one;
		}
		if (two != null) {
			cur.next = two;
		}
		return dummy.next;
	}
}
