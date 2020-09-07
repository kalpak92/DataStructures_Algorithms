/**
 * Let's play the minesweeper game (Wikipedia, online game)!
 * 
 * You are given a 2D char matrix representing the game board. 
 * 'M' represents an unrevealed mine, 'E' represents an unrevealed empty square, 
 * 'B' represents a revealed blank square that has no adjacent (above, below, left, right, and all 4 diagonals) mines, 
 * digit ('1' to '8') represents how many mines are adjacent to this revealed square, and finally 'X' represents a revealed mine.
 * 
 * Now given the next click position (row and column indices) among all the unrevealed squares ('M' or 'E'), return the board after revealing this position according to the following rules:
 *     If a mine ('M') is revealed, then the game is over - change it to 'X'.
 *     If an empty square ('E') with no adjacent mines is revealed, then change it to revealed blank ('B') and all of its adjacent unrevealed squares should be revealed recursively.
 *     If an empty square ('E') with at least one adjacent mine is revealed, then change it to a digit ('1' to '8') representing the number of adjacent mines.
 * 
 *     Return the board when no more squares will be revealed.
 * 
 * Example 1:
 * Input: 
 * [['E', 'E', 'E', 'E', 'E'],
 *  ['E', 'E', 'M', 'E', 'E'],
 *  ['E', 'E', 'E', 'E', 'E'],
 *  ['E', 'E', 'E', 'E', 'E']]
 * 
 * Click : [3,0]
 * 
 * Output: 
 * [['B', '1', 'E', '1', 'B'],
 *  ['B', '1', 'M', '1', 'B'],
 *  ['B', '1', '1', '1', 'B'],
 *  ['B', 'B', 'B', 'B', 'B']]
 * 
 * Example 2:
 * Input: 
 * [['B', '1', 'E', '1', 'B'],
 *  ['B', '1', 'M', '1', 'B'],
 *  ['B', '1', '1', '1', 'B'],
 *  ['B', 'B', 'B', 'B', 'B']]
 * 
 * Click : [1,2]
 * Output: 
 * [['B', '1', 'E', '1', 'B'],
 *  ['B', '1', 'X', '1', 'B'],
 *  ['B', '1', '1', '1', 'B'],
 *  ['B', 'B', 'B', 'B', 'B']]
 * 
 * Note:
 *     The range of the input matrix's height and width is [1,50].
 *     The click position will only be an unrevealed square ('M' or 'E'), which also means the input board contains at least one clickable square.
 *     The input board won't be a stage when game is over (some mines have been revealed).
 *     For simplicity, not mentioned rules should be ignored in this problem. 
 *     For example, you don't need to reveal all the unrevealed mines when the game is over, consider any cases that you will win the game or flag any squares.
 */

class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        int m = board.length;
        int n = board[0].length;
        
        int row = click[0];
        int col = click[1];
        
        if(board[row][col] == 'M') {
            board[row][col] = 'X';
            return board;
        }
        dfsHelper(board, row, col);
        return board;
    }
    
    private void dfsHelper(char[][] board, int i, int j) {
        // base condition
        // validate i, j, and board[i][j] == 'E'
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != 'E') {
            return;
        }
        
        int startRow = i - 1 < 0 ? 0: i - 1;
        int endRow = i + 1 >= board.length ? board.length - 1 : i + 1;
        int startCol = j - 1 < 0 ? 0: j - 1;
        int endCol = j + 1 >= board[0].length ? board[0].length - 1 : j + 1;
        
        // Count the number of mines
        int mine = 0;
        for (int m = startRow; m <= endRow; m++) {
            for (int n = startCol; n <= endCol; n++) {
                if (board[m][n] == 'M' || board[m][n] == 'X') {
                    mine++;
                }
            }
        }
        
        if (mine != 0) {
            board[i][j] = (char)(mine + '0');
        } 
        else {
            board[i][j] = 'B';
            
            dfsHelper(board, i + 1, j);
            dfsHelper(board, i - 1, j);
            dfsHelper(board, i, j + 1);
            dfsHelper(board, i, j - 1);
            dfsHelper(board, i + 1, j + 1);
            dfsHelper(board, i + 1, j - 1);
            dfsHelper(board, i - 1, j - 1);
            dfsHelper(board, i - 1, j + 1);
        }
    }
}

