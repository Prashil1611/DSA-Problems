class Solution {
    public int trap(int[] height) {

        // optimal solution

        int i = 0;
        int j = height.length - 1;

        int lmax = 0;
        int rmax = 0;

        int water = 0;

        while(i <= j){

            if(lmax <= rmax){
                water += Math.max(lmax - height[i], 0);
                lmax = Math.max(lmax, height[i]);
                i++;
            }
            else{
                water += Math.max(rmax - height[j], 0);
                rmax = Math.max(rmax, height[j]);
                j--;
            }

        }

        return water;
        















        
        // int n = height.length;
        // int[] lMax = new int[n];
        // int[] rMax =  new int[n];

        // lMax[0] = height[0];
        // rMax[n-1] = height[n-1];

        // for (int i=1; i<n; i++) {
        //     lMax[i] = Math.max(lMax[i-1], height[i]);
        // }

        // for (int i=n-2; i>=0; i--) {
        //     rMax[i] = Math.max(rMax[i+1], height[i]);
        // }

        // int water = 0;

        // for (int i=0; i<n; i++) {

        //     water += Math.min(lMax[i], rMax[i]) - height[i];
        // }

        // return water;


    }
}