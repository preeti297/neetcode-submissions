class TrieNode
{
    Map<Character, TrieNode> children;
    boolean isEndOfWord;

    public TrieNode()
    {
        children = new HashMap<>();
        isEndOfWord = false;
    }
}
class PrefixTree {

    TrieNode root;

    public PrefixTree() {
         root = new TrieNode();
    }

    public void insert(String word) {

        TrieNode node = root;

        for(Character ch : word.toCharArray())
        {
            if(!node.children.containsKey(ch))
            {
            TrieNode newNode = new TrieNode();

            node.children.put(ch, newNode);
            }

            node = node.children.get(ch);


        }

        node.isEndOfWord = true;

    }

    public boolean search(String word) {

        TrieNode node = root;

        for(Character ch : word.toCharArray())
        {

            if(!node.children.containsKey(ch))
                return false;

            node = node.children.get(ch);


        }

        return node.isEndOfWord;

    }

    public boolean startsWith(String prefix) {

        TrieNode node = root;

        for(Character ch : prefix.toCharArray())
        {

            if(!node.children.containsKey(ch))
                return false;

            node = node.children.get(ch);


        }

        return true;

    }
}
