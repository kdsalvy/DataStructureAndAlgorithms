package algorithm.dynamicprogramming;

/**
 * Problem statement: You can climb a staircase of n stairs using 1 or 2 stairs at a time.
 * Find number of ways you can climb the stairs to reach the top. 
 * (extend the problem statement by including option of taking 3 stairs at a time).
 * 
 * @author saukedia1
 *
 */
public class StairCaseProblem {

    public static void main(String[] args) {
        int totalNoOfStairs = 10;
        System.out.printf("No of ways to climb %d stairs using 1 or 2 stairs at a time ", totalNoOfStairs);
        System.out.println(solveForTwoOptions(totalNoOfStairs));
        System.out.printf("No of ways to climb %d stairs using 1, 2 or 3 stairs at a time ", totalNoOfStairs);
        System.out.println(solveForthreeOptions(totalNoOfStairs));
    }

    private static int solveForthreeOptions(int totalNoOfStairs) {
        int[] arr = new int[totalNoOfStairs + 1];
        arr[0] = 0;
        arr[1] = 1; // [(1)]
        arr[2] = 2; // [(1,1), (2)]
        arr[3] = 4; // [(1,1,1), (1,2), (2,1), (3)]

        // number of ways to reach nth stair if we are on stair n-1, n-2 or n-3 = arr[1] + arr[2] + arr[3], 
        // i.e, arr[n] = arr[n - 1] + arr[n - 2] + arr[n - 3];
        for (int i = 4; i <= totalNoOfStairs; i++) {
            arr[i] = arr[i - 1] + arr[i - 2] + arr[i - 3];
        }

        return arr[totalNoOfStairs];
    }

    private static int solveForTwoOptions(int totalNoOfStairs) {
        int[] arr = new int[totalNoOfStairs + 1];
        arr[0] = 0;
        arr[1] = 1; // [(1)]
        arr[2] = 2; // [(1,1), (2)]

        for (int i = 3; i <= totalNoOfStairs; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }

        return arr[totalNoOfStairs];
    }
}
