package algorithm.dynamicprogramming;

public class LongestCommonSubstring {

    public static void main(String[] args) {
        String a = "REDSEA";
        String b = "DEADSEA";

        System.out.println(findLCS(a, b));
    }

    private static int findLCS(String a, String b) {
        int[][] r = new int[b.length() + 1][a.length() + 1];
        r[0][0] = 0;
        r[0][1] = 0;
        r[1][0] = 0;

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
