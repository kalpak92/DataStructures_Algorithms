/**
 * Given a list of scores of different students, return the average score of each student's top five scores in the order of each student's id.
 * Each entry items[i] has items[i][0] the student's id, and items[i][1] the student's score.  
 * The average score is calculated using integer division.
 * 
 * Example 1:
 * Input: [[1,91],[1,92],[2,93],[2,97],[1,60],[2,77],[1,65],[1,87],[1,100],[2,100],[2,76]]
 * Output: [[1,87],[2,88]]
 * Explanation: 
 * The average of the student with id = 1 is 87.
 * The average of the student with id = 2 is 88.6. But with integer division their average converts to 88.
 * 
 * Note:
 *     1 <= items.length <= 1000
 *     items[i].length == 2
 *     The IDs of the students is between 1 to 1000
 *     The score of the students is between 1 to 100
 *     For each student, there are at least 5 scores
 */

class Solution {
    public int[][] highFive(int[][] items) {
        Map<Integer, PriorityQueue<Integer>> map = new TreeMap<>();
        
        for(int[] i : items) {
            int studentId = i[0];
            int score = i[1];
            
            // Get the priority queue for the respective student.
            // If not present, create it.
            PriorityQueue<Integer> pq = map.getOrDefault(studentId, new PriorityQueue<Integer>(5));
            
            pq.offer(score);
            if(pq.size() > 5)
                pq.poll();
            
            map.put(studentId, pq);
        }
        
        // Process the data
        int idx = 0;
        int[][] result = new int[map.size()][2];
        
        for(int studentId : map.keySet()) {
            PriorityQueue<Integer> temp = map.get(studentId);
            int sum = 0;
            while(!temp.isEmpty()) {
                sum += temp.poll();
            }
            
            result[idx][0] = studentId;
            result[idx][1] = sum/5;
            idx++;
        }
        return result;
    }
}