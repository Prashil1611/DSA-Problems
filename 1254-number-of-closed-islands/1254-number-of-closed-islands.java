
class Solution {
    public int closedIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] == 0) {
                    if (dfs(grid, i, j)) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    public boolean dfs(int[][] grid, int i, int j) {

        // If we go outside the grid, island is not closed
        if (i < 0 || j < 0 ||
            i >= grid.length || j >= grid[0].length) {
            return false;
        }

        // Water: this direction is safe
        if (grid[i][j] == 1) {
            return true;
        }

        // Mark land as visited
        grid[i][j] = 1;

        boolean up = dfs(grid, i - 1, j);
        boolean down = dfs(grid, i + 1, j);
        boolean left = dfs(grid, i, j - 1);
        boolean right = dfs(grid, i, j + 1);

        return up && down && left && right;
    }
}
