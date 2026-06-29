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
    
    public int goodNodes(TreeNode root) {

        int mx = Integer.MIN_VALUE;

        return countGoodNodes(root, mx);
    }

    public int countGoodNodes(TreeNode root, int mx)
    {
        int count = 0;

        if(root.val >= mx)
        {
            count++;
            mx = root.val;
        }

        if(root.left != null)
        {
            count += countGoodNodes(root.left,mx);
        }
        if(root.right != null)
        {
            count += countGoodNodes(root.right, mx);
        }

        return count;
    }
}
