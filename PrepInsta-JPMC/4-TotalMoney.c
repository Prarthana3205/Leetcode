/*
https://prepinsta.com/jp-morgan-coding-questions/

Problem Statement :

You woke up from sleep and found yourself in the 0th row and 0th column of a grid.
every other square in a grid has some amount of money kept there. If you are given the matrix with all the values left in the cells,
you have to find how many different ways are there to rich the r-1 th , c-1 th cell and the sum of all possible amount of money you will have each time if you bring all the money kept in places in the cell.
Note that, if you are in i,j th cell, either you can go i+1, j th cell or you can go i,j+1 cell. 
Again, the 0,0th grid and the n-1,m-1 th grid will have 0 value.

Input Format:
Two integers R and C meaning the number of rows and columns.
Next R lines C space separated integers denoting the total grid.

Output Format:

First Line denoting the distinct ways to rich.
Next line denotes the total money if you use all possible distinct ways (Given that if you take the money from a cell, the money is readded in the cell).

Sample Input:

3 3
0 2 3
1 3 2
1 1 0

Sample Output:

4
21

Explanation:
The all possible totals are:
0 -> 2 -> 3 -> 2 -> 0  Total = 7
0 -> 2 -> 3 -> 2 -> 0  Total = 7
0 -> 2 -> 3 -> 1 -> 0  Total = 6
0 -> 1 -> 3 -> 2 -> 0  Total = 6
0 -> 1 -> 3 -> 1 -> 0  Total = 5
0 -> 1 -> 1 -> 1 -> 0  Total = 3

There are 4 distinct ways and the total is 21
*/

// This program calculates all paths (NOT DISTINCT) refer .py 
#include <stdio.h>
#include <stdlib.h>

int main()
{
    int r,c;
    scanf("%d %d",&r,&c);

    int** grid=malloc(r*sizeof(int*));
    int** ways=malloc(r*sizeof(int*));
    int** sum=malloc(r*sizeof(int*));

    // Input
    for(int i=0;i<r;i++)
    {
        grid[i]=malloc(c*sizeof(int));
        ways[i]=malloc(c*sizeof(int));
        sum[i]=malloc(c*sizeof(int));

        for(int j=0;j<c;j++)
            scanf("%d",&grid[i][j]);
    }

    ways[0][0]=1;
    sum[0][0]=grid[0][0];

    for(int i=1;i<c;i++)
    {
        ways[0][i]=ways[0][i-1];
        sum[0][i]=sum[0][i-1]+(ways[0][i-1]*grid[0][i]);
    }

    for(int i=1;i<r;i++)
    {
        ways[i][0]=ways[i-1][0];
        sum[i][0]=sum[i-1][0]+(ways[i-1][0]*grid[i][0]);
    }

    for(int i=1;i<r;i++)
    {
        for(int j=1;j<c;j++)
        {
            ways[i][j]=ways[i-1][j]+ways[i][j-1];
            sum[i][j]=(sum[i-1][j]+(ways[i-1][j]*grid[i][j]))+(sum[i][j-1]+(ways[i][j-1]*grid[i][j]));
        }
    }

    printf("%d\n",ways[r-1][c-1]);
    printf("%d\n",sum[r-1][c-1]);

    return 0;
}
