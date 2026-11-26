// 118. Pascals Triangle
// https://leetcode.com/problems/pascals-triangle/

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result=new ArrayList<>();
        
        for(int i=0;i<numRows;i++)
        {
            List<Integer> currentRow=new ArrayList<>();
            currentRow.add(1);
            if(i>0)
            {
                List<Integer> previous=result.get(i-1);
                for(int j=1;j<previous.size();j++)
                {
                    int sum=previous.get(j-1)+previous.get(j);
                    currentRow.add(sum);
                }
                currentRow.add(1);
            }
            result.add(currentRow);
        }
        return result;
    }
}