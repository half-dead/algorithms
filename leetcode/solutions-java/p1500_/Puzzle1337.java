package p1500_;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix/
 *
 * @author half-dead
 */
public class Puzzle1337 {
    public static void main(String[] args) {
        Solution s = new Puzzle1337().new Solution();
//        Print.pt(s.kWeakestRows(new int[][]{{1, 1, 0, 0, 0}, {1, 1, 1, 1, 0}, {1, 0, 0, 0, 0}, {1, 1, 0, 0, 0}, {1, 1, 1, 1, 1}}, 3));

        System.out.println(s.countOnes(new int[]{1, 1, 1, 0}));
        System.out.println(s.countOnes(new int[]{1, 1, 1, 1}));
        System.out.println(s.countOnes(new int[]{0, 0, 0, 0}));
    }

    class Solution {
        public int[] kWeakestRows(int[][] mat, int k) {
            PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> b[0] == a[0] ? b[1] - a[1] : b[0] - a[0]);
            for (int i = 0; i < mat.length; i++) {
                q.add(new int[]{countOnes(mat[i]), i});
                if (q.size() > k) q.poll();
            }
            int[] res = new int[k];
            while (k > 0) res[--k] = q.poll()[1];
            return res;
        }

        int countOnes(int[] row) {
            int lo = 0, hi = row.length - 1;
            while (lo < hi) {
                int mid = (lo + hi) / 2;
                if (row[mid] == 1 && row[mid + 1] == 0) return mid + 1;
                else if (row[mid] == 1) lo = mid + 1;
                else hi = mid;
            }
            return lo == 0 ? 0 : lo + 1;
        }
    }

    class SortSolution {
        public int[] kWeakestRows(int[][] mat, int k) {
            int rows = mat.length;
            int[][] arr = new int[rows][2];
            for (int i = 0; i < rows; i++) arr[i][1] = i;
            for (int i = 0; i < rows; i++) {
                int[] row = mat[i];
                int cnt = 0;
                for (int v : row)
                    if (v == 1) cnt++;
                    else break;
                arr[i][0] = cnt;
            }
            Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));
            int[] res = new int[k];
            for (int i = 0; i < k; i++) res[i] = arr[i][1];
            return res;
        }

    }
}
