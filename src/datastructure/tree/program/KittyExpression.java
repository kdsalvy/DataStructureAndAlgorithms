package datastructure.tree.program;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;
import java.util.Stack;

/**
 * https://www.hackerrank.com/challenges/kittys-calculations-on-a-tree/problem
 * 
 * @author saukedia1
 *
 */
public class KittyExpression {

    public static void main(String[] args) throws FileNotFoundException {

        try (Scanner sc = new Scanner(new FileInputStream(new File("C:\\Users\\saukedia1\\git\\DataStructureAndAlgorithms\\KittyExpressionsIP01.txt")))) {
            int n = Integer.valueOf(sc.next());
            int q = Integer.valueOf(sc.next());

            int[][] aMatrix = new int[n][n];

            for (int i = 0; i < n - 1; i++) {
                int vI = Integer.valueOf(sc.next());
                int hI = Integer.valueOf(sc.next());
                aMatrix[vI - 1][hI - 1] = 1;
                aMatrix[hI - 1][vI - 1] = 1;
            }

            List<List<Integer>> list = new ArrayList<>();
            for (int i = 0; i < q; i++) {
                int sN = Integer.valueOf(sc.next());
                List<Integer> intList = new ArrayList<>();
                for (int j = 0; j < sN; j++) {
                    intList.add(Integer.valueOf(sc.next()));
                }
                list.add(i, intList);
            }

            ListIterator<List<Integer>> itr = list.listIterator();
            while (itr.hasNext()) {
                System.out.println(solveExpression(itr.next(), aMatrix));
            }
        }
    }

    public static int solveExpression(List<Integer> intList, int[][] aMatrix) {
        int sum = 0;
        // System.out.println("list " + intList);
        for (int j = 0; j < intList.size() - 1; j++) {
            int s = intList.get(j);
            // System.out.println("s " + s);
            for (int k = j + 1; k < intList.size(); k++) {
                int[][] visited = new int[aMatrix.length][aMatrix.length];
                int d = intList.get(k);
                // System.out.println("d " + d);
                int dist = 0;
                if (aMatrix[s - 1][d - 1] > 0) {
                    dist = aMatrix[s - 1][d - 1];
                } else {
                    // System.out.println("Calculating Distance");
                    // dist = calculateDistance(s, d, aMatrix);
                    dist = calculateDistanceRecursively(s, d, aMatrix, visited);
                }
                // System.out.println("dist " + dist);
                sum += s * d * dist;
            }
        }
        return sum;
    }

    // only one test case passed rest throwing stack overflow
    public static int calculateDistanceRecursively(int s, int d, int[][] aMatrix, int[][] visited) {
        System.out.println("s: " + s + " d: " + d);
        if (aMatrix[s - 1][d - 1] > 0) {
            System.out.println(s + " : " + d + " distance: " + aMatrix[s - 1][d - 1]);
            return aMatrix[s - 1][d - 1];
        }
        for (int i = 0; i < aMatrix[s - 1].length; i++) {
            if (aMatrix[s - 1][i] >= 1 && visited[s - 1][i] != 1) {
                visited[s - 1][i] = 1;
                visited[i][s - 1] = 1;
                int distance = calculateDistanceRecursively(i + 1, d, aMatrix, visited);
                if(distance > 0) {
                    aMatrix[s - 1][d - 1] = aMatrix[s - 1][i] + distance;
                    return aMatrix[s - 1][d - 1];
                }
                System.out.println(s + " : " + d + " distance: " + aMatrix[s - 1][d - 1]);
            }
        }
        return aMatrix[s - 1][d - 1];
    }

    // Only 1 test case passed
    public static int calculateDistance(int s, int d, int[][] aMatrix) {
        int[][] visited = new int[aMatrix.length][aMatrix.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(s);
        int distance = 0;
        int temp = -1;
        while (!stack.isEmpty() && temp != d) {
            int src = stack.pop();
            if (src == -1) {
                distance--;
            } else {
                distance++;
                stack.push(-1);
            }
            System.out.println("src " + src);
            for (int i = 0; src != -1 && i < aMatrix[src - 1].length; i++) {
                // System.out.println("i " + i);
                if (aMatrix[src - 1][i] > 0 && i == d - 1) {
                    System.out.println("temp " + temp);
                    temp = i + 1;
                    distance += aMatrix[src - 1][i] - 1;
                    visited[src - 1][i] = 1;
                    break;
                }
                if (aMatrix[src - 1][i] >= 1 && visited[src - 1][i] != 1) {
                    stack.push(i + 1);
                    visited[src - 1][i] = 1;
                }
            }
        }
        System.out.println("d " + d + " temp " + temp);
        aMatrix[s - 1][d - 1] = temp == d ? distance : 0;
        aMatrix[d - 1][s - 1] = temp == d ? distance : 0;
        return temp == d ? distance : 0;
    }
}
