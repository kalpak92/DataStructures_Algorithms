/**
 * Alice and Bob take turns playing a game, with Alice starting first.
 * 
 * Initially, there is a number N on the chalkboard.  On each player's turn, that player makes a move consisting of:
 * 
 * Choosing any x with 0 < x < N and N % x == 0.
 * Replacing the number N on the chalkboard with N - x.
 * Also, if a player cannot make a move, they lose the game.
 * 
 * Return True if and only if Alice wins the game, assuming both players play optimally.
 * 
 * Example 1:
 * Input: 2
 * Output: true
 * Explanation: Alice chooses 1, and Bob has no more moves.
 * 
 * Example 2:
 * Input: 3
 * Output: false
 * Explanation: Alice chooses 1, Bob chooses 1, and Alice has no more moves.
 */

class Solution {
    public boolean divisorGame(int N) {
        boolean[] dp = new boolean [N + 1];
        
        // Alice will try all factors and choose the one which gives his opponent a losing value.
        // dp[i] indicates the result of the game for the given number i and for the player who started the game.
        for(int num = 2; num <= N; num++)
        {
            for(int fact = 1; fact < num; fact++)
            {
                /**
                 * Here i is the number which we are calculating for. And j needs to be checked whether it is a factor of i or not.
                 * So, here, initially, the factor is checked using i % j == 0.
                 * Now suppose j is a factor of i, it is important to see whether the difference of i and j is odd or not.
                 * The main reason being the current player's will to win.
                 * If the difference is odd, the program feeds this to the opponent and consequently, the opponent is forced to return back an even number since the factors of an odd number are odd and the difference between two odd numbers is even.
                 * So, dp[i - j] checks in the bottom-up computation, whether such a choice had given a false in the past and then, it updates it to true.
                 */
                if(num % fact == 0 && dp[num - fact] == false)
                {
                    dp[num] = true;
                    break;
                }
            }
        }
        return dp[N];
    }
}