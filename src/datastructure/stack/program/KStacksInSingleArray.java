package datastructure.stack.program;

public class KStacksInSingleArray {
    static int free = 0;

    public static void main(String[] args) {
	KStacksInSingleArray stacks = new KStacksInSingleArray();
	// let n be 15 and k be 3
	int n = 15;
	int k = 3;
	int[] arr = new int[n];
	int[] top = new int[k];
	// when set it points to the prev element index and when not set it will
	// point to next available index
	int[] next = new int[n];

	for (int i = 0; i < k; i++) {
	    top[i] = -1;
	}

	for (int i = 0; i < n; i++) {
	    next[i] = i + 1;
	}
	next[n - 1] = -1;

	stacks.push(0, 1, arr, top, next);
	stacks.push(0, 2, arr, top, next);
	stacks.push(0, 3, arr, top, next);
	stacks.push(1, 2, arr, top, next);
	stacks.push(1, 3, arr, top, next);
	stacks.push(1, 4, arr, top, next);
	stacks.push(0, 4, arr, top, next);
	stacks.push(0, 5, arr, top, next);
	stacks.push(2, 3, arr, top, next);
	stacks.push(2, 4, arr, top, next);
	stacks.push(2, 5, arr, top, next);
	stacks.push(1, 5, arr, top, next);
	stacks.push(1, 6, arr, top, next);
	stacks.push(0, 6, arr, top, next);
	stacks.push(0, 1, arr, top, next);
	stacks.push(0, 2, arr, top, next);
	stacks.push(0, 3, arr, top, next);
	stacks.push(1, 2, arr, top, next);
	stacks.push(1, 3, arr, top, next);
	stacks.push(1, 4, arr, top, next);
	stacks.push(0, 4, arr, top, next);
	stacks.push(0, 5, arr, top, next);
	stacks.push(2, 3, arr, top, next);
	stacks.push(2, 4, arr, top, next);
	stacks.push(2, 5, arr, top, next);
	stacks.push(1, 5, arr, top, next);
	stacks.push(1, 6, arr, top, next);
	stacks.push(0, 6, arr, top, next);

	System.out.println(stacks.pop(0, arr, top, next));
	System.out.println(stacks.pop(0, arr, top, next));
	System.out.println(stacks.pop(0, arr, top, next));
	System.out.println(stacks.pop(1, arr, top, next));
	System.out.println(stacks.pop(1, arr, top, next));
	System.out.println(stacks.pop(2, arr, top, next));
	System.out.println(stacks.pop(0, arr, top, next));
	System.out.println(stacks.pop(0, arr, top, next));
	System.out.println(stacks.pop(0, arr, top, next));
	System.out.println(stacks.pop(1, arr, top, next));
	System.out.println(stacks.pop(1, arr, top, next));
	System.out.println(stacks.pop(2, arr, top, next));
	System.out.println(stacks.pop(0, arr, top, next));
	System.out.println(stacks.pop(0, arr, top, next));
	System.out.println(stacks.pop(0, arr, top, next));
	System.out.println(stacks.pop(1, arr, top, next));
	System.out.println(stacks.pop(1, arr, top, next));
	System.out.println(stacks.pop(2, arr, top, next));

    }

    public int pop(int stackIndex, int[] arr, int[] top, int[] next) {
	// find the top pointer
	int curTop = top[stackIndex];
	if (curTop == -1) {
	    System.out.printf("Stack %d is empty: ", stackIndex);
	    return -1;
	}
	// get the element
	int ele = arr[curTop];
	// point the top pointer to prev element
	top[stackIndex] = next[curTop];
	// set the pointer index to next free location
	next[curTop] = free;
	// set free = curTop
	free = curTop;

	return ele;
    }

    public void push(int stackIndex, int element, int[] arr, int[] top, int[] next) {

	if (isFull(free)) {
	    System.out.println("Stack is Full");
	    return;
	}
	// store current top value in temp
	int curTop = top[stackIndex];
	// add the element to free index
	arr[free] = element;
	// update the top of stack at given index to the free index
	top[stackIndex] = free;
	// Update index of free slot to index of next slot in free list
	int prevFree = free;
	free = next[free];
	// Point the next array index to prev top of stack
	next[prevFree] = curTop;
    }

    private boolean isFull(int free) {
	return free == -1;
    }
}
