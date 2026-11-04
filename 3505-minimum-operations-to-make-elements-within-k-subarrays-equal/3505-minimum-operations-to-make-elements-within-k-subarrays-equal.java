class Solution {

    class MedianWindow {

        TreeMap<Integer, Integer> left = new TreeMap<>();
        TreeMap<Integer, Integer> right = new TreeMap<>();

        int leftSize = 0, rightSize = 0;
        long leftSum = 0, rightSum = 0;

        void add(TreeMap<Integer, Integer> map, int val) {
            map.put(val, map.getOrDefault(val, 0) + 1);
        }

        void remove(TreeMap<Integer, Integer> map, int val) {
            int count = map.get(val);

            if (count == 1) map.remove(val);
            else map.put(val, count - 1);
        }

        void balance() {

            while (leftSize > rightSize + 1) {

                int val = left.lastKey();

                remove(left, val);
                leftSize--;
                leftSum -= val;

                add(right, val);
                rightSize++;
                rightSum += val;
            }

            while (leftSize < rightSize) {

                int val = right.firstKey();

                remove(right, val);
                rightSize--;
                rightSum -= val;

                add(left, val);
                leftSize++;
                leftSum += val;
            }
        }

        void insert(int val) {

            if (left.isEmpty() || val <= left.lastKey()) {
                add(left, val);
                leftSize++;
                leftSum += val;
            } else {
                add(right, val);
                rightSize++;
                rightSum += val;
            }

            balance();
        }

        void delete(int val) {

            if (left.containsKey(val)) {
                remove(left, val);
                leftSize--;
                leftSum -= val;
            } else {
                remove(right, val);
                rightSize--;
                rightSum -= val;
            }

            balance();
        }

        long getCost() {

            long median = left.lastKey();

            return median * leftSize - leftSum
                    + rightSum - median * rightSize;
        }
    }

    public long minOperations(int[] nums, int x, int k) {

        int n = nums.length;

        // Calculate cost of every window of size x

        long[] cost = new long[n - x + 1];

        MedianWindow window = new MedianWindow();

        for (int i = 0; i < x; i++) {
            window.insert(nums[i]);
        }

        cost[0] = window.getCost();

        for (int i = x; i < n; i++) {

            window.delete(nums[i - x]);
            window.insert(nums[i]);

            cost[i - x + 1] = window.getCost();
        }

        // DP

        long INF = Long.MAX_VALUE / 4;

        long[] prev = new long[n + 1];
        long[] curr = new long[n + 1];

        for (int t = 1; t <= k; t++) {

            java.util.Arrays.fill(curr, INF);

            for (int i = t * x; i <= n; i++) {

                // Skip current element
                curr[i] = curr[i - 1];

                // Select last x elements
                long take = prev[i - x] + cost[i - x];

                curr[i] = Math.min(curr[i], take);
            }

            long[] temp = prev;
            prev = curr;
            curr = temp;
        }

        return prev[n];
    }
}