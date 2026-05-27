// 59. Spiral Matrix II
// https://leetcode.com/problems/spiral-matrix-ii/description/

// Idea exactly from SpiralMatrix.c
/*
Mistakes Made:
Got confused on how to allocate memory for returnColumnSizes
*/
int** generateMatrix(int n, int* returnSize, int** returnColumnSizes) {
    int** matrix=malloc(n*sizeof(int*));
    *returnColumnSizes=malloc(n*sizeof(int));

    for(int i=0;i<n;i++)
    {
        matrix[i]=(int*)malloc(n*sizeof(int));
        (*returnColumnSizes)[i]=n;
    }

    int left=0;
    int right=n-1;
    int top=0;
    int down=n-1;
    int ind=1;

    while(left<=right && top<=down)
    {
        // left to right
        for(int i=left;i<=right;i++)
            matrix[top][i]=ind++;
        top++;

        // top to bottom 
        for(int i=top;i<=down;i++)
            matrix[i][right]=ind++;
        right--;

        // right to left
        if(top<=down)
        {
            for(int i=right;i>=left;i--)
                matrix[down][i]=ind++;
            down--;
        }

        //bottom up
        if(left<=right)
        {
            for(int i=down;i>=top;i--)
                matrix[i][left]=ind++;
            left++;
        }
    }
    *returnSize=n;
    return matrix;
    
}