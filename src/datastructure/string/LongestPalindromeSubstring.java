package datastructure.string;

/**
 * Longest palindromic substring using manacher's algorithm </br>
 * </br>
 * <b>Manacher's algorithm</br>
 * </b> Suppose we found a substring using center expansion method then we can
 * find the length of palindromes for the mirror center's palindrome. we need to
 * keep three things in mind:
 * <ol>
 * <li>if length exceeds beyond left boundary then palindrome's length at right
 * part is - index of right boundary - index of palindrome's center.
 * <li>if length is same then right side's palindrome's length will be the same
 * as left side's palindrome
 * <li>if length exceeds beyond right boundary then palindrome's length at right
 * side is at least the length of left side. We can expand after that to check
 * if the palindrom's length is more or not.
 * </ol>
 * 
 * youtube link :
 * https://www.youtube.com/watch?v=nbTSfrEfo6M&list=PLamzFoFxwoNjPfxzaWqs7cZGsPYy0x_gI&index=4
 *
 * @author saukedia1
 *
 */
public class LongestPalindromeSubstring {

	public static void main(String[] args) {
		String src = "xyzaaaghfababjhgbbbb";
		System.out.println(getlongestPalindromeLength(src));
	}

	public static String getlongestPalindromeLength(String source) {
		char[] charArray = getModifiedCharArray(source);
		int[] palindromeLengthTracker = new int[charArray.length];
		int center = 0;
		int rightBoundary = 0;

		for (int currentPosition = 1; currentPosition < charArray.length - 1; currentPosition++) {
			// get the mirror location
			int mirr = 2 * center - currentPosition;

			// update the palindrome's length for current location from valid mirror
			// location as per manacher's algorithm the current location's palindrome length
			// will be at least equal to the mirror location
			if (currentPosition < rightBoundary) {
				palindromeLengthTracker[currentPosition] = Math.min(rightBoundary - currentPosition,
						palindromeLengthTracker[mirr]);
			}

			// expand to check to if the palindrome's length extends
			while (charArray[currentPosition + (palindromeLengthTracker[currentPosition] + 1)] 
					== charArray[currentPosition - (palindromeLengthTracker[currentPosition] + 1)]) {
				palindromeLengthTracker[currentPosition]++;
			}

			// update right boundary and center
			if ((currentPosition + palindromeLengthTracker[currentPosition]) > rightBoundary) {
				center = currentPosition;
				rightBoundary = currentPosition + palindromeLengthTracker[currentPosition];
			}

		}

		// take the longest palindrome from palindrome tracker
		int length = 0;
		for (int i = 0; i < palindromeLengthTracker.length; i++) {
			if (palindromeLengthTracker[i] > length) {
				length = palindromeLengthTracker[i];
				center = i;
			}
		}

		return source.substring((center - 1 - palindromeLengthTracker[center]) / 2,
				(center - 1 + palindromeLengthTracker[center]) / 2);
	}

	private static char[] getModifiedCharArray(String source) {
		char[] srcCharArray = source.toCharArray();
		char[] tgtCharArray = new char[(srcCharArray.length * 2) + 3];
		// set terminal characters
		tgtCharArray[0] = '$';
		tgtCharArray[tgtCharArray.length - 1] = '@';
		// set one additional symbol char at each index
		for (int i = 1, j = 0; i < tgtCharArray.length - 1; i++) {
			if (i % 2 == 0 && j < srcCharArray.length)
				tgtCharArray[i] = srcCharArray[j++];
			else
				tgtCharArray[i] = '#';
		}
		return tgtCharArray;
	}
}
