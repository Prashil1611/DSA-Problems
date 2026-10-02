class Solution {
    public int jump(int[] nums) {

        int n = nums.length;
        
        int[] dp = new int[n+1];
        for (int i = 0; i < n; i++){
            dp[i] = -1;
        }

        return helper(nums, 0, dp);
        
    }

    private int helper(int[] nums, int i, int[] dp){

        if(i >= nums.length - 1) return 0;

        if(dp[i] != -1) return dp[i];

        int ans = Integer.MAX_VALUE;

        for (int jump = 1; jump <= nums[i]; jump++){

            int total = helper(nums, i+jump, dp);

            if(total != Integer.MAX_VALUE){
                ans = Math.min(ans, 1 + total);
            }

        }

        dp[i] = ans;

        return dp[i];

    }
}