class Node {
    int key;
    int value;
    Node next;
    Node prev;

    Node(int key, int value)
    {
        this.key = key;
        this.value = value;
        this.next = null;
        this.prev = null;
    }

}

/*Use double linked list for adding and removal of node in O(1) time complexity and for recency
In HashMap you need to store key and node - so that node can be retrieved for removal
*/
class LRUCache {
    int capacity;
    HashMap<Integer, Node> cache;
    Node head;
    Node tail;
    int size;

    public LRUCache(int capacity) {

        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.size = 0;
        head = new Node(-1,-1);
        tail = new Node(-1,-1);
        head.next = tail;
        tail.prev = head;
        
        
    }
    
    public int get(int key) {

        if(this.cache.containsKey(key))
        {
            Node newNode = this.cache.get(key);
            delete(newNode);
            add(newNode);
            return this.cache.get(key).value;
        }

        return -1;
        
    }
    
    public void put(int key, int value) {

        if(this.cache.containsKey(key))
        {
            Node oldNode = this.cache.get(key);
            Node newNode = new Node(key, value);
            delete(oldNode);
            add(newNode);
            this.cache.put(key,newNode);
        }
        else
        {
            Node newNode = new Node(key,value);
            this.cache.put(key,newNode);
            this.size++;
            add(newNode);
            if(this.size > this.capacity)
            {
                Node toDelete = head.next;
                cache.remove(toDelete.key);
                delete(toDelete);
            }
        }
        
    }

    public void add(Node node)
    {
        Node p = tail.prev;
        node.prev = p;
        node.next = tail;
        tail.prev = node;
        p.next = node;

    }

    public void delete(Node node)
    {
        Node nxt = node.next;
        Node p = node.prev;
        p.next = nxt;
        nxt.prev = p;


    }
}
