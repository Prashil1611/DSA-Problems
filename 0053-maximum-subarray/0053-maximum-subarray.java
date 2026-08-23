class Solution {
    public int maxSubArray(int[] nums) {
        
        // // int currSum = nums[0];
        // // int maxSum = nums[0];

        // // for (int i=1; i<nums.length; i++){
            
        // //     currSum = Math.max(nums[i], currSum + nums[i]);

        // //     maxSum = Math.max(maxSum, currSum);
        // // }

        // // return maxSum;

        // int sum = 0;
        // int max = Integer.MIN_VALUE;

        // for(int num : nums){

        //     sum += num;

        //     max = Math.max(max, sum);

        //     if(sum < 0) sum = 0;

        // }

        // return max;

        int maxSum = Integer.MIN_VALUE;
		int sum = 0;

		for (int i = 0; i < nums.length; i++){

			sum += nums[i];
			maxSum = Math.max(maxSum, sum);

			if(sum < 0){
				sum = 0;
			}
			
		}

        return maxSum;
    }
}