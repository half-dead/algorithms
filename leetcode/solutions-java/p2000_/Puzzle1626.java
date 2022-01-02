package p2000_;

import java.util.Arrays;
import java.util.TreeMap;

/**
 * https://leetcode.com/problems/best-team-with-no-conflicts/
 *
 * @author half-dead
 */
public class Puzzle1626 {

    public static void main(String[] args) {
        Solution s = new Puzzle1626().new Solution();
        System.out.println(s.bestTeamScore(
                new int[]{596, 277, 897, 622, 500, 299, 34, 536, 797, 32, 264, 948, 645, 537, 83, 589, 770},
                new int[]{18, 52, 60, 79, 72, 28, 81, 33, 96, 15, 18, 5, 17, 96, 57, 72, 72}
        ));
    }

    // sort + dp, O(N^2) time
    class Solution {
        public int bestTeamScore(int[] scores, int[] ages) {
            int n = scores.length, maxScore = 1000001, res = 0;

            for (int i = 0; i < n; i++) scores[i] = ages[i] * maxScore + scores[i];
            Arrays.sort(scores);
            for (int i = 0; i < n; i++) scores[i] %= maxScore;

            TreeMap<Integer, Integer> tm = new TreeMap<>();
            tm.put(0, 0);

            for (int score : scores) {
                int highest = 0;
                for (int sum : tm.subMap(0, true, score, true).values()) {
                    highest = Math.max(highest, sum);
                }

                int total = highest + score;
                res = Math.max(res, total);
                tm.put(score, total);
            }
            return res;
        }
    }
}
