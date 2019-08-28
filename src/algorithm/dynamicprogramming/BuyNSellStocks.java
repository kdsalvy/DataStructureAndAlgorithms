package algorithm.dynamicprogramming;

/**
 * Given an array of stock prices where arr[i] denotes the stock price on ith day.
 * Find max profit you can make if you are allowed to do only one transaction in a day or do nothing.
 * 
 * <br/><br/>
 * <b>
 * Formula: 
 * </b>
 * 
 * @author saukedia1
 *
 */
public class BuyNSellStocks {

    public static void main(String[] args) {
        int[] prices = { 7, 1, 5, 4, 4 };
        System.out.println(computeMaxProfit(prices));
    }

    private static int computeMaxProfit(int[] prices) {
        int[] pMax = new int[prices.length];
        pMax[0] = 0;
        int minVal = Integer.MAX_VALUE;

        for (int i = 1; i < prices.length; i++) {
            minVal = Math.min(minVal, prices[i]);
            pMax[i] = Math.max(pMax[i - 1], prices[i] - minVal);
        }

        return pMax[prices.length - 1];
    }

}
