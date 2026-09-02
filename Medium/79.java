// 79. Word Search
// https://leetcode.com/problems/word-search/description/

// DFS approach with backtracking. The idea is to explore all possible paths in the grid starting from each cell 
// and check if we can form the given word. We mark cells as visited by temporarily changing their value 
// and restore them after exploring all paths from that cell.

class Solution {
    boolean dfs(char[][] board, String word, int i, int j, int ind)
    {
        int row=board.length;
        int col=board[0].length;
        int len=word.length();

        if(word.length()==ind)
            return true;
            
        if(i<0 || i>=row || j<0 || j>=col || ind>=len)
            return false;
        
        if(word.charAt(ind)!=board[i][j])
            return false;
        
        char temp=board[i][j];
        board[i][j]='#';
        boolean found=dfs(board,word,i-1,j,ind+1) //up
        || dfs(board,word,i+1,j,ind+1) //down
        || dfs(board,word,i,j+1,ind+1) //right
        || dfs(board,word,i,j-1,ind+1); //left

        board[i][j]=temp;
        return found;
    }
    public boolean exist(char[][] board, String word) {
        int row=board.length;
        int col=board[0].length;

        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++) // checking for each cell if it can be the starting point of the word
            {
                if(dfs(board,word,i,j,0))
                    return true;
            }
        }
        return false;
    }
}