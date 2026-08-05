class Solution {
    public double findMaxAverage(int[] nums, int k) {

        int sum = 0;

        for (int i = 0; i < k; i++){
            sum += nums[i];
        }

        double avg = (double) sum / k;
        double maxAvg = avg;

        for (int i = k; i < nums.length; i++){

            sum -= nums[i-k];
            sum += nums[i];

            avg = (double) sum / k;

            maxAvg = Math.max(maxAvg, avg);
        }

        return maxAvg;
        
    }
}