package algorithm.backtracking;

import java.util.HashMap;
import java.util.Map;

/**
 * https://www.youtube.com/watch?v=nYFd7VHKyWQ&list=PLrmLmBdmIlpslxZUHHWmfOzNn6cA7jvyh&index=1
 * 
 * @author skedia
 *
 */
public class StringPermutation {

    public static String output = "";

    public static void main(String[] args) {
	String s = "saurabh";
	// create a map of characters and their count in string
	Map<Character, Integer> cMap = new HashMap<>();
	for (int i = 0; i < s.length(); i++) {
	    if (cMap.containsKey(s.charAt(i)))
		cMap.put(s.charAt(i), cMap.get(s.charAt(i)) + 1);
	    else
		cMap.put(s.charAt(i), 1);
	}

	// generate unique character String
	String uniqueCharString = "";
	for (Character key : cMap.keySet())
	    uniqueCharString += key;

	// call the recursive method generatePermutations
	generatePermutations(uniqueCharString, 0, cMap, true, s.length());
    }

    private static void generatePermutations(String s, int x, Map<Character, Integer> cMap, boolean newLevel,
	    int origLen) {
	// find the next Char from l to end whose count is not 0 if no
	// such char found return -1
	int index = findNextNonZeroCountChar(s, x, cMap, newLevel);
	if (index == -1) {
	    if (output.length() == origLen)
		System.out.println(output);
	    return;
	}
	output += s.charAt(index);
	// recurse for new level
	generatePermutations(s, index, cMap, true, origLen);
	// backtrack
	cMap.put(s.charAt(index), cMap.get(s.charAt(index)) + 1);
	output = output.substring(0, output.length() - 1);
	// recurse for char at same level
	generatePermutations(s, index + 1, cMap, false, origLen);
    }

    /**
     * Find the next non zero count char in given map from given start index
     * 
     * @param s:
     *            unique char String
     * @param x:
     *            start index
     * @param cMap:
     *            char map with occurrence count in source string
     * @return index if found else -1
     */
    private static int findNextNonZeroCountChar(String s, int x, Map<Character, Integer> cMap, boolean reset) {
	int index = -1;
	x = (reset) ? 0 : x;
	for (int i = x; i < s.length(); i++) {
	    if (cMap.get(s.charAt(i)) > 0) {
		index = i;
		cMap.put(s.charAt(i), cMap.get(s.charAt(i)) - 1);
		break;
	    }
	}
	return index;
    }

}
