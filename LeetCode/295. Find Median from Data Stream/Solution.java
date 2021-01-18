/**
 * Median is the middle value in an ordered integer list. 
 * If the size of the list is even, there is no middle value. 
 * So the median is the mean of the two middle value.
 * 
 * For example,
 * [2,3,4], the median is 3
 * 
 * [2,3], the median is (2 + 3) / 2 = 2.5
 * 
 * Design a data structure that supports the following two operations:
 * 
 * void addNum(int num) - Add a integer number from the data stream to the data structure
 * double findMedian() - Return the median of all elements so far.
 * 
 * Example:
 * 
 * addNum(1)
 * addNum(2)
 * findMedian() -> 1.5
 * addNum(3) 
 * findMedian() -> 2
 * 
 * Follow up:
 * If all integer numbers from the stream are between 0 and 100, how would you optimize it?
 * If 99% of all integer numbers from the stream are between 0 and 100, how would you optimize it?
 */

 /**
  * Algorithm
  Two priority queues:
  
  - A max-heap lo to store the smaller half of the numbers
  - A min-heap hi to store the larger half of the numbers

  The max-heap lo is allowed to store, at worst, 
  one more element more than the min-heap hi.

  Adding a number num:
    Add num to max-heap lo. Since lo received a new element, we must do a balancing step for hi. 
    So remove the largest element from lo and offer it to hi.
    
    The min-heap hi might end holding more elements than the max-heap lo, after the previous operation. 
    We fix that by removing the smallest element from hi and offering it to lo.
    The above step ensures that we do not disturb the nice little size property we just mentioned.
  */


  class MedianFinder {

    PriorityQueue<Integer> lowerHalf;
    PriorityQueue<Integer> upperHalf;
    /** initialize your data structure here. */
    public MedianFinder() {
        lowerHalf = new PriorityQueue<>((a, b) -> b - a);
        upperHalf = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        lowerHalf.offer(num);
        upperHalf.offer(lowerHalf.poll());
        
        if(upperHalf.size() > lowerHalf.size())
            lowerHalf.offer(upperHalf.poll());
    }
    
    public double findMedian() {
        if(lowerHalf.size() > upperHalf.size())
            return lowerHalf.peek()/1.0;
        
        return (lowerHalf.peek() + upperHalf.peek())/2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
/*