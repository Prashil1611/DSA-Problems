class Solution {
    public int[] resultArray(int[] nums) {
        
        int n = nums.length;

        int[] a1 = new int[n];
        int[] a2 = new int[n];

        a1[0] = nums[0];
        a2[0] = nums[1];

        int idx1 = 0;
        int idx2 = 0;

        for (int i = 2; i <n; i++){

            if(a1[idx1] > a2[idx2]){
                a1[++idx1] = nums[i];
            }
            else{
                a2[++idx2] = nums[i];
            }
            
        }

        for (int i = 0; i <= idx2; i++){
            a1[++idx1] = a2[i];
        }

        return a1;
    }
}