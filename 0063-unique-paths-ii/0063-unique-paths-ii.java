class Solution {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        if(obstacleGrid[0][0] == 1) return 0;

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] dp = new int[m+1][n+1];
        for (int i = 0; i < m; i++){
            Arrays.fill(dp[i], -1);
        }

        return helper(obstacleGrid, 0, 0, m, n, dp);

    }

    private static int helper(int[][] mat, int i, int j, int m, int n, int[][] dp){

        // base case
        if(i == m-1 && j == n-1){
            return 1;
        }

        // if dp[i][j] already calculated
        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int right = 0;
        int down = 0;

        // go right
        if(j+1 < n && mat[i][j+1] != 1){
            right = helper(mat, i, j+1, m, n, dp);
        }

        // go down
        if(i+1 < m && mat[i+1][j] != 1){
            down = helper(mat,i+1, j, m, n, dp);
        }

        dp[i][j] = right + down;

        return dp[i][j];

    }

}