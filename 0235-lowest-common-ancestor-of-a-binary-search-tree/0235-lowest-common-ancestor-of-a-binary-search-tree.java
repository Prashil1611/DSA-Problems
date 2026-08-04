/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        TreeNode tmp = root;

        while(tmp != null) {
            if(p.val < tmp.val && q.val < tmp.val){
                tmp = tmp.left;
            }
            else if(p.val > tmp.val && q.val > tmp.val) {
                tmp = tmp.right;
            }
            else{
                return tmp;
            }
        }

        return null;
        
    }
}