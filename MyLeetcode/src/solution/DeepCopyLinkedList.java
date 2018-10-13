package solution;

import java.util.HashMap;
import java.util.Map;

public class DeepCopyLinkedList {
	class Node {
		public int value;
		public Node next;
		public Node random;
		public Node(int value) {
			this.value = value;
		}
	}
	public Node deepCopy(Node head) {
		if (head == null) {
			return head;
		}
		// use a map to store the connection between original node and copied node
		// to avoid duplicate
		Map<Node, Node> lookUp = new HashMap<>();
		Node newHead = new Node(head.value);
		lookUp.put(head, newHead);
		Node cur = newHead;
		while (head != null) {
			if (head.next != null) {
				// if the node hasn't been added to the map
				// create a new one
				// otherwise, just connect it to the end of copied linked list
				if (!lookUp.containsKey(head.next)) {
					lookUp.put(head.next, new Node(head.next.value));
				}
				cur.next = lookUp.get(head.next);
			}
			if (head.random != null) {
				if (!lookUp.containsKey(head.random)) {
					lookUp.put(head.random, new Node(head.random.value));
				}
				cur.random = lookUp.get(head.random);
			}
			head = head.next;
			cur = cur.next;
		}
		return newHead;
	}
}
