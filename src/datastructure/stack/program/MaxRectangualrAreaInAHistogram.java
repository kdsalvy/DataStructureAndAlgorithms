package datastructure.stack.program;

import java.util.Stack;

/**
 * Calculate the maximum area of a histogram. We are going to use a stack in
 * this which will store the index of the start of a rectangle inside the
 * histogram.<br/>
 * Push in the stack until the element is greater than or equal to the stack top
 * element<br/>
 * if current value is less then stack top then pop until it becomes smaller
 * than current element.<br/>
 * for each pop calculate area and out of them select the max area.<br/>
 * if stack is not empty then pop it, calculate area for each popped element and
 * select max area
 * 
 * @author skedia
 *
 */
public class MaxRectangualrAreaInAHistogram {

    public static void main(String[] args) {
        int[] histogram = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

        int maxArea = findArea(histogram);
        System.out.println(maxArea);
    }

    private static int findArea(int[] histogram) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        int maxArea = Integer.MIN_VALUE;
        while (i < histogram.length) {
            // push to stack if the stack is empty or the current histogram bar is bigger
            // than the current top
            if (stack.isEmpty() || histogram[i] > histogram[stack.peek()])
                stack.push(i++);
            // if the current histogram bar is smaller than current stack top then pop until
            // we get a smaller value on stack top or stack is empty. For each pop compute the area
            // compare with max Area and keep the max value
            else if (histogram[i] < histogram[stack.peek()]) {
                int tmpArea = computeArea(i, stack, histogram);
                maxArea = Math.max(maxArea, tmpArea);
            }
        }

        // empty the remaining values in stack and compute the area for each pop. Compare with
        // max area and keep the largest value
        while (!stack.isEmpty()) {
            int tmpArea = computeArea(i, stack, histogram);
            maxArea = Math.max(maxArea, tmpArea);
        }
        return maxArea;
    }

    public static int computeArea(int i, Stack<Integer> stack, int[] histogram) {
        int top = stack.pop();
        if (stack.isEmpty()) {
            // if stack is empty that means everything from top till i at lease have same height
            // as histogram[top]
            return histogram[top] * i;
        } else {
            // Since we are sure that the top to i is having at least the same height as histogram[top]
            // we can compute the area (i - top - 1) * histogram[top] as the stack top now contains the
            // index above which the height was same.
            return histogram[top] * (i - stack.peek() - 1);
        }
    }

}
