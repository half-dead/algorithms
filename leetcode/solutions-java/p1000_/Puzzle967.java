package p1000_;

import util.Print;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/numbers-with-same-consecutive-differences/
 *
 * @author half-dead
 */
public class Puzzle967 {

    public static void main(String[] args) {
        Solution s = new Puzzle967().new Solution();
        Print.pt(s.numsSameConsecDiff(3, 7));
        Print.pt(s.numsSameConsecDiff(2, 1));
    }

    class Solution {
        public int[] numsSameConsecDiff(int d, int k) {
            if (d == 1) return new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

            List<Integer> list = new ArrayList<>();
            for (int i = 1; i <= 9; i++) dfs(i, d, k, list);

            int[] res = new int[list.size()];
            int i = 0;
            for (int num : list) res[i++] = num;
            return res;
        }

        void dfs(int n, int d, int k, List<Integer> list) {
            if (d == 1) {
                list.add(n);
                return;
            }
            int last = n % 10;
            n *= 10;
            if (last >= k) dfs(n *= 10 + last - k, d - 1, k, list);
            if (k != 0 && last + k <= 9) dfs(n + last + k, d - 1, k, list);
        }
    }

    class BfsSolution {
        public int[] numsSameConsecDiff(int N, int K) {
            Queue<String> q = new LinkedList<>();
            for (int i = 0; i < 10; i++) q.offer("" + i);

            List<Integer> list = new ArrayList<>();
            while (q.size() > 0) {
                String s = q.poll();
                if (s.length() == N) {
                    if (N == 1 || s.charAt(0) != '0') list.add(Integer.parseInt(s));
                    continue;
                }
                char last = s.charAt(s.length() - 1);
                if (last - K >= '0') q.offer(s + (char) (last - K));
                if (K != 0 && last + K <= '9') q.offer(s + (char) (last + K));
            }
            int[] res = new int[list.size()];
            int i = 0;
            for (int num : list) res[i++] = num;
            return res;
        }
    }
}
