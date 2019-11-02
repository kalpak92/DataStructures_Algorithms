/**
 * Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 * 
 * Example:
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * 
 * After running your function, the board should be:
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 * 
 * Explanation:
 * Surrounded regions shouldn’t be on the border, which means that any 'O' on the border of the board are not flipped to 'X'. 
 * Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'. 
 * Two cells are connected if they are adjacent cells connected horizontally or vertically.
 * 
 * * * * * * * * * * * *
 * ALGORITHM:
 * 1. Check  the borders of the matrix.
 *   If there's a 'O', alter it and its neighbouring O's to '-'.
 * 
 * 2. Alter all the other 'O' to 'X'.
 * 3. Alter all the '-' to 'O'.
 */

class Solution {
    public void solve(char[][] board) {
        if (board.length == 0 || board == null) 
            return;
        
        for (int i = 0; i < board[0].length; i++)
        {   // Check first row
            if (board[0][i]=='O') 
                setSign(0, i, board);
        }
        
        for (int i = 0; i < board[0].length; i++)
        {   // Check last row
            if (board[board.length - 1][i] == 'O') 
                setSign(board.length - 1, i, board);
        }
        
        for (int i = 0; i < board.length; i++)
        {   // Check first column
            if (board[i][0] == 'O') 
                setSign(i, 0, board);
        }
        
        for (int i = 0; i < board.length; i++)
        {   // Check last column
            if (board[i][board[i].length - 1] =='O') 
                setSign(i, board[i].length - 1, board);
        }
        
        for (int i = 0; i < board.length; i++)
        {
            for (int j = 0; j < board[i].length; j++)
            {
                if (board[i][j] == 'O') 
                    board[i][j] = 'X';
            }
        }
        
        for (int i = 0; i< board.length; i++)
        {
            for (int j = 0; j < board[i].length; j++)
            {
                if (board[i][j] == '-') 
                    board[i][j] = 'O';
            }
        }
    }
    
    public void setSign(int i,int j, char[][] board)
    {
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != 'O') 
            return;
        
        board[i][j]='-';
        
        setSign(i+1, j, board);
        setSign(i-1, j, board);
        setSign(i, j+1, board);
        setSign(i, j-1, board);
    }
}