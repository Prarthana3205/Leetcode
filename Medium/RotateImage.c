// 48. Rotate Image
// https://leetcode.com/problems/rotate-image/description/

void rotate(int** matrix, int matrixSize, int* matrixColSize) {
    // transpose
    for(int i=0;i<matrixSize;i++)
    {
        for(int j=i+1;j<matrixSize;j++)
        {
            int temp;
            temp=matrix[i][j];
            matrix[i][j]=matrix[j][i];
            matrix[j][i]=temp;
        }
    }
    
    // reverse
    for(int i=0;i<matrixSize;i++)
    {
        for(int j=0;j<matrixSize/2;j++)
        {
            int temp2;
            temp2=matrix[i][j];
            matrix[i][j]=matrix[i][matrixSize-j-1];
            matrix[i][matrixSize-j-1]=temp2;
        }
    }
}