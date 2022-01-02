package p0500_;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/word-break/
 *
 * @author half-dead
 */
public class Puzzle139_WordBreak {

    public static void main(String[] args) {
        Solution s = new Puzzle139_WordBreak().new Solution();
        List<String> dict = new ArrayList<>();
        dict.add("leet");
        dict.add("code");
        boolean result = s.wordBreak("leetcode", dict);
        System.out.println(result);
    }

    class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            Set<String> set = new HashSet<>(wordDict);
            int len = s.length();
            boolean[] dp = new boolean[len];
            for (int i = 0, k = 0; i < len; i++, k++) {
                if (set.contains(s.substring(0, i + 1))) {
                    dp[k] = true;
                    continue;
                }
                for (int j = 0; j < k; j++) {
                    if (dp[j] && set.contains(s.substring(j + 1, i + 1))) {
                        dp[k] = true;
                        break;
                    }
                }
            }
            return dp[len - 1];
        }
    }
}
