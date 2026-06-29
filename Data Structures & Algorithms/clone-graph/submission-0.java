/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {

        if(node == null)
        {
            return null;
        }

        HashMap<Integer, Node> visited = new HashMap<>();

        return dfs(node,visited);
        
    }

    public Node dfs(Node node, HashMap<Integer, Node> visited)
    {
        

        Node newNode = new Node(node.val);

        visited.put(node.val, newNode);

        for(Node nei : node.neighbors)
        {
            if(!visited.containsKey(nei.val))
            {
                newNode.neighbors.add(dfs(nei,visited));
            }
            else
            {
                newNode.neighbors.add(visited.get(nei.val));
            }
        }

        return newNode;
    }
}