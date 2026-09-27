class Solution {

    // static class Result{
    //     int ans = 0;
    // }

    public int uniquePaths(int m, int n) {

        //Result res = new Result();

        int[][] dp = new int[m+1][n+1];
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                dp[i][j] = -1;
            }
        }

        return helper(0, 0, m, n, dp);

    }

    private int helper(int i, int j, int m, int n, int[][] dp){

        if(i == m-1 && j == n-1){
            return 1;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int ans = 0;

        if(i+1 < m){
            ans += helper(i+1, j, m, n, dp);
        }

        if(j+1 < n){
            ans += helper(i, j+1, m, n, dp);
        }

        dp[i][j] = ans;

        return dp[i][j];
        
    }
}