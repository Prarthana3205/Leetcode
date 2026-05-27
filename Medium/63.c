// 63. Unique Paths II
// https://leetcode.com/problems/unique-paths-ii/description/

// same as UniquePaths.c , extra if conditions

int uniquePathsWithObstacles(int** obstacleGrid, int obstacleGridSize, int* obstacleGridColSize) {
    
    int m=obstacleGridSize;
    int n=obstacleGridColSize[0];

    int dp[m][n];
    if(obstacleGrid[0][0]==1) // if first cell is an obtacle the robot cannot move therefore 0
        return 0;
    dp[0][0]=1;

    // First row
    for(int i=1;i<n;i++)
    {
        if(obstacleGrid[0][i]==1)
            dp[0][i]=0;
        else
            dp[0][i]=dp[0][i-1];
    }

    // First column
    for(int i=1;i<m;i++)
    {
        if(obstacleGrid[i][0]==1)
            dp[i][0]=0;
        else
            dp[i][0]=dp[i-1][0];
    }

    for(int i=1;i<m;i++)
    {
        for(int j=1;j<n;j++)
        {
            if(obstacleGrid[i][j]==1)
                dp[i][j]=0;
            else
                dp[i][j]=dp[i-1][j]+dp[i][j-1]; // top+left
        }
    }
    return dp[m-1][n-1];
}