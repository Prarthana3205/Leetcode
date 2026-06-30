// 122. Best time to buy and sell stocks II
// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii

class Solution {
    public int maxProfit(int[] prices) {

        // Unwanted peak and valley(min) findings
        // int profit=0,i=0;
        // int n=prices.length;

        // while(i<n-1)
        // {
        //     while(i<n-1 && prices[i]>=prices[i+1])
        //         i++;
        //     int min=prices[i];

        //     while(i<n-1 && prices[i]<=prices[i+1])
        //         i++;
        //     int peak=prices[i];

        //     profit+=peak-min;
        //     i++;
        // }
        // return profit;

        // Using telescoping sum
        int profit=0;
        for(int i=1;i<prices.length;i++)
        {
            if(prices[i]>prices[i-1])
                profit+=prices[i]-prices[i-1];
        }
        return profit;
    }
}