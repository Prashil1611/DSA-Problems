class Solution {
    public int searchInsert(int[] nums, int target) {

        int inserted = 0;

        int i = 0;
        int j = nums.length - 1;

        if(target < nums[i]) return 0;
        if(target > nums[j]) return nums.length;

        while (i < j){

            int mid = i + (j-i)/2;

            if(nums[mid] == target) return mid;

            if(nums[mid] < target){
                i = mid + 1;
                inserted = mid + 1;
            }
            else{
                j = mid;
                inserted = mid;
            }

        }

        return inserted;
        
    }
}