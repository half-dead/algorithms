package p1000_;

import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode.com/problems/snakes-and-ladders/
 *
 * @author half-dead
 */
public class Puzzle909 {

    class Solution {
        public int snakesAndLadders(int[][] board) {
            int n = board.length, moves = -1, max = n * n;
            boolean[] v = new boolean[max + 1];
            Deque<Integer> q = new LinkedList<>();
            q.addLast(1);

            while (q.size() > 0) {
                moves++;
                int sz = q.size();
                while (sz-- > 0) {
                    int curr = q.pollFirst();
                    if (v[curr]) continue;

                    v[curr] = true;
                    if (curr == max) return moves;

                    for (int d = 1; d <= 6; d++) {
                        int next = curr + d, r = (next - 1) / n, c = (next - 1) % n;
                        if (next > max) break;
                        if (r % 2 != 0) c = n - 1 - c;
                        if (board[n - 1 - r][c] != -1) next = board[n - 1 - r][c];
                        if (v[next]) continue;
                        q.addLast(next);
                    }
                }
            }
            return -1;
        }
    }
}
