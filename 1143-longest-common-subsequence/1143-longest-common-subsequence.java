class Solution {
    public int longestCommonSubsequence(String text1, String text2) {

        int n = text1.length();
        int m = text2.length();

        int[][] dp = new int[n+1][m+1];
        for (int i = 0; i < n; i++){
            Arrays.fill(dp[i], -1);
        }
        
        return helper(text1, text2, 0, 0, dp);

    }

    private int helper(String s1, String s2, int i, int j, int[][] dp){

        if(i >= s1.length() || j >= s2.length()) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        int ans = 0;

        if(s1.charAt(i) == s2.charAt(j)){
            ans = 1 + helper(s1, s2, i+1, j+1, dp);
            dp[i][j] = ans;
        }
        else{
            ans = Math.max(helper(s1, s2, i+1, j, dp), helper(s1, s2, i, j+1, dp));
            dp[i][j] = ans;
        }

        return ans;

    }
}