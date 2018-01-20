package algorithm.backtracking;

import java.util.HashMap;
import java.util.Map;

/**
 * https://www.youtube.com/watch?v=xTNFs5KRV_g&index=3&list=PLrmLmBdmIlpslxZUHHWmfOzNn6cA7jvyh
 */
public class StringCombinationOrSubsets {

    public static String output = "";

    public static void main(String[] args) {
	String s = "AABC";
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

	// call the recursive method generateStringSubsetCombinations
	System.out.println(output);
	generateStringSubsetCombinations(uniqueCharString, 0, cMap);
    }

    public static void generateStringSubsetCombinations(String s, int x, Map<Character, Integer> cMap) {
	// find the next Char from index x to end whose count is not 0 if no
	// such char found return -1
	int index = findNextNonZeroCountChar(s, x, cMap);
	if (index == -1)
	    return;
	// append the char to the output String
	output += s.charAt(index);
	// print the String
	System.out.println(output);
	// call the method recursively replacing start index with the index of
	// first non zero count char
	generateStringSubsetCombinations(s, index, cMap);
	// backtrack by again increasing the count and output string to its
	// previous value
	cMap.put(s.charAt(index), cMap.get(s.charAt(index)) + 1);
	output = output.substring(0, output.length() - 1);
	// call the method recursively replacing start index with the next index
	generateStringSubsetCombinations(s, index + 1, cMap);
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
    private static int findNextNonZeroCountChar(String s, int x, Map<Character, Integer> cMap) {
	int index = -1;
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
