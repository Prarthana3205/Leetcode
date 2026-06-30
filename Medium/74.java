// 74. Search a 2D Matrix
// https://leetcode.com/problems/search-a-2d-matrix

// treating the matrix as 1 single array

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row=matrix.length;
        int col=matrix[0].length;
        int left=0;
        int right=row*col-1;

        while(left<=right)
        {
            int mid=left+(right-left)/2; // index found 

            //need to map 2d to 1d array
            int r=mid/col; // Total rows the elements fit will give the rows
            int c=mid%col; // and the remainder will give the number of columns
            int val=matrix[r][c];
            if(val==target) return true;
            else if(val<target) left=mid+1;
            else right=mid-1;
        }
        return false;
    }
}