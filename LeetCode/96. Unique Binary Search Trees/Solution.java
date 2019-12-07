/**
 * Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?
 * 
 * Example:
 * Input: 3
 * Output: 5
 * Explanation:
 * Given n = 3, there are a total of 5 unique BST's:
 * 
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 */

class Solution {
    public int numTrees(int n) {
        int[] G = new int[n + 1];
        
        G[0] = 1;
        G[1] = 1;
        
        for(int j = 2; j <=n; j++)
        {
            for(int i = 1; i <= j; i++)
            {
                // All possible unique left BST's count is G[i - 1] if we plant at j.
                // All possible unique right BST's count is G[j - i] if we plant at j.
                // Taking a product is the same as taking all pairing between the two sets of possibilites.
                G[j] += G[i - 1]*G[j - i];
            }
        }
        
        return G[n];
    }
}