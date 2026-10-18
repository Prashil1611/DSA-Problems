
import java.util.*;

class Solution {

    static final long MOD = 1_000_000_007;
    long[][] comb = new long[1001][1001];

    public int numOfWays(int[] nums) {

        int n = nums.length;

        // Precompute combinations using Pascal's triangle
        for (int i = 0; i <= n; i++) {
            comb[i][0] = 1;
            comb[i][i] = 1;

            for (int j = 1; j < i; j++) {
                comb[i][j] =
                    (comb[i - 1][j - 1] + comb[i - 1][j]) % MOD;
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }

        return (int) ((helper(list) - 1 + MOD) % MOD);
    }

    private long helper(List<Integer> nums) {

        int n = nums.size();

        if (n <= 2) {
            return 1;
        }

        int root = nums.get(0);

        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        // Divide elements into left and right subtrees
        for (int i = 1; i < n; i++) {
            if (nums.get(i) < root) {
                left.add(nums.get(i));
            } else {
                right.add(nums.get(i));
            }
        }

        long leftWays = helper(left);
        long rightWays = helper(right);

        // Number of ways to interleave left and right nodes
        long ways = comb[n - 1][left.size()];

        return (((ways * leftWays) % MOD) * rightWays) % MOD;
    }
}
