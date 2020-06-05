package algorithm.dynamicprogramming;

/**
 * https://www.geeksforgeeks.org/ugly-numbers/
 * 
 * @author saukedia1
 *
 */
public class UglyNumbers {

    public static void main(String[] args) {
        System.out.println(getNthUglyNumber(3));
    }

    public static int getNthUglyNumber(int n) {
        if (n == 0 || n == 1)
            return n;
        
        return Math.min(getNthUglyNumber(n - 1) * 2, Math.min(getNthUglyNumber(n - 1) * 3, getNthUglyNumber(n - 1) * 5));
    }

}
