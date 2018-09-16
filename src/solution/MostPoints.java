package solution;

import java.util.*;

public class MostPoints {
	// Given an array of 2D coordinates 
	// of points (all the coordinates are integers),
	// find the largest number of points that can be crossed by a single line in 2D space.
	static class Point {
		public int x;
		public int y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	public int most(Point[] points) {
		if (points == null) {
			return 0;
		}
		if (points.length <= 2) {
			return points.length;
		}
		int result = 0;
		for (int i = 0; i < points.length; i++) {
			Map<Double, Integer> map = new HashMap<>();
			Point seed = points[i];
			int same = 1;
			int sameX = 0;
			int most = 0;
			for (int j = 0; j < points.length; j++) {
				if (i == j) {
					continue;
				}
				Point cur = points[j];
				if (cur.x == seed.x && cur.y == seed.y) {
					same++;
				} else if (cur.x == seed.x) {
					sameX++;
				} else {
					double slope = ((cur.y - seed.y) + 0.0) / (cur.x - seed.x);
					if (!map.containsKey(slope)) {
						map.put(slope, 1);
					} else {
						map.put(slope, map.get(slope) + 1);
					}
					most = Math.max(most, map.get(slope));
				}
			}
			most = Math.max(sameX, most) + same;
			result = Math.max(result, most);
		}
		return result;
	}
	public static void main(String[] args) {
		Point[] points = new Point[3];
		points[0] = new Point(1, 1);
		points[1] = new Point(2, 3);
		points[2] = new Point(1, 1);
		MostPoints sol = new MostPoints();
		System.out.println(sol.most(points));
	}
}
