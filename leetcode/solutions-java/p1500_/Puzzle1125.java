package p1500_;

import java.util.*;

/**
 * https://leetcode.com/problems/smallest-sufficient-team/
 *
 * @author half-dead
 */
public class Puzzle1125 {

    public static void main(String[] args) {
        Solution s = new Puzzle1125().new Solution();
        System.out.println(Arrays.toString(s.smallestSufficientTeam(new String[]{"java", "nodejs", "reactjs"},
                Arrays.asList(
                        Collections.singletonList("java"), Collections.singletonList("nodejs"), Arrays.asList("nodejs", "reactjs")
                ))));
    }

    // dp + bitmasking
    class Solution {
        public int[] smallestSufficientTeam(String[] req, List<List<String>> people) {
            int n = req.length, m = 1 << n, len = people.size();

            Map<String, Integer> skillMap = new HashMap<>();
            for (int i = 0; i < n; i++) skillMap.put(req[i], i);

            int[] pskills = new int[len], dp = new int[m];
            for (int i = 0; i < len; i++) {
                int skills = 0;
                for (String skill : people.get(i)) skills |= 1 << skillMap.get(skill);
                pskills[i] = skills;
            }

            Arrays.fill(dp, -1);
            dp[0] = 0;

            long[] teams = new long[m];
            for (int i = 0, right = 0; i < len; i++) {
                for (int state = 0, tempright = right; state <= tempright; state++) {
                    if (dp[state] < 0) continue;
                    long members = teams[state], mask = 1;

                    int pskill = pskills[i], next = state | pskill;
                    if (next == state) continue;

                    if (dp[next] == -1 || dp[next] > dp[state] + 1) {
                        dp[next] = dp[state] + 1;
                        teams[next] = members | (mask << i);
                        right = Math.max(right, next);
                    }
                }
            }

            long ans = teams[m - 1];
            int[] res = new int[Long.bitCount(ans)];
            for (int i = 0, j = 0; i < len; i++) {
                if ((ans & 1) != 0) res[j++] = i;
                ans >>= 1;
            }
            return res;
        }
    }
}
