package p1500_;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/reconstruct-a-2-row-binary-matrix/
 *
 * @author half-dead
 */
public class Puzzle1253 {
    class Solution {
        public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
            List<Integer> row0 = new ArrayList<>(colsum.length), row1 = new ArrayList<>(colsum.length);
            for (int c : colsum) {
                if (c == 0) {
                    row0.add(0);
                    row1.add(0);
                } else if (c == 1) {
                    if (upper == 0 && lower == 0) return new ArrayList<>();

                    if (upper >= lower) {
                        row0.add(1);
                        row1.add(0);
                        upper--;
                    } else {
                        row0.add(0);
                        row1.add(1);
                        lower--;
                    }
                } else {
                    if (upper == 0 || lower == 0) return new ArrayList<>();
                    upper--;
                    lower--;
                    row0.add(1);
                    row1.add(1);
                }
            }
            return upper + lower == 0 ? Arrays.asList(row0, row1) : new ArrayList<>();
        }
    }
}
