// 52. N-Queens II
// https://leetcode.com/problems/n-queens-ii/description/

// Refer to the solution of N-Queens problem (51) 

import java.util.*;
class Solution {
    int result;
    boolean Safe(int[][] board,int row,int col,int n)
    {
        // checking same column
        for(int i=0;i<n;i++)
        {
            if(i!=row && board[i][col]==1)
                return false;
        }

        // checking upper left diagonal
        int i=row-1;
        int j=col-1;
        while(i>=0 && j>=0)
        {
            if(board[i][j]==1)
                return false;
            i-=1;
            j-=1;
        }

        // checking upper right diagonal
        i=row-1;
        j=col+1;
        while(i>=0 && j<n)
        {
            if(board[i][j]==1)
                return false;
            i-=1;
            j+=1;
        }
        return true;
    }

    void backtrack(int[][] board,int row,int n)
    {
        if(row==n)
        {
            result++;
            return;
        }

        for(int col=0;col<n;col++)
        {
            if(Safe(board,row,col,n))
            {
                board[row][col]=1;
                backtrack(board,row+1,n);
                board[row][col]=0;
            }
        }
    }
    public int totalNQueens(int n) {
        int[][] board=new int[n][n];
        for(int i=0;i<n;i++)
            Arrays.fill(board[i],0);
        backtrack(board,0,n);
        return result;
    }
}