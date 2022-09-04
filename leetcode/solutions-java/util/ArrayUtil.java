package util;

import java.util.Arrays;

/**
 * @author half-dead
 */
class ArrayUtil {
    static void fill(int[] array, int defaultValue) {
        Arrays.fill(array, defaultValue);
    }

    static void fill(int[][] array, int defaultValue) {
        int n1 = array.length;
        for (int i = 0; i < n1; i++) {
            int n2 = array[i].length;
            for (int j = 0; j < n2; j++) {
                array[i][j] = defaultValue;
            }
        }
    }

    static void fill(int[][][] array, int defaultValue) {
        int n1 = array.length;
        for (int i = 0; i < n1; i++) {
            int n2 = array[i].length;
            for (int j = 0; j < n2; j++) {
                int n3 = array[i][j].length;
                for (int k = 0; k < n3; k++) {
                    array[i][j][k] = defaultValue;
                }
            }
        }
    }

    static void fill(int[][][][] array, int defaultValue) {
        int n1 = array.length;
        for (int i = 0; i < n1; i++) {
            int n2 = array[i].length;
            for (int j = 0; j < n2; j++) {
                int n3 = array[i][j].length;
                for (int k = 0; k < n3; k++) {
                    int n4 = array[i][j][k].length;
                    for (int l = 0; l < n4; l++) {
                        array[i][j][k][l] = defaultValue;
                    }
                }
            }
        }
    }

    static void fill(int[][][][][] array, int defaultValue) {
        int n1 = array.length;
        for (int i = 0; i < n1; i++) {
            int n2 = array[i].length;
            for (int j = 0; j < n2; j++) {
                int n3 = array[i][j].length;
                for (int k = 0; k < n3; k++) {
                    int n4 = array[i][j][k].length;
                    for (int l = 0; l < n4; l++) {
                        int n5 = array[i][j][k][l].length;
                        for (int x = 0; x < n5; x++) {
                            array[i][j][k][l][x] = defaultValue;
                        }
                    }
                }
            }
        }
    }
}
