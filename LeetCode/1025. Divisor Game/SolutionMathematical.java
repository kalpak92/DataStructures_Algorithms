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

/**
 * The proof of why this works can be done formally using Mathematical Induction, specifically using Strong Mathematical Induction. 
 * However an informal proof will also suffice. 
 * 
 * Note that it is not enough to show that a player who starts on even always wins. 
 * One must also show that a player that starts on odd always loses. 
 * Otherwise there are more possible ways to guarantee winning aside from starting on even.
 * 
 * Given: The Divisor Game as outlined in the problem
 * Prove: Alice will win if and only if N % 2 == 0
 * Part 1)  If Alice starts with an even number she will always win.
 *          If Alice has an even number, she can always subtract 1, giving Bob an odd number. Odd numbers are not divisible by 2. 
 *          They are only divisible by odd numbers. 
 *          Hence Bob must subtract an odd number. 
 *          Since odd minus odd is even, Bob will always return an even number to Alice. 
 *          Alice will thus get a smaller even number after each round of play and Bob will get a smaller odd number after each round of play. 
 *          Eventually Bob will have to play the number 1 and will lose the game since he will have no options.
 * 
 * Part 2)  If Alice starts with an odd number she will always lose.
 *          If Alice has an odd number, she has no choice but to subtract an odd number as odd numbers have no even divisors. 
 *          Thus Bob will get an even number. Now using the argument from Part 1 above, Bob can take this even number and keep giving an odd number back to Alice by subtracting 1. Thus Bob will always get to play even and Alice will always be stuck with an odd number smaller than her previous odd number after each round. 
 *          Eventually Alice will have to play the number 1 and will lose the game since she will have no options.
 *          Thus, assuming both players play optimally, Alice will win the game if and only if she starts on an even number (i.e. N % 2 == 0).

 */

public class SolutionMathematical
    public boolean divisorGame(int N) {
        return (N & 1) == 0;  
    }
}