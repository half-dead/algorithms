package p2000_;

/**
 * https://leetcode.com/problems/maximum-compatibility-score-sum/
 *
 * @author half-dead
 */
public class Puzzle1947 {

    public static void main(String[] args) {
        Solution s = new Puzzle1947().new Solution();
        System.out.println(s.maxCompatibilitySum(new int[][]{
                {1, 1, 0}, {1, 0, 1}, {0, 0, 1}
        }, new int[][]{
                {1, 0, 0}, {0, 0, 1}, {1, 1, 0}
        }));
    }

    class Solution {
        public int maxCompatibilitySum(int[][] students, int[][] mentors) {
            int len = students.length;
            int[][] scores = new int[len][len];
            for (int i = 0; i < len; i++) {
                for (int j = 0; j < len; j++) {
                    scores[i][j] = cal(students[i], mentors[j]);
                }
            }
            int[] res = new int[1];
            bt(0, len, new boolean[len], scores, 0, res);
            return res[0];
        }

        private void bt(int i, int len, boolean[] pairdMentors, int[][] scores, int score, int[] res) {
            if (i == len) {
                res[0] = Math.max(res[0], score);
                return;
            }
            for (int j = 0; j < len; j++) {
                if (pairdMentors[j]) continue;
                pairdMentors[j] = true;
                bt(i + 1, len, pairdMentors, scores, score + scores[i][j], res);
                pairdMentors[j] = false;
            }

        }

        private int cal(int[] s, int[] m) {
            int score = 0;
            for (int i = 0, len = s.length; i < len; i++) {
                if (s[i] == m[i]) score++;
            }
            return score;
        }
    }
}
