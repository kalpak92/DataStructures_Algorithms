/**
 * Design a Leaderboard class, which has 3 functions:
 * 
 *     addScore(playerId, score):   Update the leaderboard by adding score to the given player's score. 
 *                                  If there is no player with such id in the leaderboard, add him to the leaderboard with the given score.
 *     top(K): Return the score sum of the top K players.
 *     reset(playerId): Reset the score of the player with the given id to 0 (in other words erase it from the leaderboard). 
 *                      It is guaranteed that the player was added to the leaderboard before calling this function.
 * 
 * Initially, the leaderboard is empty.
 * 
 * Example 1:
 * Input: 
 * ["Leaderboard","addScore","addScore","addScore","addScore","addScore","top","reset","reset","addScore","top"]
 * [[],[1,73],[2,56],[3,39],[4,51],[5,4],[1],[1],[2],[2,51],[3]]
 * 
 * Output: 
 * [null,null,null,null,null,null,73,null,null,null,141]
 * 
 * Explanation: 
 * Leaderboard leaderboard = new Leaderboard ();
 * leaderboard.addScore(1,73);   // leaderboard = [[1,73]];
 * leaderboard.addScore(2,56);   // leaderboard = [[1,73],[2,56]];
 * leaderboard.addScore(3,39);   // leaderboard = [[1,73],[2,56],[3,39]];
 * leaderboard.addScore(4,51);   // leaderboard = [[1,73],[2,56],[3,39],[4,51]];
 * leaderboard.addScore(5,4);    // leaderboard = [[1,73],[2,56],[3,39],[4,51],[5,4]];
 * leaderboard.top(1);           // returns 73;
 * leaderboard.reset(1);         // leaderboard = [[2,56],[3,39],[4,51],[5,4]];
 * leaderboard.reset(2);         // leaderboard = [[3,39],[4,51],[5,4]];
 * leaderboard.addScore(2,51);   // leaderboard = [[2,51],[3,39],[4,51],[5,4]];
 * leaderboard.top(3);           // returns 141 = 51 + 51 + 39;
 * 
 * Constraints:
 *     1 <= playerId, K <= 10000
 *     It's guaranteed that K is less than or equal to the current number of players.
 *     1 <= score <= 100
 *     There will be at most 1000 function calls.
 * 
 */

 /**
  * 1.Use HashMap to record the people's score
  * 2.Use TreeMap to find the topK in O(klogn) by traverse the treemap
  * 3.Reset we can just remove the key from the treemap which is O(log n), same for addScore().
  */
  
class Leaderboard {
    Map<Integer, Integer> scoreCard;
    TreeMap<Integer, Integer> scoreCount;
    
    public Leaderboard() {
        scoreCard = new HashMap<>();
        scoreCount = new TreeMap<>(Collections.reverseOrder());
    }
    
    public void addScore(int playerId, int score) {
        if(!scoreCard.containsKey(playerId)) {
            scoreCard.put(playerId, score);
            scoreCount.put(score, scoreCount.getOrDefault(score, 0) + 1);
        }
        else {
            int oldScore = scoreCard.get(playerId);
            scoreCount.put(oldScore, scoreCount.get(oldScore) - 1);
            
            if(scoreCount.get(oldScore) == 0)
                scoreCount.remove(oldScore);
            
            int newScore = oldScore + score;
            scoreCard.put(playerId, newScore);
            scoreCount.put(newScore, scoreCount.getOrDefault(newScore, 0) + 1);
        }
    }
    
    public int top(int K) {
        int counter = 0;
        int sum = 0;
        
        for(int score : scoreCount.keySet()) {
            int occurrence = scoreCount.get(score);
            
            for(int i = 0; i < occurrence; i++) {
                sum += score;
                counter++;
                
                if(counter == K)
                    break;
            }
            if(counter == K)
                break;
        }
        return sum;
    }
    
    public void reset(int playerId) {
        int tempScore = scoreCard.get(playerId);
        scoreCount.put(tempScore, scoreCount.get(tempScore) - 1);
        if(scoreCount.get(tempScore) == 0)
            scoreCount.remove(tempScore);
        
        scoreCard.remove(playerId);
    }
}

/**
 * Your Leaderboard object will be instantiated and called as such:
 * Leaderboard obj = new Leaderboard();
 * obj.addScore(playerId,score);
 * int param_2 = obj.top(K);
 * obj.reset(playerId);
 */
