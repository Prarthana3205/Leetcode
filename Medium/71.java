// 71. Simplify Path
// https://leetcode.com/problems/simplify-path/description/

import java.util.Stack;
class Solution {
    public String simplifyPath(String path) {
        String[] parts=path.split("/");
        Stack<String> stack=new Stack<>();

        for(String part:parts)
        {
            if(part.equals("") || part.equals("."))
                continue;
            else if(part.equals("..")) // go back to parent directory therefore we pop the last directory from stack
            {
                if(!stack.isEmpty())
                    stack.pop();
            } 
            else
                stack.push(part);
        }
        String result="";
        while(!stack.isEmpty())
            result="/"+stack.pop()+result;
        return result.equals("")?"/":result;
    } 
}