package algorithm.dynamicprogramming;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * https://www.hackerrank.com/challenges/coin-change/problem
 * 
 * @author saukedia1
 *
 */
public class CoinChangeProblem {

    public static void main(String[] args) {
        List<Long> denominations = Arrays.asList(1L, 2L, 3L);
        int n = 4;

        System.out.println(getWays(n, denominations));
    }

    public static long getWays(int n, List<Long> c) {
        Map<Integer, Long> amountWaysMap = new HashMap<>();
        if (n == 0 || c == null || c.size() == 0)
            return 0L;

        Collections.sort(c);
        Long[] cArr = new Long[c.size()];
        cArr = c.toArray(cArr);
        // already checked if list size is 0, so at least 1 value will be there
        return recurseForAmount(n, 0, amountWaysMap, cArr);
    }

    public static long recurseForAmount(int n, int index, Map<Integer, Long> store, Long[] arr) {
        Long val = 0L;
        if (arrayContainsValue(arr, arr[index])) // amount is achieved using given denominations, thus return 1
            val += 1L;
        if (arr[index] > n || index == arr.length - 1)
            return 0;
        if (store.containsKey(n))
            return store.get(n);

        val += recurseForAmount((int) (n - arr[index]), index + 1, store, arr) + recurseForAmount(n, index + 1, store, arr);

        // put in store if the value is
        store.put(n, val);
        return val;
    }

    public static boolean arrayContainsValue(Long[] arr, Long value) {
        return Arrays.binarySearch(arr, value) > 0;
    }

    // using DP tabulation
    public static long getWaysUsingDP(int n, List<Long> c) {
        if(n == 0 || c == null || c.isEmpty())
            return 0;
        
        // store the no of ways to reach an amount using the given denominations
        int[][] cAMatrix = new int[n + 1][c.size() + 1];

        // if amount is 0, number of denominations available will not matter
        Arrays.fill(cAMatrix[0], 0);
        // if number of denominations if 0, amount will not matter
        IntStream.of(0, n).forEach(amount -> cAMatrix[amount][0] = 0);

        // find the number of coins required to reach each amount from 1...n
        // when the given number of denominations are from 1...c.size()
        for(int amount = 1; amount <= n; amount++) {
            int denomCount = 1;
            for(Long coinVal: c){
                if(coinVal > amount) {
                    cAMatrix[amount][denomCount] = Math.max(cAMatrix[amount][denomCount - 1], cAMatrix[amount - 1][denomCount]);
                } else {
//                    cAMatrix[amount][denomCount] = Math.max(cAMatrix[amount][denomCount - 1], cAMatrix[amount - 1][denomCount]) 
                }
                denomCount++;
            }
        }

        return 0L;

    }

}
