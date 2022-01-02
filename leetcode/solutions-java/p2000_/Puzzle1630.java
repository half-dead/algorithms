package p2000_;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/arithmetic-subarrays/
 *
 * @author half-dead
 */
public class Puzzle1630 {

    public static void main(String[] args) {
        Solution s = new Puzzle1630().new Solution();
        System.out.println(s.checkArithmeticSubarrays(new int[]{4, 6, 5, 9, 3, 7}, new int[]{0, 0, 2}, new int[]{2, 3, 5}));
    }

    // use Map<Integer, Integer>[] to store prefix-freq-map
    class Solution1 {
        public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
            int len = nums.length;
            Map<Integer, Integer>[] fps = new Map[len + 1];
            fps[0] = new HashMap<>();
            for (int i = 0; i < len; i++) {
                Map<Integer, Integer> temp = new HashMap<>(fps[i]);
                temp.put(nums[i], temp.getOrDefault(nums[i], 0) + 1);
                fps[i + 1] = temp;
            }

            List<Boolean> res = new ArrayList<>(l.length);
            for (int i = 0; i < l.length; i++) {
                res.add(check(fps, nums, l[i], r[i]));
            }
            return res;
        }

        boolean check(Map<Integer, Integer>[] fps, int[] nums, int left, int right) {
            if (left + 1 == right) return true;

            int max = nums[left], min = nums[left];
            for (int i = left; i <= right; i++) {
                max = Math.max(max, nums[i]);
                min = Math.min(min, nums[i]);
            }
            if (min == max) return true;

            int delta = (max - min) / (right - left);
            if (delta * (right - left) != max - min) return false;
            for (int v = min + delta; v < max; v += delta) {
                if (fps[right + 1].getOrDefault(v, 0) - fps[left].getOrDefault(v, 0) != 1)
                    return false;
            }
            return true;
        }
    }


    class Solution {

        public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
            Node root = buildST(0, nums.length - 1, nums);

            List<Boolean> ans = new ArrayList<>();
            for (int i = 0; i < l.length; i++) {
                int[] v = get(l[i], r[i], root);
                int len = r[i] - l[i];

                if ((v[1] - v[0]) % len != 0 || (v[0] + v[1]) * (r[i] - l[i] + 1) / (double) 2 != v[2]) {
                    ans.add(false);
                } else if (v[0] == v[1]) {
                    ans.add(true);
                } else {
                    boolean[] diff = new boolean[len + 1];
                    int j = l[i];
                    for (int delta = (v[1] - v[0]) / len; j <= r[i]; j++) {
                        if ((nums[j] - v[0]) % delta != 0 || diff[(nums[j] - v[0]) / delta]) {
                            break;
                        }
                        diff[(nums[j] - v[0]) / delta] = true;
                    }
                    ans.add(j > r[i]);
                }
            }
            return ans;
        }

        private int[] get(int from, int to, Node parent) {
            if (parent == null || from > to) return null;
            if (parent.from == from && parent.to == to) return parent.val;

            Node left = parent.left, right = parent.right;
            int[] lv = get(from, Math.min(left.to, to), left), rv = get(Math.max(from, right.from), to, right);

            if (lv == null) return rv;
            else if (rv == null) return lv;
            else return new int[]{Math.min(lv[0], rv[0]), Math.max(lv[1], rv[1]), lv[2] + rv[2]};
        }

        private Node buildST(int from, int to, int[] nums) {
            if (from == to) return new Node(from, to, nums[from]);

            Node cur = new Node(from, to);
            cur.left = buildST(from, from + (to - from) / 2, nums);
            cur.right = buildST(from + (to - from) / 2 + 1, to, nums);
            cur.val[0] = Math.min(cur.left.val[0], cur.right.val[0]);
            cur.val[1] = Math.max(cur.left.val[1], cur.right.val[1]);
            cur.val[2] = cur.left.val[2] + cur.right.val[2];
            return cur;
        }

        private class Node {
            int[] val = new int[3];
            Node left, right;
            int from, to;

            public Node(int from, int to) {
                this.from = from;
                this.to = to;
            }

            public Node(int from, int to, int num) {
                this.from = from;
                this.to = to;
                val = new int[]{num, num, num};
            }
        }
    }
}
