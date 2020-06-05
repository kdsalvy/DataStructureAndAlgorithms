package algorithm.dynamicprogramming;

import java.util.Arrays;

/**
 * https://practice.geeksforgeeks.org/problems/find-optimum-operation/0
 * 
 * @author saukedia1
 *
 */
public class MinimumOperations {

    public static void main(String[] args) {
        int num = 8;
        int[] result = new int[num + 1];
        result[0] = 0;
        result[1] = 1;
        result[2] = 2;
        for (int j = 3; j <= num; j++) {
            result[j] = result[j / 2] + result[j % 2] + 1;
        }
        System.out.println(Arrays.toString(result));
        System.out.println(result[num]);
    }
}
