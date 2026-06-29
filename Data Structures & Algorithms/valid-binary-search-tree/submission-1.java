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

        return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        
    }

    public boolean isBST(TreeNode node, int mn, int mx)
    {
        if(node == null)
            return true;
        
        if(node.val >= mx  || node.val <= mn)
            return false;
        
        return isBST(node.left, mn, node.val) && isBST(node.right, node.val,mx);
    }
}
