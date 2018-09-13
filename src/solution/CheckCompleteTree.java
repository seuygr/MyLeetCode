package solution;

import java.util.LinkedList;
import java.util.Queue;

public class CheckCompleteTree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	public boolean isCompleted(TreeNode root) {
		if (root == null) {
			return true;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		boolean flag = false;
		queue.offer(root);
		while (!queue.isEmpty()) {
			TreeNode cur = queue.poll();
			if (cur.left == null) {
				flag = true;
			} else if (flag == true) {
				return false;
			} else {
				queue.offer(cur.left);
			}
			if (cur.right == null) {
				flag = true;
			} else if (flag == true) {
				return false;
			} else {
				queue.offer(cur.right);
			}
		}
		return true;
	}
}
