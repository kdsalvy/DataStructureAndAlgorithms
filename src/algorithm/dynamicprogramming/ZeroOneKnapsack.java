package algorithm.dynamicprogramming;

import java.util.Arrays;

/**
 * Given two arrays w[1...n] and v[1...n] where w[i] is weight and v[i] is value of the ith element.
 * Find how many elements can be put into a knapsack where the sum of weight of elements should not
 * exceed W and their value should be max.
 * 
 * <br/><br/>
 * <b>
 * Formula: ks[i][j] = c > w[i] && (r[i - 1][c - w[i - 1]] + v[i - 1] > r[i - 1][c])?
 *  r[i - 1][c - w[i - 1]] + v[i - 1] : r[i - 1][c]
 * <b/>
 * 
 * @author saukedia1
 *
 */
public class ZeroOneKnapsack {

    public static void main(String[] args) {
        int[] w = { 2, 5, 8 };
        int[] v = { 10, 12, 21 };
        int W = 8;

        System.out.println(maxKnapsackValue(w, v, W, 3));
    }

    private static int maxKnapsackValue(int[] w, int[] v, int W, int n) {
        int[][] r = new int[n + 1][W + 1];

        r[0][0] = 0;
        r[1][0] = 0;
        r[0][1] = 0;

        // iterate from 1 -> given capacity for each value
        // check capacity of current weight is less than equal to capacity and value of including it is
        // greater than value of excluding it.
        for (int i = 1; i <= v.length; i++) {
            for (int c = 1; c <= W; c++) {
                if (c >= w[i - 1] && (r[i - 1][c - w[i - 1]] + v[i - 1] > r[i - 1][c])) {
                    r[i][c] = r[i - 1][c - w[i - 1]] + v[i - 1];
                } else {
                    r[i][c] = r[i - 1][c];
                }
                System.out.println(Arrays.deepToString(r));
            }
        }
        return r[n - 1][W - 1];
    }

}
