package Practice.SlidingWindow;
/**
 * LeetCode Problem 121: Best Time to Buy and Sell Stock
 * Intuition:
 * - Use a single pass to track the minimum price seen so far.
 * - Calculate potential profit at each price by subtracting the minimum price from the current price.
 * - Update the maximum profit whenever a higher potential profit is found.
 * Maintain minPrice = smallest price seen up to the current day. (This is the dynamic left of the window.)
    For each current price p (the right of the window):
    Potential profit = p - minPrice.
    Update maxProfit = max(maxProfit, potential profit).
    Update minPrice = min(minPrice, p) for future days.
    This is one pass (O(n)), constant extra space (O(1)).
 * Time Complexity: O(n)
 */
class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length < 2){ // no profit can be made if single day or empty
            return 0;
        }
        int minPrice = Integer.MAX_VALUE,maxProfit = 0;
        for( int p : prices){
            if(p < minPrice){
                minPrice = p;  // update minPrice if current price is lower
            }
           int profit = p - minPrice;
            maxProfit = maxProfit > profit ? maxProfit : profit;// update maxProfit if current profit is higher

        }
        return maxProfit;
    }
}
//**
//  */ LeetCode Problem 122: Best Time to Buy and Sell Stock 2
/**
 * Intuition:
 * - Iterate through the price array and sum up all positive differences between consecutive days.
 * - This approach captures all upward trends, allowing for multiple buy-sell transactions.
 * - Time Complexity: O(n)
 * -Implementation:
 * -Capture every increase in price from one day to the next as profit.
 * -This effectively simulates buying at the start of each upward trend and selling at the end.
 * -when dip then collect profit till then and start new transaction
 */

 class Solution {
    public int maxProfit(int[] prices) {
        int selldate = 0,buydate = 0,profit = 0;
        for(int i = 1;i < prices.length;i++){
            if(prices[i] >= prices[i-1]){
                //upstroke so catch the max profit by moving up
                selldate++;
            }else{
                //dip so collect max profit first
                profit += prices[selldate] - prices[buydate];
                buydate = selldate = i;
            }
        }
        //for last tip
        profit += prices[selldate] - prices[buydate];
        return profit;


    }
}