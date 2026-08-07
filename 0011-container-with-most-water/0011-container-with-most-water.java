class Solution {
    public int maxArea(int[] height) {

        int l = 0;
        int r = height.length - 1;
        int maxWater = 0;

        while(l < r) {

            int width = r - l;
            int heights = Math.min(height[l], height[r]);

            int water = width * heights;

            maxWater = Math.max(maxWater, water);

            if(height[l] < height[r]){
                l++;
            }
            else{
                r--;
            }

        }

        return maxWater;
        
    }
}