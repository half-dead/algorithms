package p1000_;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * https://leetcode.com/problems/falling-squares/
 *
 * @author half-dead
 */
public class Puzzle699 {

    public static void main(String[] args) {
        Solution s = new Puzzle699().new Solution();
        System.out.println(s.fallingSquares(new int[][]{
                {9, 7}, {1, 9}, {3, 1}
        }));
    }

    // Optimized Segment Tree, O(NlogN) 7ms.
    class Solution {
        public List<Integer> fallingSquares(int[][] positions) {
            List<Integer> res = new ArrayList<>(positions.length);
            ST root = new ST(1, Integer.MAX_VALUE, 0);
            int max = 0;
            for (int[] pos : positions) {
                int curr = root.query(pos[0], pos[0] + pos[1]);
                max = Math.max(max, root.update(pos[0], pos[0] + pos[1], curr + pos[1]));
                res.add(max);
            }
            return res;
        }


        class ST {
            int start, end, h, cut;
            boolean leaf = true;
            ST left, right;

            ST(int start, int end, int h) {
                this.start = start;
                this.end = end;
                this.h = h;
            }

            int update(int from, int to, int height) {
                if (!leaf) {
                    int currH;
                    if (cut >= to) currH = left.update(from, to, height);
                    else if (cut <= from) currH = right.update(from, to, height);
                    else currH = Math.max(left.update(from, cut, height), right.update(cut, to, height));
                    return h = Math.max(h, currH);
                }

                if (start == from && end == to) return h = height;

                if (start == from) {
                    cut = to;
                    left = new ST(start, cut, height);
                    right = new ST(cut, end, h);
                } else if (end == to) {
                    cut = from;
                    left = new ST(start, cut, h);
                    right = new ST(cut, end, height);
                } else {
                    cut = from;
                    left = new ST(start, cut, h);
                    right = new ST(cut, end, h);
                    right.update(from, to, height);
                }

                leaf = false;
                return h = Math.max(left.h, right.h);
            }

            int query(int from, int to) {
                if (leaf) return h;

                if (cut >= to) return left.query(from, to);
                else if (cut <= from) return right.query(from, to);
                else return Math.max(left.query(from, cut), right.query(cut, to));
            }
        }
    }

}
