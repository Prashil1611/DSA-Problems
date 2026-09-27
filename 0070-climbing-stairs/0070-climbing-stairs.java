class Solution {

    public int climbStairs(int n) {

        // if(n == 1)
        //     return 1;

        // int prev2 = 1; // dp[0]
        // int prev1 = 1; // dp[1]

        // for(int i = 2; i <= n; i++){

        //     int curr = prev1 + prev2;

        //     prev2 = prev1;
        //     prev1 = curr;
        // }

        // return prev1;

        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);

        return helper(n, dp);
    }


    private int helper(int n, int[] dp){

        if(n == 1 || n == 2) return n;

        if(dp[n] != -1) return dp[n];

        dp[n] = helper(n-1, dp) + helper(n-2, dp);

        return dp[n];
    }
}

// class Solution {
//     //static int ans = 0;
//     public int climbStairs(int n) {

//         //ans = 0;
        
//         //StringBuilder sb = new StringBuilder();
//         return helper(n);

//         //return ans;

//     }

//     private int helper(int n){

//         if(n < 0) return 0;

//         if(n == 0) return 1;

//         return helper(n-1) + helper(n-2);

//     }
// }
