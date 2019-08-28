package algorithm.dynamicprogramming;

public class LongestCommonSubsequence {

    public static void main(String[] args) {
        String a = "ABACBDAB";
        String b = "BDCABA";

        System.out.println(findLCS(a, b));
    }

    private static int findLCS(String a, String b) {
        int[][] r = new int[b.length() + 1][a.length() + 1];

        r[0][0] = 0;
        r[0][1] = 0;
        r[1][0] = 0;

        for (int bi = 1; bi <= b.length(); bi++) {
            for (int ai = 1; ai <= a.length(); ai++) {
                if (a.charAt(ai - 1) == b.charAt(bi - 1)) {
                    r[bi][ai] = r[bi - 1][ai - 1] + 1;
                } else {
                    r[bi][ai] = Math.max(r[bi - 1][ai], r[bi][ai - 1]);
                }
            }
        }
        return r[b.length()][a.length()];
    }

}
