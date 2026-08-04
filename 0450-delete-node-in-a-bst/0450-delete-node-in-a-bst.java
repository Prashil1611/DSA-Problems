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
    public TreeNode deleteNode(TreeNode root, int key) {

        if(root == null) return null;

        if(key < root.val){
            root.left = deleteNode(root.left, key);
        }
        else if(key > root.val){
            root.right = deleteNode(root.right, key); 
        }
        else{

            // if current node have no chile (leaf node)
            if(root.left == null && root.right == null){
                return null;
            }

            // if node have 2 children
            else if(root.left != null && root.right != null){
                int succ = successor(root);
                root.val = succ;
                root.right = deleteNode(root.right, succ);
            }

            // if node have only one chile
            else{
                if(root.left == null) return root.right;
                if(root.right == null) return root.left;
            }
        }

        return root;
        
    }

    private int successor(TreeNode root) {

        int ans = 999999;        // i'm sure ans can be 100% change so take any value 
        TreeNode tmp = root;
        int data = tmp.val;

        while(tmp != null){
            if(data < tmp.val){
                ans = tmp.val;
                tmp = tmp.left;
            }
            else{
                tmp = tmp.right;
            }
        }

        return ans;
    }
}