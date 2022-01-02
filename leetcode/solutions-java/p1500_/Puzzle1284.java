package p1500_;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * https://leetcode.com/problems/minimum-number-of-flips-to-convert-binary-matrix-to-zero-matrix/
 *
 * @author half-dead
 */
public class Puzzle1284 {
    public static void main(String[] args) {
        Solution s = new Puzzle1284().new Solution();
        System.out.println(s.minFlips(new int[][]{{0, 0}, {0, 1}}));
        System.out.println(s.minFlips(new int[][]{{0}}));
        System.out.println(s.minFlips(new int[][]{{1, 1, 1}, {1, 0, 1}, {0, 0, 0}}));
        System.out.println(s.minFlips(new int[][]{{1, 0, 0}, {1, 0, 0}}));
    }

    class Solution {
        public int minFlips(int[][] mat) {
            int rows = mat.length, cols = mat[0].length, bits = rows * cols;
            int num = 0, steps = 0, i = 0;
            int[] xors = new int[rows * cols];
            for (int[] row : mat) {
                for (int v : row) {
                    num = (num << 1) | v;
                    xors[i++] = 1 << (bits - i);
                }
            }

            LinkedList<Integer> q = new LinkedList<>();
            Set<Integer> seen = new HashSet<>();
            q.offer(num);
            seen.add(num);
            while (q.size() > 0) {
                i = q.size();
                while (i-- > 0) {
                    int curr = q.pop();
                    if (curr == 0) return steps;

                    for (int r = 0, j = 0; r < rows; r++) {
                        for (int c = 0; c < cols; c++, j++) {
                            int next = curr ^ xors[j];
                            if (r > 0) next ^= xors[j - cols];
                            if (r + 1 < rows) next ^= xors[j + cols];
                            if (c > 0) next ^= xors[j - 1];
                            if (c + 1 < cols) next ^= xors[j + 1];
                            if (seen.add(next)) q.offer(next);
                        }
                    }
                }
                steps++;
            }
            return -1;
        }
    }
}
