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

public class Codec {

    int index = 0;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        List<String> result = new ArrayList<>();
        preorder(root, result);

        return String.join(",", result);
        
    }

    public void preorder(TreeNode node, List<String> result)
    {
        if(node != null)
        {
            result.add(String.valueOf(node.val));
            preorder(node.left, result);
            preorder(node.right, result);
        }
        else
        {
            result.add("#");
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        String[] nodes = data.split(",");

        return dfs(nodes);
        
    }

    public TreeNode dfs(String[] nodes)
    {
        String val = nodes[index];
        if(val.equals("#"))
        {
            index++;
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(val));
        index++;
        node.left = dfs(nodes);
        node.right = dfs(nodes);

        return node;
    }
}
