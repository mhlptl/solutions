package solutions;

/**
 * LEETCODE: Best Time to Buy and Sell Stock II (122) [EASY]
 * 
 * find valley -> iterate until prices[i] < prices[i+1]
 * why? the bottom of the valley will be the lowest stock price before we see the price rise
 * find peak -> interate until prices[i] > prices[i+1]
 * why? the peak will the highest stock price before we see a dip in price
 * add (peak-valley) to maxProfit
 * keep doing until i is less than n-1
 */
public class BestTimeToBuyAndSellStockII {
	public int maxProfit(int[] prices) {
    int maxProfit = 0;
    int n = prices.length;
    int i = 0;
    int peak = prices[0];
    int valley = prices[0];
    while(i < n-1) {
      while(i+1 < n && prices[i] >= prices[i+1]) {
        i++;
      }
      valley = prices[i];
      while(i+1 < n && prices[i] <= prices[i+1]) {
        i++;
      }
      peak = prices[i];
      maxProfit += (peak-valley);
    }
    
    return maxProfit;
  }
}
