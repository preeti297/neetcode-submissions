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
    int count = 0;
    public int kthSmallest(TreeNode root, int k) {

        int ansl = -1, ansr = -1;

        if(root != null)
        {
            ansl = kthSmallest(root.left,k);
            count++;
            if(count == k)
                return root.val;
            ansr = kthSmallest(root.right,k);
        }

        return ansl != -1 ? ansl : ansr;
        
    }
}
