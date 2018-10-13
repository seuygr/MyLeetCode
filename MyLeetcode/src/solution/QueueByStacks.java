package solution;

import java.util.Deque;

public class QueueByStacks {
	// Implemented a queue by two stacks
	Deque<Integer> stack1; // always used for offer/add
	Deque<Integer> stack2; // alwasy used for poll/remove
	
	public void offer(int value) {
		stack1.offerFirst(value);
	}
	public Integer poll() {
		// Check if stack2 is empty
		// if true, move all numbers from stack1 to stack2, then poll from stack2
		// if false, just poll from stack2
		if (stack2.isEmpty()) {
			while (!stack1.isEmpty()) {
				stack2.offerFirst(stack1.pollFirst());
			}
		}
		return stack2.pollFirst();
	}
	public Integer peek() {
		if (stack2.isEmpty()) {
			while (!stack1.isEmpty()) {
				stack2.offerFirst(stack1.pollFirst());
			}
		}
		return stack2.peekFirst();
	}
	public int size() {
		return stack1.size() + stack2.size();
	}
	public boolean isEmpty() {
		return stack1.isEmpty() && stack2.isEmpty();
	}
}
