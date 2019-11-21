/**
 * Given a 2D board and a list of words from the dictionary, find all words in the board.
 * Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are 
 * those horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.
 * 
 * Example:
 * Input: 
 * board = [
 *   ['o','a','a','n'],
 *   ['e','t','a','e'],
 *   ['i','h','k','r'],
 *   ['i','f','l','v']
 * ]
 * 
 * words = ["oath","pea","eat","rain"]
 * Output: ["eat","oath"]
 * 
 * Note:
 * All inputs are consist of lowercase letters a-z.
 * The values of words are distinct.
 */

class Solution {
    int[] x = {0, 0, -1, 1};
    int[] y = {-1, 1, 0, 0};
    
    public List<String> findWords(char[][] board, String[] words) {
        Trie tr = new Trie();
        Node root = tr.root;
        
        Set<String> result = new HashSet<>();
        
        for(String w : words)
            tr.insert(w);
        
        for(int i = 0; i < board.length; i++)
        {
            for(int j = 0; j < board[i].length; j++)
            {
                char c = board[i][j];
                if(root.count[c-'a'] != null)
                {
                    dfs(board, i, j, root, c, result);
                }
            }
        }
        
        return new ArrayList<>(result);
    }
    
    private boolean isOutside(char[][] board, int i, int j)
    {
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length)
            return true;
        return false;
    }
    
    private void dfs(char[][] board, int i, int j, Node current, char c, Set<String> result)
    {
        if(isOutside(board, i, j) || board[i][j] == '#' || current.count[c - 'a'] == null)
            return;
        
        char temp = board[i][j];
        board[i][j] = '#';
        
        current = current.count[temp - 'a'];
        
        if (current != null && current.eow)
            result.add(current.word);
        
        for(int k = 0; k < x.length; k++)
        {
            int row = i + x[k];
            int col = j + y[k];
            
            if(isOutside(board, row, col))
               continue;
            
            dfs(board, row, col, current, board[row][col], result);
        }
        
        board[i][j] = temp;
        return;
    }
}

// Trie Node Class
class Node
{
    Node[] count = new Node[26];
    boolean eow;        // to track the end of word
    String word;        // stores the word
    
    Node()
    {
        for(int i = 0; i < count.length; i++)
        {
            count[i] = null;
        }
        
        eow = false;
        word = null;
    }
}

// Trie class
class Trie
{
    Node root = new Node(); // create a root trie node.
    
    public void insert(String str)
    {
        Node current = root;
        
        for(int i = 0; i < str.length(); i++)
        {
            int index = str.charAt(i) -'a';
            
            if(current.count[index] == null)
            {
                current.count[index] = new Node();
            }
            current = current.count[index];
        }
        current.word = str;
        current.eow = true;
    }
}