package algorithm.dynamicprogramming;

import java.util.Arrays;
import java.util.stream.IntStream;

public class LongestCommonSubstring {

    public static void main(String[] args) {
        String a = "REDSEA";
        String b = "DEADSEA";

        System.out.println(findLCS(a, b));
    }

    private static int findLCS(String a, String b) {
        int[][] r = new int[b.length() + 1][a.length() + 1];

        // fill the first row and column with 0s as 1st position denotes case where one or both of
        // the strings are empty
        Arrays.stream(r[0])
            .forEach(e -> e = 0);
        IntStream.of(b.length() + 1)
            .forEach(i -> r[i - 1][0] = 0);
        
        // compare each char of first string with each charter of second string. If there is a match at
        // index i,j then take the longest string length at i - 1, j - 1 and add 1 to it, else assign
        // the current length as 0
        for (int i = 1; i <= b.length(); i++) {
            for (int j = 1; j <= a.length(); j++) {
                if (a.charAt(j - 1) == b.charAt(i - 1)) {
                    r[i][j] = r[i - 1][j - 1] + 1;
                } else {
                    r[i][j] = 0;
                }
            }
        }

        return r[b.length()][a.length()];
    }

}
