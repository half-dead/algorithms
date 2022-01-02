package p1500_;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/path-in-zigzag-labelled-binary-tree/
 *
 * @author half-dead
 */
public class Puzzle1104_PathInZigzagLabelledBinaryTree {

    public static void main(String[] args) {
        Solution s = new Puzzle1104_PathInZigzagLabelledBinaryTree().new Solution();
        System.out.println(s.pathInZigZagTree(14));
        System.out.println(s.pathInZigZagTree(26));
    }

    class Solution {
        public List<Integer> pathInZigZagTree(int label) {
            int n = label, row = 0;
            while (n > 0) {
                n >>= 1;
                row++;
            }
            LinkedList<Integer> q = new LinkedList<>();
            int min = 1 << (row - 1), max = (1 << row) - 1;
            int pos = (row & 1) == 0 ? (max + min - label) : label;
            while (row > 0) {
                min = 1 << (row - 1);
                max = (1 << row) - 1;
                q.push((row & 1) == 0 ? (max + min - pos) : pos);
                pos >>= 1;
                row--;
            }
            return q;
        }
    }
}
