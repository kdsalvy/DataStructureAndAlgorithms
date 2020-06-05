package datastructure.array.program;

/**
 * Using Kadane's Algorithm
 * 
 * Add all numbers, whenever sum decreases below 0 initialize it to 0;
 * Always check the current sum with max sum, if max sum is less then update max sum 
 * 
 * @author saukedia1
 *
 */
public class MaxSumContiguousSubArray {

    public static void main(String[] args) {
        int[] arr = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        System.out.println(getMaxSumofContiguousSubArray(arr));
    }

    private static int getMaxSumofContiguousSubArray(int[] arr) {
        int currentSum = 0;
        int maxSum = 0;

        for (int i = 0; i < arr.length; i++) {
            currentSum += arr[i];
            if (currentSum < 0)
                currentSum = 0;
            if (currentSum > maxSum)
                maxSum = currentSum;
        }

        return maxSum;
    }

}
