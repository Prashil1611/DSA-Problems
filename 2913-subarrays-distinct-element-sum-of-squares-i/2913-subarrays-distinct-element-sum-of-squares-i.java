class Solution {
    public int sumCounts(List<Integer> nums) {

        int ans = 0;
       
        for (int i = 0; i < nums.size(); i++){

            HashSet<Integer> set = new HashSet<>();

            for (int j = i; j < nums.size(); j++){

                int num = nums.get(j);

                set.add(num);

                ans += set.size() * set.size();

            }

        }

        return ans;
        
    }
}