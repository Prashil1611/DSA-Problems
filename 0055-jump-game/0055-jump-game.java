class Solution {
    public boolean canJump(int[] nums) {

        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);

        return helper(nums, 0, dp);
        
    }

    private boolean helper(int[] nums, int i, int[] dp){

        if(i >= nums.length - 1) return true;

        if(dp[i] != -1){
            return dp[i] == 1;
        }

        for (int jump = 1; jump <= nums[i]; jump++){

            if(helper(nums, jump + i, dp)){
                dp[i] = 1;
                return true;
            }
        }

        dp[i] = 0;

        return false;
    }
}