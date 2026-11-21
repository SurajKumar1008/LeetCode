class LRUCache {

    class Node{
        int key;
        int value;
        Node prev;
        Node next;
      
       Node(int key, int value){
        this.key = key;
        this.value = value;
       }
    }

    HashMap<Integer, Node> map;
    Node head,tail;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();

        head = new Node(0,0);
        tail = new Node(0,0);

        head.next = tail;
        tail.prev = head;

    }
    private void remove(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    private void add(Node node){
        node.next = tail;
        node.prev = tail.prev;

        tail.prev.next = node;
        tail.prev = node;
    }
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        Node node = map.get(key);
        remove(node);
        add(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            remove(node);
            node.value = value;
            add(node);
        } else {
            if(map.size()==capacity){
                Node lru = head.next;
                remove(lru);
                map.remove(lru.key);
            }
            Node node = new Node(key, value);
            map.put(key,node);
            add(node);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */