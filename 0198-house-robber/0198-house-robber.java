class Solution {
    public int rob(int[] nums) {

        int[] dp = new int[nums.length + 1];
        Arrays.fill(dp, -1);

        return helper(nums, 0, dp);
        
    }

    private int helper(int[] nums, int i, int[] dp){

        // base case
        if(i == nums.length-1) return nums[i];

        if(i >= nums.length) return 0;

        if(dp[i] != -1) return dp[i];

        // choose i
        int take = nums[i] + helper(nums, i+2, dp);

        // not choose
        int skip = helper(nums, i+1, dp);

        dp[i] = Math.max(take, skip);

        return dp[i];

    }
}