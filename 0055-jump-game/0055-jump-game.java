class Solution {
    public boolean canJump(int[] nums) {

        // int[] dp = new int[nums.length];
        // Arrays.fill(dp, -1);

        // return helper(nums, 0, dp);


        int maxReach = 0;

        for (int i = 0; i < nums.length; i++){
            if(i > maxReach) return false;
            maxReach = Math.max(maxReach, i+nums[i]);
        }

        return true;


        
    }

    // private boolean helper(int[] nums, int i, int[] dp){

    //     if(i >= nums.length - 1) return true;

    //     if(dp[i] != -1){
    //         return dp[i] == 1;
    //     }

    //     for (int jump = 1; jump <= nums[i]; jump++){

    //         if(helper(nums, jump + i, dp)){
    //             dp[i] = 1;
    //             return true;
    //         }
    //     }

    //     dp[i] = 0;

    //     return false;
    // }

}




