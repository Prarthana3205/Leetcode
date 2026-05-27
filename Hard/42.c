/*
42. Trapping rain water
https://leetcode.com/problems/trapping-rain-water/
*/
int trap(int* height, int heightSize) {
    // water = min(leftmax,rightmax)-currentheight
    int left=0,right=heightSize-1,leftmax=0,rightmax=0,water=0;
    while(left<right)
    {
        if(height[left]<height[right])
        {
            if(height[left]>=leftmax)
                leftmax=height[left];
            else
                water+=leftmax-height[left];
            left++;
        }
        else
        {
            if(height[right]>=rightmax)
                rightmax=height[right];
            else
                water+=rightmax-height[right];
            right--;
        }
    }
    return water;
}