package solution;

import java.util.*;

public class BFSForGraph {
	// O(|V| + |E|) time and O(|V|) space
	class GraphNode {
		public int key;
		public List<GraphNode> neighbors;
		public GraphNode(int key) {
			this.key = key;
			this.neighbors = new ArrayList<GraphNode>();
		}
	}
	public List<GraphNode> bfs(GraphNode root) {
		List<GraphNode> result = new ArrayList<>();
		if (root == null) {
			return result;
		}
		Queue<GraphNode> queue = new LinkedList<>();
		Set<GraphNode> visited = new HashSet<>();
		queue.offer(root);
		visited.add(root);
		while (!queue.isEmpty()) {
			GraphNode cur = queue.poll();
			result.add(cur);
			for (GraphNode node : cur.neighbors) {
				if (visited.add(node)) {
					queue.offer(node);
				}
			}
		}
		return result;
	}
}
