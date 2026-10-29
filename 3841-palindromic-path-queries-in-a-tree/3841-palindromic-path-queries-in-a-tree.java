
import java.util.*;

class Solution {

    List<Boolean> palindromePath(int n, int[][] edges,
                                 String s, String[] queries) {

        List<Integer>[] adj = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }

        int LOG = 1;
        while ((1 << LOG) <= n) {
            LOG++;
        }

        int[][] up = new int[LOG][n];
        int[] depth = new int[n];
        int[] tin = new int[n];
        int[] tout = new int[n];

        // Iterative DFS: enter and exit events
        int[] stackNode = new int[2 * n + 5];
        int[] stackParent = new int[2 * n + 5];
        boolean[] stackExit = new boolean[2 * n + 5];

        int top = 0;
        int timer = 0;

        stackNode[top] = 0;
        stackParent[top] = 0;
        stackExit[top++] = false;

        while (top > 0) {
            top--;

            int u = stackNode[top];
            int p = stackParent[top];
            boolean exit = stackExit[top];

            if (exit) {
                tout[u] = timer - 1;
                continue;
            }

            tin[u] = timer++;

            up[0][u] = p;

            for (int j = 1; j < LOG; j++) {
                up[j][u] = up[j - 1][up[j - 1][u]];
            }

            // Process exit after all children
            stackNode[top] = u;
            stackParent[top] = p;
            stackExit[top++] = true;

            for (int v : adj[u]) {
                if (v == p) {
                    continue;
                }

                depth[v] = depth[u] + 1;

                stackNode[top] = v;
                stackParent[top] = u;
                stackExit[top++] = false;
            }
        }

        char[] chars = s.toCharArray();
        Fenwick bit = new Fenwick(n);

        // Initialize root-to-node prefix XOR masks.
        // Range XOR update on each node's subtree.
        for (int u = 0; u < n; u++) {
            int mask = 1 << (chars[u] - 'a');
            bit.rangeXor(tin[u], tout[u], mask);
        }

        List<Boolean> answer = new ArrayList<>();

        for (String q : queries) {
            String[] parts = q.split(" ");

            if (parts[0].equals("update")) {
                int u = Integer.parseInt(parts[1]);
                char c = parts[2].charAt(0);

                if (chars[u] != c) {
                    int oldMask = 1 << (chars[u] - 'a');
                    int newMask = 1 << (c - 'a');

                    int change = oldMask ^ newMask;

                    bit.rangeXor(tin[u], tout[u], change);
                    chars[u] = c;
                }

            } else {
                int u = Integer.parseInt(parts[1]);
                int v = Integer.parseInt(parts[2]);

                int ancestor = lca(u, v, depth, up, LOG);

                int mask = bit.query(tin[u])
                         ^ bit.query(tin[v])
                         ^ (1 << (chars[ancestor] - 'a'));

                // At most one odd-frequency character
                answer.add((mask & (mask - 1)) == 0);
            }
        }

        return answer;
    }

    private int lca(int u, int v, int[] depth,
                    int[][] up, int LOG) {

        if (depth[u] < depth[v]) {
            int temp = u;
            u = v;
            v = temp;
        }

        int diff = depth[u] - depth[v];

        for (int j = 0; j < LOG; j++) {
            if ((diff & (1 << j)) != 0) {
                u = up[j][u];
            }
        }

        if (u == v) {
            return u;
        }

        for (int j = LOG - 1; j >= 0; j--) {
            if (up[j][u] != up[j][v]) {
                u = up[j][u];
                v = up[j][v];
            }
        }

        return up[0][u];
    }

    static class Fenwick {
        int[] tree;
        int n;

        Fenwick(int n) {
            this.n = n;
            tree = new int[n + 2];
        }

        // XOR at a single index
        void update(int index, int mask) {
            for (int i = index + 1; i <= n + 1;
                 i += i & -i) {
                tree[i] ^= mask;
            }
        }

        // XOR update over [left, right]
        void rangeXor(int left, int right, int mask) {
            update(left, mask);
            update(right + 1, mask);
        }

        // Prefix XOR at a single position
        int query(int index) {
            int result = 0;

            for (int i = index + 1; i > 0;
                 i -= i & -i) {
                result ^= tree[i];
            }

            return result;
        }
    }
}
