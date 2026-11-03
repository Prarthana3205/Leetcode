// 715. Range Module
// https://leetcode.com/problems/range-module/description/

// BRAINROTTTT Q

import java.util.*;
class RangeModule {

    TreeMap<Integer,Integer> ranges; //similar to HashMap but sorted by key 
    Map.Entry<Integer,Integer> entry;
    public RangeModule() {
        ranges=new TreeMap<>();
    }
    
    public void addRange(int left, int right) {
        entry=ranges.floorEntry(left);
        if(entry!=null && left<=entry.getValue())
        {
            left=entry.getKey();
            right=Math.max(right,entry.getValue());
            ranges.remove(entry.getKey());
        }

        entry=ranges.ceilingEntry(left);
        while(entry!=null && entry.getKey()<=right)
        {
            ranges.remove(entry.getKey());
            right=Math.max(right,entry.getValue());
            entry=ranges.ceilingEntry(left);
        }   
        ranges.put(left,right);        
    }
    
    public boolean queryRange(int left, int right) {
        entry=ranges.floorEntry(left); // max key lesser than or equal to left , therefore left will be included in the range found
        return entry!=null && entry.getValue()>=right;
        
    }
    
    public void removeRange(int left, int right) {
        int start,end;
        entry=ranges.floorEntry(left);
        if(entry!=null && entry.getValue()>left) 
        // to check if range overlaps the found entry
        {
            start=entry.getKey();
            end=entry.getValue();
            ranges.remove(start);

            // retain the front 
            if(start<left)
                ranges.put(start,left);
            
            // retain the end
            if(end>right)
            {
                ranges.put(right,end);
                return; // return because the left right range falls between the entry
            }
            // left right range is in the middle if both the if statements
        }

        // these statements are executed only if we have to remove ranges beyond  previous entry end
        entry=ranges.ceilingEntry(left);
        while(entry!=null && entry.getKey()<right)
        {
            start=entry.getKey();
            end=entry.getValue();

            ranges.remove(start);
            if(end>right)
                ranges.put(right,end);
            entry=ranges.ceilingEntry(left);
        }
    }
}

/**
 * Your RangeModule object will be instantiated and called as such:
 * RangeModule obj = new RangeModule();
 * obj.addRange(left,right);
 * boolean param_2 = obj.queryRange(left,right);
 * obj.removeRange(left,right);
 */