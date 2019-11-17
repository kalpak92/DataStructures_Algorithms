/**
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.
 * 
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
 * 
 * The cache is initialized with a positive capacity.
 * 
 * Follow up:
 * Could you do both operations in O(1) time complexity?
 * 
 * Example:
 * 
 * LRUCache cache = new LRUCache( 2 );
 * cache.put(1, 1);
 * cache.put(2, 2);
 * cache.get(1);       // returns 1
 * cache.put(3, 3);    // evicts key 2
 * cache.get(2);       // returns -1 (not found)
 * cache.put(4, 4);    // evicts key 1
 * cache.get(1);       // returns -1 (not found)
 * cache.get(3);       // returns 3
 * cache.get(4);       // returns 4
 */

class LRUCache 
{
    Map<Integer, ListNode> table = new HashMap<Integer, ListNode>();
    
    ListNode head;
    ListNode tail;
    
    int itemsInCache;
    int maxCapacity;
    
    public LRUCache(int capacity) 
    {
        this.maxCapacity = capacity;
        itemsInCache = 0;
        
        head = new ListNode();
        tail = new ListNode();
        
        // wire in the head and the tail
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        // fetch from the hashMap
        ListNode node  = table.get(key);
        
        if (node == null)
            return -1;
        
        // move the accessed element to the head of the DLL.
        moveToHead(node);
        
        return node.value;
    }
    
    public void put(int key, int value) 
    {
        // check if the node already exists
        ListNode node = table.get(key);

        if (node == null) // node doesn't exist. create the node and add it to the head of the DLL.
        {
            // create the node
            ListNode newNode = new ListNode();
            newNode.key = key;
            newNode.value = value;
            
            // add to the hashmap
            table.put(key, newNode);
            
            // add to the front of the DLL
            addToFront(newNode);
            
            // increment the cache counter
            itemsInCache++;
            
            // check if items in cache crosses the limit
            if(itemsInCache > maxCapacity)
            {
                // remove following LRU principle
                removeLRU();
            }
        }
        else {
            // node exists. Move the node to the front.
            node.value = value;
            moveToHead(node);
        }
    }
    
    // HELPER FUNCTIONS
    private void moveToHead(ListNode node)
    {
        removeFromList(node);
        addToFront(node);
    }
    
    private void removeFromList(ListNode node)
    {
        ListNode prevNode = node.prev;
        ListNode nextNode = node.next;
        
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }
    
    private void addToFront(ListNode node)
    {
        node.prev = head;
        node.next = head.next;
        
        head.next.prev = node;
        head.next = node;
    }
    
    private void removeLRU()
    {
        ListNode tail  = popTail();
        
        table.remove(tail.key);
        --itemsInCache;
    }
    
    private ListNode popTail()
    {
        ListNode tailNode  = tail.prev;
        
        removeFromList(tailNode);
        
        return tailNode;
    }
    
    private class ListNode
    {
        int key;
        int value;
        
        ListNode prev;
        ListNode next;
    }
}



/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
    /*
  LRU Cache - LeetCode: https://leetcode.com/problems/lru-cache/
  This code passes all Leetcode test cases as of Oct. 1st 2019
*/