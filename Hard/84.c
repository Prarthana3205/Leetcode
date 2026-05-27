/*
84. Largest Rectangle in Histogram
https://leetcode.com/problems/largest-rectangle-in-histogram/
Approach: Use a stack to keep track of the indices of the histogram bars.
For each bar, calculate the area with the height of the bar at the top of the stack
and update the maximum area accordingly.
*/

// Time Limit Exceeded (89/99)
int largestRectangleArea(int* heights, int heightsSize) {
    int max=INT_MIN,area,width,l,r;
    for(int i=0;i<heightsSize;i++)
    {
        width=1;
        l=i-1;
        r=i+1;
        while(l>=0 && heights[l]>=heights[i])
        {
            l--;
            width++;
        }
        while(r<heightsSize && heights[r]>=heights[i])
        {
            r++;
            width++;
        }
        area=heights[i]*width;
        max=(max>area)?max:area;    
    }
    return max;    
}

// Stack Approach
int largestRectangleArea(int* heights, int heightsSize) {
    int* stack=malloc(heightsSize*sizeof(int));
    int top=-1,area,max=INT_MIN;
    for(int i=0;i<heightsSize;i++)
    {
        while(top!=-1 && heights[stack[top]]>heights[i])
        {
            int h=heights[stack[top--]];
            int w=(top==-1)?i:i-stack[top]-1;
            area=h*w;
            max=(max>area)?max:area;
        }
        stack[++top]=i;
    }
    while(top!=-1)
    {
        int h=heights[stack[top--]];
        int w=(top==-1)?heightsSize:heightsSize-stack[top]-1;
        area=h*w;
        max=(max>area)?max:area;
    }
    return max;
}