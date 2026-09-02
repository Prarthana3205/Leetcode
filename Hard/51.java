// 51. N-Queens
// https://leetcode.com/problems/n-queens/description/

import java.util.*;
class Solution {
    List<List<String>> result=new ArrayList<>();
    boolean Safe(char[][] board,int row,int col,int n)
    {
        // checking if there is a Q in the same column
        for(int i=0;i<n;i++)
        {
            if(i!=row && board[i][col]=='Q')
                return false;
        }

        // checking upper-left diagonal
        int i=row-1;
        int j=col-1;
        while(i>=0 && j>=0)
        {
            if(board[i][j]=='Q')
                return false;
            i--;
            j--;
        }

        // checking upper-right diagonal
        i=row-1;
        j=col+1;
        while(i>=0 && j<n)
        {
            if(board[i][j]=='Q')
                return false;
            i--;
            j++;
        }
        // No need to check the lower diagonals because we are filling the board row by row from top to bottom
        // so there won't be any queens placed in the lower rows yet.
        return true;
    }

    void backtrack(char[][] board,int row,int n)
    {
        if(row==n) // When a solution is found
        {
            List<String> sol=new ArrayList<>();
            for(int i=0;i<n;i++)
                sol.add(new String(board[i])); // converting char[] to String
            result.add(sol);
            return;
        }

        for(int col=0;col<n;col++) // Placing a queen in each column of the current row
        {
            if(Safe(board,row,col,n))
            {
                board[row][col]='Q';
                backtrack(board,row+1,n);
                board[row][col]='.'; // undoing the earlier decision 
            }
        }
        
    }

    public List<List<String>> solveNQueens(int n) {
        char[][] board=new char[n][n];
        for(int i=0;i<n;i++)
            Arrays.fill(board[i],'.'); // Initializing the board with '.'
        backtrack(board,0,n);
        return result;        
    }
}