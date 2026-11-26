// 636. Exclusive Time of Functions
// https://leetcode.com/problems/exclusive-time-of-functions/

class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];
        Stack<Integer> stk = new Stack<>();
        int prev = 0;

        for (String log : logs)
        {
            String[] str = log.split(":");
            int id = Integer.parseInt(str[0]);
            String type = str[1];
            int time = Integer.parseInt(str[2]);

            if (type.equals("start"))
            {
                if (!stk.isEmpty())
                    res[stk.peek()]+=time-prev; 
                // the time bw the prev funct & new funct is added as 
                // that will also be the execution time of the prev function
                    
                stk.push(id);
                prev=time;
            }
            else
            {
                res[id]+=time-prev+1; // Note we add 1 as it is inclusive of the end time
                prev=time+1; // we again add 1 as the next function will start after this time
                stk.pop();
            }
        }

        return res;
    }
}