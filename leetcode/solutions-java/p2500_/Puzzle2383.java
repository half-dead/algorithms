package p2500_;

/**
 * https://leetcode.com/problems/minimum-hours-of-training-to-win-a-competition/
 *
 * @author half-dead
 */
public class Puzzle2383 {

    public static void main(String[] args) {
        Solution solution = new Puzzle2383().new Solution();
        System.out.println(solution.minNumberOfHours(1, 1, new int[]{1, 1, 1, 1}, new int[]{1, 1, 1, 50}));
    }

    class Solution {
        public int minNumberOfHours(int e, int exp, int[] energy, int[] exps) {
            int n = exps.length, res = 0;
            for (int i = 0; i < n; i++) {
                int reqEnergy = energy[i] + 1, reqExp = exps[i] + 1;
                int tEnergy = Math.max(reqEnergy - e, 0), tExp = Math.max(reqExp - exp, 0);
                res += tEnergy + tExp;
                e = e + tEnergy - energy[i];
                exp = exp + tExp + exps[i];
            }
            return res;
        }
    }
}
