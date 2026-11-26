// 1475. Final Prices With a Special Discount in a Shop
// https://leetcode.com/problems/final-prices-with-a-special-discount-in-a-shop/

// Optimal Approach using a Monotonic Stack
class Solution {
    public int[] finalPrices(int[] prices) {
        Stack<Integer> stk=new Stack<>();
        int n=prices.length;
        for(int i=0;i<n;i++)
        {
            while(!stk.isEmpty() && prices[stk.peek()]>=prices[i])
            {
                    int ind=stk.pop();
                    prices[ind]-=prices[i];
            }
            stk.push(i);
        }
        return prices;
    }
}

/*
// Brute Force Approach
class Solution {
    public int[] finalPrices(int[] prices) {
        int n=prices.length;
        for(int i=0;i<n-1;i++) // last price will not have a discoount
        {
            for(int j=i+1;j<n;j++)
            {
                if(prices[j]<=prices[i])
                {
                    prices[i]-=prices[j];
                    break;
                }
            }
        }
        return prices;
}
}
*/