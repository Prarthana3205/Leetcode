// 54. Spiral Matrix
// https://leetcode.com/problems/spiral-matrix/

/*
Mistakes made
1. Didn't think about 4 boundaries
2. Forgot that the conditions must be included even inside the while loop
*/

int* spiralOrder(int** matrix, int matrixSize, int* matrixColSize, int* returnSize) {
    int left=0;
    int top=0;
    int right=matrixColSize[0];
    int down=matrixSize;
    int ind=0;
    int* final=malloc((right*down)*sizeof(int));
    right--;down--;
    
    while(left<=right && top<=down)
    {
        // left to right
        for(int i=left;i<=right;i++)
            final[ind++]=matrix[top][i];
        top++;

        // top to bottom
        for(int i=top;i<=down;i++)
            final[ind++]=matrix[i][right];
        right--;

        // right to left
        if(top<=down) // must implement this condition
        {
            for(int i=right;i>=left;i--)
            final[ind++]=matrix[down][i];
            down--;
        }

        // bottom up
        if(left<=right)
        {
            for(int i=down;i>=top;i--)
            final[ind++]=matrix[i][left];
            left++;
        }
    }
    *returnSize=ind;
    return final;
}