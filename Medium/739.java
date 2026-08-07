// 739. Daily Temperatures
// https://leetcode.com/problems/daily-temperatures/

import java.util.Stack;

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack <Integer> stk=new Stack<>();
        int len=temperatures.length;
        int[] answer=new int[len];
        for(int i=0;i<len;i++)
        {
            while(!stk.isEmpty() && temperatures[stk.peek()]<temperatures[i])
            {
                int ind=stk.pop();
                answer[ind]=i-ind;
            }
            stk.push(i);
        }
        while(!stk.isEmpty())
            answer[stk.pop()]=0;
        return answer;
    }
}