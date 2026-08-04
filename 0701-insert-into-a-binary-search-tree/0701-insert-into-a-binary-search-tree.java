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
    public TreeNode insertIntoBST(TreeNode root, int val) {

        if(root == null) return new TreeNode(val);

        TreeNode tmp = root;
        TreeNode parent = root;

        while(tmp != null){

            parent = tmp;

            if(val < tmp.val){
                tmp = tmp.left;
            }
            else{
                tmp = tmp.right;
            }
        }

        if(val < parent.val) parent.left = new TreeNode(val);
        else parent.right = new TreeNode(val);

        return root;

//         if(root == null){
//             root = new TreeNode(val);
//             return root;
//         }

//         if(val < root.val){
//             root.left = insertIntoBST(root.left, val);
//         }
//         else{
//             root.right = insertIntoBST(root.right, val);
//         }

//         return root;
        
    }
}