// 1502. Can Make Arithmetic Progression From Sequence
// https://leetcode.com/problems/can-make-arithmetic-progression-from-sequence/description

// This approach time complexity is O(nlogn)
import java.util.*;
class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        for(int i=1;i<arr.length-1;i++)
        {
            if(arr[i]-arr[i-1]!=arr[i+1]-arr[i])
                return false;
        }
        return true;
    }
}