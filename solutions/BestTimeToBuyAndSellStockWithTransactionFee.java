package solutions;

/**
 * LEETCODE: Best Time to Buy and Sell Stock with Transaction Fee (714) [MEDIUM]
 * 
 * cash -> max profit if we don't hold the stock at the end of day i
 * hold -> max profit if we hold the stock at the end of day i
 * 
 * cash calculation:
 * 1. if we didnt previously hold the stock -> cash
 * 2. if we held the stock and sold -> hold + prices[i] - fee
 * 
 * hold calculation 
 * 1. if we don't sell the stock -> hold
 * 2. if we didn't previously own but we buy -> cash - prices[i] 
 * 3. if we own, sell and then buy again -> (hold + prices[i] - fee) - prices[i] = cash - prices[i]
 */
public class BestTimeToBuyAndSellStockWithTransactionFee {
	public int maxProfit(int[] prices, int fee) {
    int cash = 0; // max profit at the end of day 0 if we don't own the stock
    int hold = -prices[0]; // max profit at the end of day 0 if we own the stock
    
    for(int i = 1; i < prices.length; i++) {
      cash = Math.max(cash, hold + prices[i] - fee); // max profit at the end of day i if we dont own the stock
      hold = Math.max(hold, cash - prices[i]); // max profit at the end of day i if we own the stock
    }
    
    return cash;
  }
}
