package solutions;

/**
 * LEETCODE: Best Time to Buy and Sell Stock (121) [EASY]
 * 
 * set minPrice to element 0
 * start at element 1
 * if minPrice > current price, set minPrice to current price
 * if minPrice < current price, set maxProfit to the max of (prices[i]-minPrice) OR maxProfit
 */
public class BestTimeToBuyAndSellStock {
	public int maxProfit(int[] prices) {
    int maxProfit = 0;
    int minPrice = prices[0];
    
    for(int i = 1; i < prices.length; i++) {
      if(minPrice > prices[i]) {
        minPrice = prices[i];
      }
      if(minPrice < prices[i]) {
        maxProfit = Math.max(prices[i] - minPrice, maxProfit);
      }
    }
    
    return maxProfit;
  }
}
