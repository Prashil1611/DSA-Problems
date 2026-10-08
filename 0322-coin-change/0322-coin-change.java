class Solution {

    // static class Result{
    //     int ans = Integer.MAX_VALUE;
    //     int coin = 0;
    // }

    public int coinChange(int[] coins, int amount) {

        //Arrays.sort(coins, Collections.reverseOrder());

        //Result res = new Result();

        int[][] dp = new int[coins.length+1][amount+1];
        for (int i = 0; i < coins.length; i++){
            Arrays.fill(dp[i], -1);
        }

        int ans = helper(coins, 0, amount, dp);

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private int helper(int[] coins, int i, int amount, int[][] dp){

        // base case
        if(amount == 0) return 0;
        if(i == coins.length) return Integer.MAX_VALUE;

        if(dp[i][amount] != -1) return dp[i][amount];

        // choose i
        int choose = Integer.MAX_VALUE;
        if(coins[i] <= amount){
            int result = helper(coins, i, amount-coins[i], dp);
            if(result != Integer.MAX_VALUE){
                choose = 1 + result;
            }
        }

        // not choose i
        int not_choose = helper(coins, i+1, amount, dp);

        dp[i][amount] = Math.min(choose, not_choose);

        return dp[i][amount];

    }
}