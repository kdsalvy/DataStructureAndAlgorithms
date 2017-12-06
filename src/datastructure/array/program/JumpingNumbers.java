package datastructure.array.program;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a positive number x, print all Jumping Numbers smaller than or equal to
 * x. A number is called as a Jumping Number if all adjacent digits in it differ
 * by 1. The difference between ‘9’ and ‘0’ is not considered as 1. All single
 * digit numbers are considered as Jumping Numbers. For example 7, 8987 and
 * 4343456 are Jumping numbers but 796 and 89098 are not.
 * 
 * @author skedia
 *
 */
public class JumpingNumbers {

    public static void main(String[] args) {
	int number = 2000;
	System.out.print(0 + " ");

	// 0 .. 9 are implicit jumping number
	for (int i = 1; i <= 9 && i <= number; i++) {
	    findJumpingNumbers(i, number);
	}

    }

    public static void findJumpingNumbers(int n, int number) {
	// create a queue
	Queue<Integer> q = new LinkedList<>();
	// push the current number
	q.add(n);

	while (!q.isEmpty()) {
	    n = q.peek();
	    q.poll();
	    if (n <= number) {
		System.out.print(n + " ");
		int lDigit = n % 10;
		if (lDigit == 0)
		    q.add((n * 10) + (lDigit + 1));
		else if (lDigit == 9)
		    q.add((n * 10) + (lDigit - 1));
		else {
		    q.add((n * 10) + (lDigit - 1));
		    q.add((n * 10) + (lDigit + 1));
		}
	    }

	}
	// check if on subtracting 1 it is greater than or equals 0
	// check on
    }

}
