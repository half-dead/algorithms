package p1000_;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/sliding-puzzle/
 *
 * @author half-dead
 */
public class Puzzle773 {
    public static void main(String[] args) {
        Solution s = new Puzzle773().new Solution();
        System.out.println(s.slidingPuzzle(new int[][]{{1, 2, 3}, {4, 0, 5}}));
    }


    // DFS
    class Solution {
        public int slidingPuzzle(int[][] board) {
            Map<Integer, Integer> seen = new HashMap<>();
            int[] res = new int[]{-1};
            for (int r = 0; r < 2; r++) {
                for (int c = 0; c < 3; c++) {
                    if (board[r][c] == 0)
                        dfs(board, r, c, res, seen, 0);
                }
            }
            return res[0];
        }

        void dfs(int[][] board, int r, int c, int[] res, Map<Integer, Integer> seen, int count) {
            int num = toInt(board);
            Integer prev = seen.get(num);
            if (prev != null && prev < count) return;
            seen.put(num, count);
            if (num == 123450) {
                if (res[0] == -1) res[0] = count;
                else res[0] = Math.min(res[0], count);
                return;
            }

            if (r > 0) {
                swap(board, r, c, r - 1, c);
                dfs(board, r - 1, c, res, seen, count + 1);
                swap(board, r, c, r - 1, c);
            }
            if (c > 0) {
                swap(board, r, c, r, c - 1);
                dfs(board, r, c - 1, res, seen, count + 1);
                swap(board, r, c, r, c - 1);
            }
            if (r < 1) {
                swap(board, r, c, r + 1, c);
                dfs(board, r + 1, c, res, seen, count + 1);
                swap(board, r, c, r + 1, c);
            }
            if (c < 2) {
                swap(board, r, c, r, c + 1);
                dfs(board, r, c + 1, res, seen, count + 1);
                swap(board, r, c, r, c + 1);
            }
        }

        int toInt(int[][] board) {
            int n = 0;
            for (int[] row : board) {
                for (int cell : row) {
                    n = n * 10 + cell;
                }
            }
            return n;
        }

        void swap(int[][] b, int r1, int c1, int r2, int c2) {
            int temp = b[r1][c1];
            b[r1][c1] = b[r2][c2];
            b[r2][c2] = temp;
        }
    }
}
