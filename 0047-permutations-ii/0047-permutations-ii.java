class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> partial_ans = new ArrayList<>();

        boolean[] visited = new boolean[nums.length];

        Arrays.sort(nums);

        helper(0, nums, visited, partial_ans, ans);

        return ans;
        
    }

    private void helper(int i, int[] nums, boolean[] visited, List<Integer> partial_ans, List<List<Integer>> ans) {

        if(i == nums.length) {
            ans.add(new ArrayList<>(partial_ans));
            return;
        }

        for (int k = 0; k < nums.length; k++) {

            if(visited[k]) continue;

            if(k > 0 && nums[k] == nums[k-1] && !visited[k-1]) {
                continue;
            }

            visited[k] = true;

            partial_ans.add(nums[k]);
            helper(i+1, nums, visited, partial_ans, ans);
            partial_ans.remove(partial_ans.size() - 1);
            visited[k] = false;

        }
    }
}