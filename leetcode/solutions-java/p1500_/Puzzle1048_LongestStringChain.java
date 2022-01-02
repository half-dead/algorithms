package p1500_;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * https://leetcode.com/problems/longest-string-chain/
 *
 * @author half-dead
 */
public class Puzzle1048_LongestStringChain {
    public static void main(String[] args) {
        Solution s = new Puzzle1048_LongestStringChain().new Solution();
        System.out.println(s.longestStrChain(new String[]{"a", "b", "ba", "bca", "bda", "bdca"}));
    }

    class Solution {
        public int longestStrChain(String[] words) {
            Arrays.sort(words, Comparator.comparingInt(String::length));

            int len = words.length, result = 0;
            boolean[][] graph = new boolean[len][len];
            for (int i = 0; i < len; i++) {
                int len1 = words[i].length();
                for (int j = i + 1; j < len; j++) {
                    int len2 = words[j].length();
                    if (len1 == len2) {
                    } else if (len2 - len1 == 1) {
                        if (isPredecessor(words[i], words[j])) graph[j][i] = true;
                    } else break;
                }
            }

            int[] dp = new int[len];
            dp[0] = 1;
            for (int i = 1; i < len; i++) {
                int max = 0;
                for (int j = 0; j < i; j++) if (graph[i][j]) max = Math.max(max, dp[j]);
                result = Math.max(result, (dp[i] = max + 1));
            }
            return result;
        }

        private boolean isPredecessor(String a, String b) {
            int ia = 0, ib = 0, lena = a.length(), lenb = b.length();
            boolean added = false;
            while (ia < lena && ib < lenb) {
                if (a.charAt(ia) == b.charAt(ib)) {
                    ia++;
                    ib++;
                } else if (!added) {
                    added = true;
                    ib++;
                } else return false;
            }
            return true;
        }
    }


    class Solution2 {
        public int longestStrChain(String[] words) {
            List<List<String>> buckets = new ArrayList<>(17);
            for (int i = 0; i < 17; i++) buckets.add(new ArrayList<>());
            for (String word : words) buckets.get(word.length()).add(word);

            int[] sizes = new int[17];
            for (int i = 1; i < 17; i++) sizes[i] = sizes[i - 1] + buckets.get(i).size();

            int len = words.length, result = 0;
            boolean[][] graph = new boolean[len][len];
            for (int i = 2; i < 17; i++) {
                List<String> list1 = buckets.get(i - 1), list2 = buckets.get(i);
                for (int m = 0, len1 = list1.size(); m < len1; m++) {
                    for (int n = 0, len2 = list2.size(); n < len2; n++) {
                        if (isPredecessor(list1.get(m), list2.get(n)))
                            graph[sizes[i - 1] + n][sizes[i - 2] + m] = true;
                    }
                }
            }

            int[] dp = new int[len];
            for (int i = 0; i < sizes[1]; i++) dp[i] = 1;

            for (int i = 2; i < 17; i++) {
                for (int j = sizes[i - 1]; j < sizes[i]; j++) {
                    int max = 0;
                    for (int k = sizes[i - 2]; k < sizes[i - 1]; k++) {
                        if (graph[j][k]) max = Math.max(dp[k], max);
                    }
                    result = Math.max(result, (dp[j] = max + 1));
                }
            }
            return result;
        }

        private boolean isPredecessor(String a, String b) {
            int ia = 0, ib = 0, lena = a.length(), lenb = b.length();
            boolean added = false;
            while (ia < lena && ib < lenb) {
                if (a.charAt(ia) == b.charAt(ib)) {
                    ia++;
                    ib++;
                } else if (!added) {
                    added = true;
                    ib++;
                } else return false;
            }
            return true;
        }
    }
}
