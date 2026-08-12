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
    public boolean isValidBST(TreeNode root) {

        Answer ans = new Answer();

        inorder(root, ans);

        return ans.result;
    }

    class Answer{
        long prev = Long.MIN_VALUE;
        boolean result = true;
    }

    private void inorder(TreeNode root, Answer ans){

        if(!ans.result) return;

        if(root == null) return;

        inorder(root.left, ans);

        if(ans.prev >= root.val) ans.result = false;

        ans.prev = root.val;

        inorder(root.right, ans);

    }
}