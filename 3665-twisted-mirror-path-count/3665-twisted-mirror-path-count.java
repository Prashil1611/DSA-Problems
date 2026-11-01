class Solution {

    public int uniquePaths(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        int MOD = 1_000_000_007;

        // dp[i][j][0] = ways entering from left (moving right)
        // dp[i][j][1] = ways entering from top (moving down)

        int[][][] dp = new int[m + 1][n + 1][2];

        // Starting position
        dp[0][0][0] = 1;

        for(int i = 0; i < m; i++){

            for(int j = 0; j < n; j++){

                int right = dp[i][j][0];
                int down = dp[i][j][1];

                if(grid[i][j] == 0){

                    int total = (right + down) % MOD;

                    // Move right
                    dp[i][j + 1][0] =
                        (dp[i][j + 1][0] + total) % MOD;

                    // Move down
                    dp[i + 1][j][1] =
                        (dp[i + 1][j][1] + total) % MOD;

                }
                else {

                    // Mirror: entering from left -> move down
                    dp[i + 1][j][1] =
                        (dp[i + 1][j][1] + right) % MOD;

                    // Mirror: entering from top -> move right
                    dp[i][j + 1][0] =
                        (dp[i][j + 1][0] + down) % MOD;
                }
            }
        }

        return (dp[m - 1][n - 1][0]
              + dp[m - 1][n - 1][1]) % MOD;
    }
}