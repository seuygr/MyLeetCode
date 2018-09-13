package solution;

import java.util.*;

public class CloneGraph {
	// Make a deep copy of an undirected graph, there could be cycles in the original graph.
	class GraphNode {
		public int key;
		public List<GraphNode> neighbors;
		public GraphNode(int key) {
			this.key = key;
			this.neighbors = new ArrayList<GraphNode>();
		}
	}
	
	// Method 1 with BFS
	public GraphNode BFS(GraphNode source) {
		if (source == null) {
			return source;
		}
		Queue<GraphNode> queue = new LinkedList<>();
		queue.offer(source);
		Map<GraphNode, GraphNode> map = new HashMap<>();
		map.put(source, new GraphNode(source.key));
		while (!queue.isEmpty()) {
			GraphNode cur = queue.poll();
			GraphNode curCopied = map.get(cur);
			List<GraphNode> nei = cur.neighbors;
			if (nei != null) {
				for (GraphNode node : nei) {
					GraphNode neiCopied = map.get(node);
					if (neiCopied == null) {
						queue.offer(node);
						neiCopied = new GraphNode(node.key);
						map.put(node, neiCopied);
					}
					curCopied.neighbors.add(neiCopied);
				}
			}
		}
		return map.get(source);
	}
	
	// Method 2 with DFS
	public List<GraphNode> DFS(List<GraphNode> graph) {
		if (graph == null) {
			return graph;
		}
		Map<GraphNode, GraphNode> map = new HashMap<>();
		for (GraphNode node : graph) {
			if (!map.containsKey(node)) {
				map.put(node, new GraphNode(node.key));
				DFS(node, map);
			}
		}
		return new ArrayList<GraphNode>(map.values());
	}
	private void DFS(GraphNode node, Map<GraphNode, GraphNode> map) {
		GraphNode copy = map.get(node);
		for (GraphNode nei : node.neighbors) {
			if (!map.containsKey(nei)) {
				map.put(nei, new GraphNode(nei.key));
				DFS(nei, map);
			}
			copy.neighbors.add(map.get(nei));
		}
	}
}
