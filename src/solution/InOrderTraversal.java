package solution;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class InOrderTraversal {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	// recursively traverse
	public void inOrder(TreeNode root) {
		if (root == null) {
			return;
		}
		inOrder(root.left);
		System.out.println(root.val);
		inOrder(root.right);
	}
	
	// iteratively in order traverse
	// mock a stack like recursion
	public List<Integer> inOrder1(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		Deque<TreeNode> stack = new LinkedList<>();
		pushLeft(root, stack);
		while (!stack.isEmpty()) {
			TreeNode cur = stack.pollFirst();
			result.add(cur.val);
			pushLeft(cur.right, stack);
		}
		return result;
	}
	private void pushLeft(TreeNode cur, Deque<TreeNode> stack) {
		while (cur != null) {
			stack.offerFirst(cur);
			cur = cur.left;
		}
	}
}
