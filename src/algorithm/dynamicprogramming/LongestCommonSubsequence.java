package algorithm.dynamicprogramming;

import java.util.Arrays;
import java.util.stream.IntStream;

public class LongestCommonSubsequence {

    public static void main(String[] args) {
        String a = "ABACBDAB";
        String b = "BDCABA";

        System.out.println(findLCS(a, b));
    }

    private static int findLCS(String a, String b) {
        int[][] r = new int[b.length() + 1][a.length() + 1];

        // fill the first row and column with 0s as 1st position denotes case where one or both of
        // the strings are empty
        Arrays.stream(r[0]).forEach(e -> e = 0);
        IntStream.of(b.length() + 1).forEach( i -> r[i - 1][0] = 0);

        // from 2nd row and column compare the characters, if the characters match then LCS = r[i - 1][j - 1] + 1
        // else LCS = Max(r[i][j - 1], r[i - 1][j]), i.e maximum of the LCS we get by considering either of the 
        // characters
        for (int bi = 1; bi <= b.length(); bi++) {
            for (int ai = 1; ai <= a.length(); ai++) {
                if (a.charAt(ai - 1) == b.charAt(bi - 1)) {
                    r[bi][ai] = r[bi - 1][ai - 1] + 1;
                } else {
                    r[bi][ai] = Math.max(r[bi - 1][ai], r[bi][ai - 1]);
                }
            }
        }
        
        // the longest common subsequence will be in the the last position of the matrix, i.e. r[b.length()][a.length()]
        return r[b.length()][a.length()];
    }

}
