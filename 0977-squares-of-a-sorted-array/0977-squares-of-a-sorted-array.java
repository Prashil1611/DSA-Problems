class Solution {
    public int[] sortedSquares(int[] nums) {

        int n = nums.length;
        int l = 0;
        int r = n-1;
        int i = n-1;

        int[] ans = new int[n];

        while( l <= r) {

            int l_square = nums[l] * nums[l];
            int r_square = nums[r] * nums[r];

            if(l_square > r_square){
                ans[i--] = l_square;
                l++;
            }
            else{
                ans[i--] = r_square;
                r--;
            }

        }

        return ans;
        
    }
}