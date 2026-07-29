class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {

        Arrays.sort(nums);

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> partial_ans = new ArrayList<>();

        helper(0, nums, partial_ans, ans);

        return ans;    
        
    }

    private void helper(int i, int[] nums, List<Integer> partial_ans, List<List<Integer>> ans) {

        if(i == nums.length){
            ans.add(new ArrayList<>(partial_ans));
            return;
        }

        // choose ith element
        partial_ans.add(nums[i]);
        helper(i+1, nums, partial_ans, ans);
        partial_ans.remove(partial_ans.size() - 1);

        // skip duplicates
        while(i+1 < nums.length && nums[i] == nums[i+1]){
            i++;
        }

        // not choose ith element
        helper(i+1, nums, partial_ans, ans);
    }
}