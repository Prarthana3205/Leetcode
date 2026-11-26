// 223. Rectangle Area
// https://leetcode.com/problems/rectangle-area/description/

// draw to understand how to find left,right,top,bottom boundaries of overlapping area
class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int area1=(ax2-ax1)*(ay2-ay1); // width*height;
        int area2=(bx2-bx1)*(by2-by1);
        int left=Math.max(bx1,ax1); // finding the left boundary of overlapping area
        int right=Math.min(ax2,bx2); // right boundary
        int width=Math.max(0,right-left); // if right-left is negative then there is no overlapping area 
        int top=Math.min(by2,ay2);
        int bottom=Math.max(by1,ay1);
        int height=Math.max(0,top-bottom);

        return area1+area2-(width*height);
    }
}