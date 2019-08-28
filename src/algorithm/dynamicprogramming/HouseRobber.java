package algorithm.dynamicprogramming;

/**
 * A robber wants to rob houses on a street but the security system is set such as, 
 * if two adjacent houses are robbed in the same night then it will alert the police.
 * Given an array of money available in each house, find the maximum amount that can 
 * be robbed without alerting the police
 * 
 * <br/><br/>
 * <b>Formula: rMax[i] = Max( rMax[i - i], money[i] + rMax[i - 2] )</b>
 * 
 * @author saukedia1
 *
 */
public class HouseRobber {

    public static void main(String[] args) {
        int[] money = { 1, 2, 3, 4, 5 };

        System.out.println(rob(money));
    }

    private static int rob(int[] money) {
        int[] rAmount = new int[money.length];
        rAmount[0] = money[0];
        rAmount[1] = Math.max(money[0], money[1]);
        for (int i = 2; i < money.length; i++) {
            // when the robber is at house #i then max robbery amount will be equal to that of i - 1 if he
            // excludes the house else if he includes then it will be equal to sum of max robbery amount
            // till i - 2 and amount in house i
            rAmount[i] = Math.max(rAmount[i - 1], money[i] + rAmount[i - 2]);
        }
        return rAmount[money.length - 1];
    }

}
