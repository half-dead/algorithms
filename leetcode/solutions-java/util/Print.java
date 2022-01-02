package util;

import java.util.Arrays;
import java.util.List;

/**
 * @author half-dead
 */
public class Print {

    public static void main(String[] args) {
        System.out.println("abc".substring(0,87623));
    }

    public static void pt(int[] a) {
        System.out.println(Arrays.toString(a));
    }

    public static void pt(int[][] m) {
        for (int[] r : m) pt(r);
        System.out.println("-----------------------------------------");
    }

    public static void pt(List<List<Integer>> m) {
        System.out.println(m);
    }

    public static void pts(List<String> s) {
        for (String l : s) System.out.println(l);
    }

    public static void pt(char[][] board) {
        for (char[] row : board) {
            System.out.println(new String(row));
        }
        System.out.println("------------------------------------------");
    }

    public static void pt(double[][] dp) {
        for (double[] row : dp) System.out.println(Arrays.toString(row));
        System.out.println("------------------------------------------");
    }
}
