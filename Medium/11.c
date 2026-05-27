/*  11. Container With Most Water
    https://leetcode.com/problems/container-with-most-water/
    Brute force approach would be to check every pair of lines and calculate the area.
    Approach: Use two pointers, one at the start and one at the end of the array.
    Calculate the area and move the pointer pointing to the shorter line inward.
*/

int maxArea(int* height, int heightSize) {
    // //Brute Force Approach (Time lImit Exceeded)
    // int max=INT_MIN,area;
    // for(int i=0;i<heightSize;i++)
    // {
    //     for(int j=0;j<heightSize;j++)
    //     {
    //         if(i==j || height[i]>height[j]) continue;
    //         area=height[i]*(abs(i-j));
    //         max=(max>area)?max:area;
    //     }
    // }
    // return max;   

    // 2 pointer approach
    int left=0,right=heightSize-1,h;
    int max=INT_MIN,area;
    while(left<right)
    {
        h=(height[left]>height[right])?height[right]:height[left];
        area=h*(abs(left-right));
        (height[left]>height[right])?right--:left++;
        max=(max>area)?max:area;
    }
    return max;
}