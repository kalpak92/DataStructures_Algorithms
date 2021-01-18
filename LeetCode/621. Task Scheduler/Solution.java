/**
 * Given a char array representing tasks CPU need to do. 
 * It contains capital letters A to Z where different letters represent different tasks. Tasks could be done without original order. 
 * Each task could be done in one interval. For each interval, CPU could finish one task or just be idle.
 * However, there is a non-negative cooling interval n that means between two same tasks, 
 * there must be at least n intervals that CPU are doing different tasks or just be idle.
 * 
 * You need to return the least number of intervals the CPU will take to finish all the given tasks.
 * 
 * Example:
 * Input: tasks = ["A","A","A","B","B","B"], n = 2
 * Output: 8
 * Explanation: A -> B -> idle -> A -> B -> idle -> A -> B.
 * 
 * Note:
 * The number of tasks is in the range [1, 10000].
 * The integer n is in the range [0, 100].
 */

class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a)); // O(log(26)) 

        int result = 0;
        
        // Build the frequency map
        for(char c : tasks)
            map.put(c, map.getOrDefault(c, 0) + 1);
        
        // Create the maxHeap based on the frequency
        maxHeap.addAll(map.keySet());
        
        while(!maxHeap.isEmpty()) {
            int interval = n + 1;
            Queue<Character> waitQueue = new LinkedList<>();
            
            while(interval > 0 && !maxHeap.isEmpty()) {
                Character temp = maxHeap.poll();    // Most Frequent task
                map.put(temp, map.get(temp) - 1);   // reduce the count of occurence, because a unit of task is done;
                // add it to the waitQueue
                waitQueue.offer(temp);
            
                interval--;     // reduce the interval
                result++;       // update the result
            }
            
            // Flush the waitQueue and put the tasks back to the MaxHeap
            while(!waitQueue.isEmpty()) {
                Character temp = waitQueue.poll();
                if(map.get(temp) > 0)
                    maxHeap.offer(temp);
            }
            
            // if the heap is empty, no more tasks to be done
            if(maxHeap.isEmpty())
                break;
            
            result = result + interval; // // if interval > 0, then it means we need to be idle          
        }
        return result;
    }
}