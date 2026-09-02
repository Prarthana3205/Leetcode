// 73. Set Matrix Zeroes
// https://leetcode.com/problems/set-matrix-zeroes/

/*
// Extra Space Complexity O(mn)
void setZeroes(int** matrix, int matrixSize, int* matrixColSize) {
    int m=matrixSize;
    int n=matrixColSize[0];
    int** find=malloc((m*n)*sizeof(int*));

    for(int i=0;i<m;i++)
    {
        find[i]=calloc(n,sizeof(int));
        for(int j=0;j<n;j++)
        {
            if (matrix[i][j]==0)
                find[i][j]=1;
        }
    }

    for(int i=0;i<m;i++)
    {
        for(int j=0;j<n;j++)
        {
            if(find[i][j])
            {
                for(int a=0;a<n;a++)
                    matrix[i][a]=0;
                for(int b=0;b<m;b++)
                    matrix[b][j]=0;
            }
        }
    }  
}
*/

// Space complexity O(1)

void setZeroes(int** matrix, int matrixSize, int* matrixColSize) {
    int m=matrixSize;
    int n=matrixColSize[0];
    int rowc=0,colc=0;

    for(int i=0;i<n;i++)
        if(matrix[0][i]==0)
            rowc=1;

    for(int i=0;i<m;i++)
        if(matrix[i][0]==0)
            colc=1;

    for(int i=1;i<m;i++)
    {
        for(int j=1;j<n;j++)
        {
            if(matrix[i][j]==0)
            {
                matrix[0][j]=0;
                matrix[i][0]=0;
            }
        }
    }

    // rows to 0's
    for(int i=1;i<m;i++)
    {
        if(matrix[i][0]==0)
        {
            for(int j=1;j<n;j++)
                matrix[i][j]=0;
        }
    } 

    for(int i=1;i<n;i++)
    {
        if(matrix[0][i]==0)
        {
            for(int j=1;j<m;j++)
                matrix[j][i]=0;
        }
    }

    if(rowc)
    {
        for(int i=0;i<n;i++)
            matrix[0][i]=0;
    }

    if(colc)
    {
        for(int i=0;i<m;i++)
            matrix[i][0]=0;
    }
}

/*
// In java
class Solution {
    public void setZeroes(int[][] matrix) {
        int row=matrix.length;
        int col=matrix[0].length;
        int colf=0,rowf=0;

        for(int i=0;i<row;i++)
        {
            if(matrix[i][0]==0)
            {
                colf=1; // first column must be converted to 0
                break;
            }
        }

        for(int j=0;j<col;j++)
        {
            if(matrix[0][j]==0)
            {
                rowf=1; // first row must be converted to 0
                break;
            }
        }

        for(int i=1;i<row;i++)
        {
            for(int j=1;j<col;j++)
            {
                if(matrix[i][j]==0)
                    matrix[i][0]=matrix[0][j]=0; // marking the column and row that needs to converted to 0
            }
        }

        for(int i=1;i<row;i++)
        {
            if(matrix[i][0]==0)
            {
                for(int j=1;j<col;j++) // Convert the entire row to 0
                    matrix[i][j]=0;
            }
        }

        for(int j=1;j<col;j++)
        {
            if(matrix[0][j]==0)
            {
                for(int i=1;i<row;i++)
                    matrix[i][j]=0;
            }
        }

        if(rowf==1)
        {
            for(int j=0;j<col;j++)
                matrix[0][j]=0;
        }

        if(colf==1)
        {
            for(int i=0;i<row;i++)
                matrix[i][0]=0;
        }   
    }
}
*/
/*
| Feature               | First Method     | Optimized                     |
| --------------------- | ---------------- | ----------------------------- |
| Extra memory          | O(mn)            | O(1)                          |
| Time                  | O(mn(m+n)) worst | O(mn)                         |
| Memory usage          | large            | minimal                       |
| Interview expectation | basic solution   | expected optimal solution     |
*/

