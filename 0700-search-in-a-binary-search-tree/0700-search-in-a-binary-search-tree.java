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
    public TreeNode searchBST(TreeNode root, int val) {

        TreeNode tmp = root;
        while(tmp != null) {
            if(val < tmp.val){
                tmp = tmp.left;
            }
            else if(val > tmp.val){
                tmp = tmp.right;
            }
            else{
                return tmp;
            }
        }

        return null;
        
    }
}