// 62. Unique Paths
// https://leetcode.com/problems/unique-paths/description/

// Very similar to 4-TotalMoney.c (excluding sum)
// Goal is add top and left (we can traverse down and right)

int uniquePaths(int m, int n) {

    // Initialisation
    int** ways=malloc(m*sizeof(int*));
    for(int i=0;i<m;i++)
        ways[i]=malloc(n*sizeof(int));
    ways[0][0]=1;

    // First row
    for(int i=1;i<n;i++)
        ways[0][i]=ways[0][i-1];

    // First Column
    for(int i=1;i<m;i++)
        ways[i][0]=ways[i-1][0];

    for(int i=1;i<m;i++)
        for(int j=1;j<n;j++)
            ways[i][j]=ways[i-1][j]+ways[i][j-1];

    return ways[m-1][n-1];
}