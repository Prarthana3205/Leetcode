// 37. Sudoku Solver
// https://leetcode.com/problems/sudoku-solver/

// very similar to N Queens problem
class Solution {
    boolean issafe(char[][] board,int row,int col,char digit)
    {
        for(int j=0;j<9;j++)
        {
            // check row
            if(board[row][j]==digit && j!=col)
                return false;
            
            // check column
            if(board[j][col]==digit && j!=row)
                return false;
        }

        int startrow=(row/3)*3;
        int startcol=(col/3)*3;
        for(int i=startrow;i<startrow+3;i++)
        {
            for(int j=startcol;j<startcol+3;j++)
            {
                if(board[i][j]==digit && i!=row && j!=col)
                    return false;
            }
        }
        return true;
    }

    boolean backtrack(char[][] board,int row,int col)
    {
        if(row==9)
            return true;
        
        int nextrow=(col==8)?row+1:row;
        int nextcol=(col==8)?0:col+1;

        if(board[row][col]!='.')
            return backtrack(board,nextrow,nextcol);

        for(char digit='1';digit<='9';digit++)
        {
            if(issafe(board,row,col,digit))
            {
                board[row][col]=digit;
                if(backtrack(board,nextrow,nextcol))
                    return true;
                board[row][col]='.';
            }
        }
        return false;
    }
    
    public void solveSudoku(char[][] board) {
        backtrack(board,0,0);
    }
}