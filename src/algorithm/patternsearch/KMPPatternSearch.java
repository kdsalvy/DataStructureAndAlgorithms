package algorithm.patternsearch;

import java.util.Arrays;

/**
 * String of length n and pattern of length m<br/>
 * Time complexity of this algorithm is O(n + m)<br/>
 * Space complexity of this algorithm is O(m)<br/>
 * 
 * @author skedia
 *
 */
public class KMPPatternSearch {

    public static void main(String[] args) {
	String str = "dalsjhajhdkjshdkjahdkjshdjascbanmcbnmbxczcnbckhdskjhsd";
	String pattern = "jshd";

	KMPPatternSearch kmp = new KMPPatternSearch();
	// build a pattern array which will tell the length of prefix that is
	// also a suffix at a given point
	int[] prefixArray = kmp.buildPrefixArray(pattern);
	// find the given pattern in the given string by the help of prefix
	// array created in last step
	System.out.println(kmp.findPattern(str, pattern, prefixArray));
    }

    public boolean findPattern(String str, String pattern, int[] prefixArray) {
	int i = 0, j = 0;
	// if j becomes greater than pattern length that means the pattern is
	// found already
	while (i < str.length()) {
	    if (j >= pattern.length())
		break;
	    if (str.charAt(i) == pattern.charAt(j)) {
		i++;
		j++;
	    } else if (j == 0) {
		i++;
	    } else {
		j = prefixArray[j - 1];
	    }
	}
	if (j == pattern.length())
	    return true;
	else
	    return false;
    }

    public int[] buildPrefixArray(String pattern) {
	int i = 1;
	int j = 0;
	int k = 1;
	int n = pattern.length();
	int[] prefixArray = new int[n];
	prefixArray[0] = 0;

	while (i < n) {
	    if (pattern.charAt(i) == pattern.charAt(j)) {
		prefixArray[k++] = ++j;
		i++;
	    } else if (j == 0) {
		prefixArray[k++] = 0;
		i++;
	    } else {
		j = prefixArray[j - 1];
	    }
	}
	System.out.println(Arrays.toString(prefixArray));
	return prefixArray;
    }

}
