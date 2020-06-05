package algorithm.dynamicprogramming;

import java.util.Arrays;

/**
 * https://practice.geeksforgeeks.org/problems/shop-in-candy-store/0/?ref=self
 * 
 * @author saukedia1
 *
 */
public class ShopInCandyStore {

    public static void main(String[] args) {
        int categories = 4;
        int offerCount = 2;
        int[] priceArr = { 3, 2, 1, 4 };

        Arrays.sort(priceArr);
        System.out.println(recursiveApproachForMinAmount(categories, offerCount, priceArr, 0, priceArr.length));
        System.out.println(recursiveApproachForMaxAmount(categories, offerCount, priceArr, 0, priceArr.length));
        System.out.println(dynamicApproachForMinAmount(categories, offerCount, priceArr));

    }

    public static int recursiveApproachForMinAmount(int cat, int off, int[] arr, int low, int high) {
        if (cat <= 1 + off) {
            return arr[low];
        }

        return arr[low] + recursiveApproachForMinAmount(cat - (1 + off), off, arr, low + 1, high - off);
    }

    public static int recursiveApproachForMaxAmount(int cat, int off, int[] arr, int low, int high) {
        if (cat <= 1 + off) {
            return arr[high - 1];
        }

        return arr[high - 1] + recursiveApproachForMinAmount(cat - (1 + off), off, arr, low + off, high - 1);
    }

    public static int dynamicApproachForMinAmount(int cat, int off, int[] arr) {
        int[] result = new int[cat + 1];

        result[0] = 0;
        for (int i = 1; i < arr.length; i++) {
            if (i <= off + 1)
                result[i] = arr[0];
            else
                result[i] = arr[i - off - 1 - 1] + arr[i - 1];
        }
        System.out.println(Arrays.toString(result));
        return result[cat];
    }

}
