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
class WordDictionary {

    TrieNode root;

    public WordDictionary() {
        
        root = new TrieNode();

    }

    public void addWord(String word) {

        TrieNode node = root;

        for(Character ch : word.toCharArray())
        {
            if(!node.children.containsKey(ch))
            {
                node.children.put(ch, new TrieNode());
            }

            node = node.children.get(ch);
        }

        node.isEndOfWord = true;

    }

    public boolean search(String word) {

         return helper(root, word, 0);

    }

    private boolean helper(TrieNode node, String word, int index)
    {
        TrieNode curr = node;
 
        for(int i = index; i < word.length() ; i ++)
        {
            char ch = word.charAt(i);
           if(ch != '.')
           {
            if(!curr.children.containsKey(ch))
                return false;
            curr = curr.children.get(ch);
           }
           else
           {
            for(Character chr : curr.children.keySet())
            {
                TrieNode child = curr.children.get(chr);

                if(helper(child, word, i + 1))
                    return true;
            }
            return false;
           }

            
        }

        return curr.isEndOfWord;
    }
}
