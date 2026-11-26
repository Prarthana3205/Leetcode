// 150. Evaluate Reverse Polish Notation
// https://leetcode.com/problems/evaluate-reverse-polish-notation/

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> stk=new Stack<>();
        for(String token:tokens)
        {
            // We push only numbers to the stack 
            if(token.matches("-?\\d+")) // ? means optional , we include -? to match negative numbers, \\d+ means one or more digits
                stk.push(token);
            else
            {
                int num1=Integer.parseInt(stk.pop());
                int num2=Integer.parseInt(stk.pop());
                if(token.matches("\\+"))
                    stk.push(String.valueOf(num1+num2));
                else if(token.matches("-"))
                    stk.push(String.valueOf(num2-num1)); // Note the order of num2 num1 for subtraction and division 
                else if(token.equals("*"))
                    stk.push(String.valueOf(num1*num2));
                else
                    stk.push(String.valueOf(num2/num1));
            }
        }
        return Integer.parseInt(stk.pop());
    }
}