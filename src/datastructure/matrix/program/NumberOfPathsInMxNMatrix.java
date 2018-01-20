package datastructure.matrix.program;

public class NumberOfPathsInMxNMatrix {

    public int countPathsDP(int n, int m, int[][] result) {
	if (n == 1 || m == 1) {
	    return 1;
	}
	if (result[n - 1][m - 1] != 0)
	    return result[n - 1][m - 1];

	result[n - 1][m - 1] = countPathsDP(n - 1, m, result) + countPathsDP(n, m - 1, result);
	return result[n - 1][m - 1];
    }

    /**
     * Recursive method
     * 
     * @param n
     * @param m
     * @return
     */
    public int countPathsRecursive(int n, int m) {
	if (n == 1 || m == 1) {
	    return 1;
	}
	return countPathsRecursive(n - 1, m) + countPathsRecursive(n, m - 1);
    }

    /**
     * Iterative method
     * 
     * @param n
     * @param m
     * @return
     */
    public int countPaths(int n, int m) {
	int T[][] = new int[n][m];
	for (int i = 0; i < n; i++) {
	    T[i][0] = 1;
	}

	for (int i = 0; i < m; i++) {
	    T[0][i] = 1;
	}
	for (int i = 1; i < n; i++) {
	    for (int j = 1; j < m; j++) {
		T[i][j] = T[i - 1][j] + T[i][j - 1];
	    }
	}
	return T[n - 1][m - 1];
    }

    public static void main(String args[]) {
	NumberOfPathsInMxNMatrix nop = new NumberOfPathsInMxNMatrix();
	int[][] result = new int[1000][1000];
	long start = System.currentTimeMillis();
	System.out.println(nop.countPathsDP(1000, 1000, result));
	System.out.println(System.currentTimeMillis() - start);
	start = System.currentTimeMillis();
	System.out.println(nop.countPaths(1000, 1000));
	System.out.println(System.currentTimeMillis() - start);
	start = System.currentTimeMillis();
	System.out.println(nop.countPathsRecursive(1000, 1000));
	System.out.println(System.currentTimeMillis() - start);
    }

}
