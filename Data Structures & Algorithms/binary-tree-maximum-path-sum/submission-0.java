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
    int maxPath = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {

    findMax(root);

    return maxPath;
        
    }

    public void findMax(TreeNode root)
    {
        if(root == null) return;

        findMax(root.left);
        findMax(root.right);

        int left = getMax(root.left);
        int right = getMax(root.right);

        maxPath = Math.max(maxPath, root.val + left + right);
 
    }

    public int getMax(TreeNode node)
    {
        if(node == null)
        {
            return 0;
        }

        int left = getMax(node.left);
        int right = getMax(node.right);

        int path = node.val + Math.max(left, right);

        return Math.max(0, path);

    }


}
