/**
 * Design a HashMap without using any built-in hash table libraries.
 *
 * To be specific, your design should include these functions:
 *
 *     put(key, value) : Insert a (key, value) pair into the HashMap. If the value already exists in the HashMap, update the value.
 *     get(key): Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key.
 *     remove(key) : Remove the mapping for the value key if this map contains the mapping for the key.
 *
 *
 * Example:
 *
 * MyHashMap hashMap = new MyHashMap();
 * hashMap.put(1, 1);
 * hashMap.put(2, 2);
 * hashMap.get(1);            // returns 1
 * hashMap.get(3);            // returns -1 (not found)
 * hashMap.put(2, 1);          // update the existing value
 * hashMap.get(2);            // returns 1
 * hashMap.remove(2);          // remove the mapping for 2
 * hashMap.get(2);            // returns -1 (not found)
 *
 *
 * Note:
 *
 *     All keys and values will be in the range of [0, 1000000].
 *     The number of operations will be in the range of [1, 10000].
 *     Please do not use the built-in HashMap library.
 */

class MyHashMap {

    private Node[] bucket;
        
    /** Initialize your data structure here. */
    public MyHashMap() {
        bucket = new Node[10000];
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int hashIndex = getIndex(key);      // identify the bucket
		Node prev = findElement(hashIndex, key);
        
        if (prev.next == null)      // Node with given key does not exist
			prev.next = new Node(key, value);
		else 
			prev.next.val = value;  // update the value of the corresponding key
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int hashIndex = getIndex(key);
        Node prev = findElement(hashIndex, key);
        
        if(prev.next == null)
            return -1;
        else 
            return prev.next.val;
            
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int hashIndex = getIndex(key);
        Node prev = findElement(hashIndex, key);
        
        if(prev.next != null)
            prev.next = prev.next.next;
    }
    
    private int getIndex(int key) {	
		return Integer.hashCode(key) % bucket.length;
	}
    
    private Node findElement(int hashIndex, int key) {
        // check if the hashIndex exists at all
        if(bucket[hashIndex] == null) {
            bucket[hashIndex] = new Node(-1, -1);
            return bucket[hashIndex];
        }
        
        // The bucket exists
        // Traverse through the linked list and return the previous node.
        // There can be 2 cases:
        //      1. Node with the same key exists
        //      2. The node with the given doesn't exist
        // In both the cases, returh the previous node.
        Node temp = bucket[hashIndex];
        while(temp.next != null && temp.next.key != key)
            temp = temp.next;
        
        return temp;
    }
    
    private static class Node {
		int key, val;
		Node next;

		Node(int key, int val) {
			this.key = key;
			this.val = val;
		}
	}
}



/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
