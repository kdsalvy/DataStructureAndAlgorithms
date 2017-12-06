package algorithm.dynamicprogramming;

/**
 * The following is a description of the instance of this famous puzzle
 * involving n=2 eggs and a building with k=36 floors.<br/>
 * <br/>
 * Suppose that we wish to know which stories in a 36-story building are safe to
 * drop eggs from, and which will cause the eggs to break on landing. We make a
 * few assumptions:<br/>
 * <br/>
 * …..An egg that survives a fall can be used again.<br/>
 * …..A broken egg must be discarded.<br/>
 * …..The effect of a fall is the same for all eggs.<br/>
 * …..If an egg breaks when dropped, then it would break if dropped from a
 * higher floor.<br/>
 * …..If an egg survives a fall then it would survive a shorter fall.<br/>
 * …..It is not ruled out that the first-floor windows break eggs, nor is it
 * ruled out that the 36th-floor do not cause an egg to break.<br/>
 * <br/>
 * If only one egg is available and we wish to be sure of obtaining the right
 * result, the experiment can be carried out in only one way. Drop the egg from
 * the first-floor window; if it survives, drop it from the second floor window.
 * Continue upward until it breaks. In the worst case, this method may require
 * 36 droppings. Suppose 2 eggs are available. What is the least number of
 * egg-droppings that is guaranteed to work in all cases?<br/>
 * The problem is not actually to find the critical floor, but merely to decide
 * floors from which eggs should be dropped so that total number of trials are
 * minimized.<br/>
 * 
 * @author skedia
 *
 */
public class EggBreakProblem {

    public static void main(String[] args) {
	int eggs = 2;
	int floors = 10;

	System.out.println(minEggDrops(eggs, floors));
    }

    private static int minEggDrops(int eggs, int floors) {
	// if there are no floors then no trials are required or if there is 1
	// floor then only one trial is required. If there is 1 egg and k floors
	// then k trials are required.
	if (floors == 0 || floors == 1 || eggs == 1)
	    return floors;

	int res = Integer.MAX_VALUE, temp = 0;
	for (int i = 1; i <= floors; i++) {
	    temp = 1 + Math.max(minEggDrops(eggs - 1, i - 1), minEggDrops(eggs, floors - i));
	    res = Math.min(res, temp);
	}
	return res;
    }

}
