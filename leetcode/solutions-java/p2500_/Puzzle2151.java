package p2500_;

import java.util.LinkedList;

/**
 * https://leetcode.com/problems/maximum-good-people-based-on-statements/
 *
 * @author half-dead
 */
public class Puzzle2151 {

    // brute-force, bfs, bitmasking
    class Solution {
        public int maximumGood(int[][] stmts) {
            int n = stmts.length, all = (1 << n) - 1;

            int[] masks = new int[n];
            for (int i = 0; i < n; i++) masks[i] = 1 << i;

            int[] enemies = new int[n], friends = new int[n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (stmts[i][j] == 0) {
                        // i and j cant both be good person
                        enemies[i] |= 1 << j;
                        enemies[j] |= 1 << i;
                    } else if (stmts[i][j] == 1) {
                        // if i is good person, j must be good person too
                        friends[i] |= 1 << j;
                    }
                }
            }

            boolean[] v = new boolean[1 << n];
            v[all] = true;

            // start bfs with all person are good
            LinkedList<Integer> q = new LinkedList<>();
            q.addLast(all);
            while (q.size() > 0) {
                int curr = q.pollFirst();
                // check if this assignment is valid
                if (check(curr, friends, enemies, masks)) return Integer.bitCount(curr);

                for (int mask : masks) {
                    if ((curr & mask) == mask) {
                        int next = curr ^ mask;
                        if (!v[next]) {
                            v[next] = true;
                            q.addLast(next);
                        }
                    }
                }
            }
            return 0;
        }

        boolean check(int state, int[] friends, int[] enemy, int[] masks) {
            for (int i = 0; i < masks.length; i++) {
                if ((state & masks[i]) != 0) {
                    if (((state ^ masks[i]) & enemy[i]) != 0) return false;
                    if (((state ^ masks[i]) & friends[i]) != friends[i]) return false;
                }
            }
            return true;
        }
    }
}
