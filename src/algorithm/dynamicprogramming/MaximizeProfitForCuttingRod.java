package algorithm.dynamicprogramming;

/**
 * Given a rod of length n and array P[i] for I = 1…..n, where P[i] is the price of rod of length i. 
 * Find the maximum revenue you can generate by cutting and selling the rod.
 * 
 * </br></br>
 * Formula = P[max] = Max(P[i] + R[n - i]) where i --> i to n and n --> 1 to length to find
 * 
 * @author saukedia1
 *
 */
public class MaximizeProfitForCuttingRod {

    public static void main(String[] args) {
        int rodLength = 5;
        int[] priceArray = { 1, 5, 8, 9, 10 };
        System.out.println(getMaximumProfit(rodLength, priceArray));
    }

    private static int getMaximumProfit(int rodLength, int[] priceArray) {
        int[] maxPriceArray = new int[rodLength + 1];
        maxPriceArray[0] = 0;
        for (int tempRodLength = 1; tempRodLength <= rodLength; tempRodLength++) {
            int maxPrice = -1;
            for (int cutLength = 1; cutLength <= tempRodLength; cutLength++) {
                maxPrice = Math.max(priceArray[cutLength - 1] + maxPriceArray[tempRodLength - cutLength], maxPrice);
            }
            maxPriceArray[tempRodLength] = maxPrice;
        }
        return maxPriceArray[priceArray.length];
    }
}
