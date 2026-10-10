class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {

        int n = nums1.length;
        int[] diff = new int[n];

        long sum = 0;
        int maxDiff = 0;

        int k = k1 + k2;

        // Step 1: Calculate absolute differences
        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs(nums1[i] - nums2[i]);

            sum += diff[i];
            maxDiff = Math.max(maxDiff, diff[i]);
        }

        // Step 2: If all differences can become zero
        if (sum <= k) {
            return 0;
        }

        // Step 3: Binary search the maximum final difference
        int left = 0;
        int right = maxDiff;

        while (left < right) {
            int mid = left + (right - left) / 2;

            long operations = 0;

            for (int d : diff) {
                operations += Math.max(0, d - mid);
            }

            if (operations <= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        // Step 4: Reduce every difference to at most left
        for (int i = 0; i < n; i++) {
            k -= Math.max(0, diff[i] - left);
            diff[i] = Math.min(diff[i], left);
        }

        // Step 5: Use remaining operations
        for (int i = 0; i < n && k > 0; i++) {
            if (diff[i] == left) {
                diff[i]--;
                k--;
            }
        }

        // Step 6: Calculate the squared sum
        long ans = 0;

        for (int d : diff) {
            ans += (long) d * d;
        }

        return ans;
    }
}
