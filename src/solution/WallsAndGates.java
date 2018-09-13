package solution;

import java.util.*;

public class WallsAndGates {
	public int[][] wallsAndGates(int[][] rooms) {
		// bfs tranverse all gates
		if (rooms.length == 0) {
			return rooms;
		}
		int rows = rooms.length;
		int cols = rooms[0].length;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (rooms[i][j] == 0) {
					bfs(rooms, i, j);
				}
			}
		}
		return rooms;
	}
	private void bfs(int[][] rooms, int i, int j) {
		Queue<Element> queue = new LinkedList<>();
		queue.offer(new Element(i, j, 0));
		int[][] directions = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
		while (!queue.isEmpty()) {
			Element cur = queue.poll();
			for (int[] dir : directions) {
				int newX = cur.x + dir[0];
				int newY = cur.y + dir[1];
				if (newX >= 0 && newY >= 0 && newX < rooms.length && newY < rooms[0].length && cur.val + 1 < rooms[newX][newY]) {
					queue.offer(new Element(newX, newY, cur.val + 1));
					rooms[newX][newY] = cur.val + 1;
				}
			}
		}
	}
	static class Element {
		int x;
		int y;
		int val;
		Element(int x, int y, int val) {
			this.x = x;
			this.y = y;
			this.val = val;
		}
	}
}
