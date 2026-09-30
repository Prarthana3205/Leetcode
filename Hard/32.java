// 32. Longest Valid Parentheses
// https://leetcode.com/problems/longest-valid-parentheses/description/

import java.util.Stack;
class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack=new Stack<>();
        stack.push(-1); // fake boundary   
        int max=0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='(')
                stack.push(i); // replaces last boundary with current index
            else
            {
                stack.pop();
                if(stack.isEmpty())
                    stack.push(i);
                else
                    max=Math.max(max,i-stack.peek());
            }
        }  
        return max;  
    }
}

/* 
// TLE (221/235 test cases passed)
class Solution {
    boolean validparenthesis(String str)
    {
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<str.length();i++)
        {
            if(str.charAt(i)=='{' || str.charAt(i)=='[' || str.charAt(i)=='(')
                stack.push(str.charAt(i));
            else
            {
                if(stack.isEmpty()) 
                    return false;

                if((stack.peek()=='{' && str.charAt(i)=='}')||
                (stack.peek()=='(' && str.charAt(i)==')')||
                (stack.peek()=='[' && str.charAt(i)==']'))
                    stack.pop();
                else 
                    return false;
            }
        }
        return stack.isEmpty();
    }
    public int longestValidParentheses(String s) {
        int n=s.length();
        if(n==0)
            return 0;
        int len,max=0;
        for(int i=0;i<n;i++)
        {
            if(s.charAt(i)==')')
                continue;
            for(int j=i;j<=n;j++)
            {
                String str=s.substring(i,j);
                len=str.length();
                if(max<len && validparenthesis(str))
                    max=Math.max(len,max);  
            }
        }
        return max;        
    }
}
*/