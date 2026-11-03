// 856. Score of Parentheses
// https://leetcode.com/problems/score-of-parentheses/description/

import java.util.Stack;
class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> stack=new Stack<>();
        int n=s.length();
        stack.push(0);
        for(int i=0;i<n;i++)
        {
            if(s.charAt(i)=='(')
                stack.push(0); // push a 0 to represent a new score for the number of parentheses inside the current pair of parentheses
            else
            {
                int inside=stack.pop(); // how many score inside the current pair of parentheses
                int score=(inside==0)?1:2*inside;
                stack.push(stack.pop()+score); // stack.pop() is the score outside the current pair of parentheses
            }
            
        } 
        return stack.pop(); 
    }
}

// Initial attempt
// class Solution {
//     public int scoreOfParentheses(String s) {
//         Stack<Character> stack=new Stack<>();
//         int n=s.length();
//         int count=0;
//         for(int i=0;i<n;i++)
//         {
//             if(s.charAt(i)=='(')
//                 stack.push(s.charAt(i));
//             else
//             {
//                 stack.pop();
//                 count++;
//             }
//         }  
//         return count;     
//     }
// }