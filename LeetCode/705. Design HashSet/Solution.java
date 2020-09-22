import java.util.LinkedList;

/**
 * @author kalpak
 *
 * Design a HashSet without using any built-in hash table libraries.
 *
 * To be specific, your design should include these functions:
 *
 *     add(value): Insert a value into the HashSet.
 *     contains(value) : Return whether the value exists in the HashSet or not.
 *     remove(value): Remove a value in the HashSet. If the value does not exist in the HashSet, do nothing.
 *
 *
 * Example:
 *
 * MyHashSet hashSet = new MyHashSet();
 * hashSet.add(1);
 * hashSet.add(2);
 * hashSet.contains(1);    // returns true
 * hashSet.contains(3);    // returns false (not found)
 * hashSet.add(2);
 * hashSet.contains(2);    // returns true
 * hashSet.remove(2);
 * hashSet.contains(2);    // returns false (already removed)
 *
 *
 * Note:
 *
 *     All values will be in the range of [0, 1000000].
 *     The number of operations will be in the range of [1, 10000].
 *     Please do not use the built-in HashSet library.
 */


class MyHashSet {
    // Since for any update operation, we would need to scan the entire bucket first to avoid any duplicate, a better choice for the implementation of bucket would be the LinkedList, which has a constant time complexity for the insertion as well as deletion, once we locate the position to update.
    private Bucket[] buckets;
    private int keyRange;
    
    /** Initialize your data structure here. */
    public MyHashSet() {
        //  Use a prime number as the base of modulo, e.g. 769, in order to reduce the potential collisions.
        keyRange = 769;
        buckets = new Bucket[keyRange];
        
        for(int i = 0; i < keyRange; i++) {
            buckets[i] =  new Bucket();
        }
    }
    
    public void add(int key) {
        int bucketIdx = getHash(key);
        buckets[bucketIdx].insert(key);
    }
    
    public void remove(int key) {
        int bucketIdx = getHash(key);
        buckets[bucketIdx].delete(key);
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int bucketIdx = getHash(key);
        return buckets[bucketIdx].isPresent(key);
    }
    
    private int getHash(int key) {
        return (key % keyRange);
    }
    
    class Bucket {
        private LinkedList<Integer> container;
        
        public Bucket() {
            container = new LinkedList<>();
        }
        
        public void insert(Integer key) {
            int idx = container.indexOf(key);
            if(idx == - 1) {
                container.addFirst(key);
            }
        }
        
        public void delete(Integer key) {
            container.remove(key);
        }
        
        public boolean isPresent(Integer key) {
            int idx = container.indexOf(key);
            return (idx != -1);
        }
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
