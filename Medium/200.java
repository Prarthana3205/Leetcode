// 200. Number of islands
// https://leetcode.com/problems/number-of-islands/

// Increase island count.
// Run DFS.
// Convert every connected 1 into 0.
// Continue scanning.

class Solution {
    void dfs(int i,int j,char[][] grid)
    {
        int newrow=grid.length;
        int newcol=grid[0].length;
        if(newrow<=i || newcol<=j || i<0 || j<0 || grid[i][j]=='0')
            return;
        
        grid[i][j]='0';
        dfs(i,j+1,grid);//right
        dfs(i-1,j,grid);//up
        dfs(i,j-1,grid);//left
        dfs(i+1,j,grid);//down        
    }
    public int numIslands(char[][] grid) {
        int row=grid.length;
        int col=grid[0].length;
        int islands=0;
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
                if(grid[i][j]=='1')
                {
                    islands++;
                    dfs(i,j,grid);
                }
            }
        }
        return islands;
    }
}