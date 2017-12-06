package datastructure.array.program;

/**
 * You are given an array A containing 2*N+2 positive numbers, out of which N
 * numbers are repeated exactly once and the other two numbers occur exactly
 * once and are distinct. You need to find the other two numbers and print them
 * in ascending order.<br/>
 * 
 * 1. The first way to do it is by sorting the array and then traversing through
 * it looking at the next number<br/>
 * 2. Second way to do it is by using bit manipulation where on doing XOR on the
 * complete array same number's XOR will become 0 and we will be left with only
 * the xor of distinct numbers. The we need to get the rightmost set bit of the
 * number by doing AND of the XOR result and negation of XOR - 1. Once that is
 * done we can divide the array in two parts based on the rightmost set bit and
 * each part will give a number that will be the result<br/>
 * 
 * @author skedia
 *
 */
public class FindNumbers {

    public static void main(String[] args) {
	int[] arr = { 2, 4, 7, 9, 2, 4 };

	// xor all the elements of the array, the numbers which are present
	// twice will become 0 and only the xor of two distinct elements will be
	// present in the variable xor
	int xor = 0;
	for (int i : arr)
	    xor ^= i;

	// get the right most set bit of the resultant number
	int rBitNo = xor & ~(xor - 1);
	System.out.println(rBitNo);

	// based on the right most set bit divide the numbers into two parts and
	// thus get the number required
	int x = 0;
	int y = 0;
	for (int i : arr) {
	    if ((i & rBitNo) > 0)
		x = x ^ i;
	    else
		y = y ^ i;
	}

	System.out.println(x + " " + y + "\n");

    }

}
