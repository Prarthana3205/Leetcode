// 956. Tallest Billboard
// https://leetcode.com/problems/tallest-billboard/


import java.util.HashMap;
class Solution {
    public int tallestBillboard(int[] rods) {
        HashMap<Integer,Integer> dp=new HashMap<>();
        dp.put(0,0); //initialization
        for(int rod:rods)
        {
            HashMap<Integer,Integer> next=new HashMap<>(dp); // necessary to skip some rods if needed
            for(int diff:dp.keySet())
            {
                int height=dp.get(diff);

                // Add in shorter side
                int newdiff=Math.abs(rod-diff);
                int newHeight=height+Math.min(rod,diff);
                next.put(newdiff,
                Math.max(newHeight,next.getOrDefault(newdiff,0)));

                // Add in longer side
                newdiff=diff+rod;
                next.put(newdiff,
                Math.max(height,next.getOrDefault(newdiff,0)));
            }
            dp=next;
        }
        return dp.getOrDefault(0,0);
    }
}