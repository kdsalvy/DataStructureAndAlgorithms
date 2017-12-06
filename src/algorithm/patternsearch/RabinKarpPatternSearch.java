package algorithm.patternsearch;

/**
 * Rabin Karp algorithm is a string pattern matching algorithm where we use hash
 * of the pattern and the hash of same length substring of the source. The catch
 * of this algorithm is that it doesn't calculate the hash of the substring each
 * time rather it just subtracts the hash value from the prev character's hash
 * and adds the new character's hash
 * 
 * @author skedia
 *
 */
public class RabinKarpPatternSearch {

    private static int P = 101;

    public static void main(String[] args) {
	RabinKarpPatternSearch rk = new RabinKarpPatternSearch();
	String str = "abcworrieddeabdworkfhsgeworyfsjdslkdsvavcgfds";
	String pattern = "saurabh";

	int pHash = rk.hash(pattern);
	int pLen = pattern.length();

	int prevH = 0;
	boolean isFound = false;
	for (int i = 0; i + pLen - 1 < str.length(); i++) {
	    int cHash = 0;
	    if (prevH == 0) {
		cHash = rk.hash(str.substring(i, i + pLen));
	    } else {
		cHash = rk.reHash(prevH, str.charAt(i - 1), str.charAt(i + pLen - 1), pLen);
	    }
	    if (cHash == pHash && rk.isEqual(str.substring(i, i + pLen), pattern)) {
		isFound = true;
		break;
	    }
	}

	System.out.println(isFound);

    }

    public boolean isEqual(String substring, String pattern) {
	for (int i = 0; i < substring.length(); i++) {
	    if (substring.charAt(i) != pattern.charAt(i))
		return false;
	}
	return true;
    }

    public int hash(String str) {
	int hash = 0;
	for (int i = 0; i < str.length(); i++)
	    hash += ((int) str.charAt(i)) * Math.pow(P, i);
	return hash;
    }

    public int reHash(int prevHash, char prevChar, char nextChar, int patternLength) {
	return (int) (((prevHash - (int) prevChar) / P) + ((int) nextChar * Math.pow(P, patternLength - 1)));
    }

}
