// 121. Best Time to Buy and Sell stocks
// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

class Solution {
    public int maxProfit(int[] prices) {
        int min=Integer.MAX_VALUE;
        int profit,maxp=0;

        for(int price:prices) // Aim is to find the maximum difference
        {
            if(min>price)
                min=price;
            else
            {
                profit=price-min;
                if(maxp<profit)
                    maxp=profit;
            }
        }
        return maxp;
    }
}