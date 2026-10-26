class Solution {

    class Result {
        int ans = 0;
    }

    public int countIslands(int[][] grid, int k) {

        Result res = new Result();

        int m = grid.length;
        int n = grid[0].length;

        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] > 0 && !visited[i][j]) {

                    long sum = helper(grid, visited, i, j, m, n);

                    if (sum % k == 0) {
                        res.ans++;
                    }
                }
            }
        }

        return res.ans;
    }

    private long helper(int[][] grid, boolean[][] visited, int r, int c, int m, int n) {

        // Base case
        if (r < 0 || r >= m || c < 0 || c >= n || grid[r][c] == 0 || visited[r][c]) {
            return 0;
        }

        // Mark visited
        visited[r][c] = true;

        // Current cell value
        long sum = grid[r][c];

        // Visit up, down, left, right
        sum += helper(grid, visited, r - 1, c, m, n);
        sum += helper(grid, visited, r + 1, c, m, n);
        sum += helper(grid, visited, r, c - 1, m, n);
        sum += helper(grid, visited, r, c + 1, m, n);

        return sum;

    }
}
