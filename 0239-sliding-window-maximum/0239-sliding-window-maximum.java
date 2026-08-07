class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        Deque<Integer> dq = new ArrayDeque<>();
        int n = nums.length;

        // build 1st window
        for (int i = 0; i < k; i++){
            while(!dq.isEmpty() && nums[i] > dq.peekLast()){
                dq.pollLast();
            }
            dq.offerLast(nums[i]);
        }

        // create an ans[] array
        int[] ans = new int[n-k+1];
        int idx = 0;

        // next window
        for (int i = k; i < n; i++){

            ans[idx++] = dq.peekFirst();

            if(dq.peekFirst() == nums[i-k]) dq.pollFirst();

            while(!dq.isEmpty() && nums[i] > dq.peekLast()){
                dq.pollLast();
            }

            dq.offerLast(nums[i]);

        }

        ans[idx] = dq.peekFirst();

        return ans;

    }
}