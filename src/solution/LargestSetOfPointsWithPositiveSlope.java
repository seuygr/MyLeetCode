package solution;

import java.util.*;

public class LargestSetOfPointsWithPositiveSlope {
	static class Point {
		public int x;
		public int y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	public int largest(Point[] points) {
		// Write your solution here.
		if (points == null) {
			return 0;
		}
		Arrays.sort(points, new MyComparator());
		int[] longest = new int[points.length];
		longest[0] = 1;
		int result = 1;
		for (int i = 1; i < points.length; i++) {
			for (int j = 0; j < i; j++) {
				if (points[i].y > points[j].y) {
					longest[i] = Math.max(longest[j] + 1, longest[i]);
				}
				result = Math.max(longest[i], result);
			}
		}
		return result;
	}
	static class MyComparator implements Comparator<Point> {
		@Override
		public int compare(Point p1, Point p2) {
			if (p1.x < p2.x) {
				return -1;
			} else if (p1.x > p2.x) {
				return 1;
			} else if (p1.y < p2.y) {
				return -1;
			} else if (p1.y > p2.y){
				return 1;
			}
			return 0;
		}
	}

	public static void main(String[] args) {
		Point[] points = new Point[1];
		points[0] = new Point(0, 0);
//		points[1] = new Point(2,3);
//		points[2] = new Point(4,4);
		LargestSetOfPointsWithPositiveSlope sol = new LargestSetOfPointsWithPositiveSlope();
		System.out.println(sol.largest(points));
	}
}
