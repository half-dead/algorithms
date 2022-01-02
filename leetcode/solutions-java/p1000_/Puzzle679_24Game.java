package p1000_;

/**
 * https://leetcode.com/problems/24-game/
 *
 * @author half-dead
 */
public class Puzzle679_24Game {
    public static void main(String[] args) {
        Puzzle679_24Game p = new Puzzle679_24Game();
        Solution solution = p.new Solution();
        System.out.println(solution.judgePoint24(new int[]{8, 4, 7, 1}));
        System.out.println(solution.judgePoint24(new int[]{1, 2, 1, 2}));
    }

    class Solution {
        public boolean judgePoint24(int[] nums) {
            int[][] fractions = new int[nums.length][2];
            for (int i = 0; i < nums.length; i++) {
                fractions[i] = new int[]{nums[i], 1};
            }
            return dfs(fractions);
        }

        private boolean dfs(int[][] f) {
            int len = f.length, last = len - 2;
            if (len == 1) {
                return f[0][0] >= 24 && f[0][1] * 24 == f[0][0];
            }

            int[][] next = new int[len - 1][2];
            for (int i = 0; i < len; i++) {
                for (int j = i + 1; j < len; j++) {
                    for (int k = 0, idx = 0; k < len; k++) {
                        if (k != i && k != j) {
                            next[idx++] = new int[]{f[k][0], f[k][1]};
                        }
                    }

                    cal(f[i], f[j], '+', next[last]);
                    if (dfs(next)) return true;
                    cal(f[i], f[j], '*', next[last]);
                    if (dfs(next)) return true;

                    cal(f[i], f[j], '-', next[last]);
                    if (dfs(next)) return true;
                    next[last][0] = -next[last][0];
                    if (dfs(next)) return true;

                    int[] divide = new int[2];
                    cal(f[i], f[j], '/', divide);
                    next[last][0] = divide[0];
                    next[last][1] = divide[1];
                    if (dfs(next)) return true;
                    next[last][0] = divide[1];
                    next[last][1] = divide[0];
                    if (dfs(next)) return true;
                }
            }
            return false;
        }

        private void cal(int[] a, int[] b, char op, int[] r) {
            if (op == '+') {
                r[0] = a[0] * b[1] + b[0] * a[1];
                r[1] = a[1] * b[1];
            } else if (op == '-') {
                r[0] = a[0] * b[1] - b[0] * a[1];
                r[1] = a[1] * b[1];
            } else if (op == '*') {
                r[0] = a[0] * b[0];
                r[1] = a[1] * b[1];
            } else {
                r[0] = a[0] * b[1];
                r[1] = a[1] * b[0];
            }
        }
    }

}
