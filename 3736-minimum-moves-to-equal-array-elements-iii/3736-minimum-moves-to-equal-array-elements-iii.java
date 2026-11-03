class Solution {
    public int minMoves(int[] nums) {

        int max = 0;
        for (int num : nums){
            max = Math.max(max, num);
        }

        int ans = 0;

        for (int num : nums){
            ans += max - num;
        }

        return ans;
        
    }
}