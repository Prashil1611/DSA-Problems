/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isBalanced(TreeNode root) {

        Answer ans = new Answer();

        height(root, ans);

        return ans.res;        
        
    }

    class Answer{
        boolean res = true;
    }

    private int height(TreeNode root, Answer ans) {

        if(!ans.res) return 0;   // return something not a problem

        if(root == null) return -1;

        int l_height = height(root.left, ans);
        int r_height = height(root.right, ans);

        if(Math.abs(l_height - r_height) > 1) ans.res = false;

        return 1 + Math.max(l_height, r_height);
    }
}