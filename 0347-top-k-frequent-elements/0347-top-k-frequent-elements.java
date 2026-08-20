class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        int n = nums.length;

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        int[] ans = new int[k];

        for (int i = 0; i < k; i++){
            
            int maxKey = Integer.MIN_VALUE;
            int maxValue = Integer.MIN_VALUE;

            for (int key : map.keySet()){
                
                if(map.get(key) > maxValue){
                    maxValue = map.get(key);
                    maxKey = key;
                }

            }

            ans[i] = maxKey;

            map.remove(maxKey);

        }

        return ans;
        
    }
}