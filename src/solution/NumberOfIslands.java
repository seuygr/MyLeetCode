package solution;

public class NumberOfIslands {
	// Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. 
	// An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. 
	// You may assume all four edges of the grid are all surrounded by water.
	public int numOfIslands(char[][] grid) {
		int n = grid.length;
		int m = grid[0].length;
		if (n == 0) {
			return 0;
		}
		int count = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (grid[i][j] == '1') {
					dfs(grid, i, j);
					count++;
				}
			}
		}
		return count;
	}
	private void dfs(char[][] grid, int i ,int j) {
		if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0') {
			return;
		}
		// mark the target to '0' and do dfs on its neighbors
		grid[i][j] = '0';
		dfs(grid, i - 1, j);
		dfs(grid, i, j - 1);
		dfs(grid, i + 1, j);
		dfs(grid, i, j + 1);
	}
}
