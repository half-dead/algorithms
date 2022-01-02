package p1000_;

import java.util.*;

/**
 * https://leetcode.com/problems/pyramid-transition-matrix/
 *
 * @author half-dead
 */
public class Puzzle756_PyramidTransitionMatrix {
    class Solution {
        public boolean pyramidTransition(String bottom, List<String> allowed) {
            Map<String, Set<Character>> map = new HashMap<>();
            for (String allow : allowed) {
                String prefix = allow.substring(0, 2);
                map.computeIfAbsent(prefix, k -> new HashSet<>()).add(allow.charAt(2));
            }
            return recur(bottom, map);
        }

        private boolean recur(String level, Map<String, Set<Character>> map) {
            if (level.length() == 1) {
                return true;
            }
            List<Set<Character>> list = new ArrayList<>();
            for (int i = 1; i < level.length(); i++) {
                String prefix = String.valueOf(new char[]{level.charAt(i - 1), level.charAt(i)});
                if (!map.containsKey(prefix)) {
                    return false;
                } else {
                    list.add(map.get(prefix));
                }
            }

            List<String> all = new ArrayList<>();
            dfs(all, new StringBuilder(), 0, list);
            for (String s : all) {
                if (recur(s, map)) {
                    return true;
                }
            }
            return false;
        }

        private void dfs(List<String> list, StringBuilder current, int index, List<Set<Character>> set) {
            if (index == set.size()) {
                list.add(current.toString());
            } else {
                Set<Character> chars = set.get(index);
                for (char c : chars) {
                    current.append(c);
                    dfs(list, current, index + 1, set);
                    current.deleteCharAt(current.length() - 1);
                }
            }
        }
    }

    class DpSolution {
        public boolean pyramidTransition(String bottom, List<String> allowed) {
            int n = bottom.length();
            Map<Character, List<String>> map = new HashMap<>();
            for (String s : allowed) {
                map.computeIfAbsent(s.charAt(2), k -> new ArrayList<>()).add(s.substring(0, 2));
            }

            boolean[][][] dp = new boolean[n][n][7];
            for (int i = 0; i < n; i++) {
                dp[n - 1][i][bottom.charAt(i) - 'A'] = true;
            }
            for (int i = n - 2; i >= 0; i--) {
                for (int j = 0; j <= i; j++) {
                    for (char ch = 'A'; ch <= 'G'; ch++) {
                        if (!map.containsKey(ch)) {
                            continue;
                        }
                        for (String b : map.get(ch)) {
                            if (dp[i + 1][j][b.charAt(0) - 'A'] && dp[i + 1][j + 1][b.charAt(1) - 'A']) {
                                dp[i][j][ch - 'A'] = true;
                            }
                        }
                    }
                }
            }

            for (int i = 0; i < 7; i++) {
                if (dp[0][0][i]) {
                    return true;
                }
            }
            return false;
        }
    }

    class Solution3 {
        int[][] map;
        public boolean pyramidTransition(String bottom, List<String> allowed) {
            map = new int[7][7];
            for (String a : allowed) {
                map[a.charAt(0) - 'A'][a.charAt(1) - 'A'] |= 1 << (a.charAt(2) - 'A');
            }
            int len = bottom.length();
            int[][] pyramid = new int[len][len];
            int i = 0;
            for (char c : bottom.toCharArray()) {
                pyramid[len - 1][i++] = c - 'A';
            }
            return solve(pyramid, len - 1, 0);
        }

        private boolean solve(int[][] pyramid, int rowLen, int colIndex) {
            if (rowLen == 1 && colIndex == 1) {
                return true;
            } else if (colIndex == rowLen) {
                return solve(pyramid, rowLen - 1, 0);
            } else {
                int encodedResult = map[pyramid[rowLen][colIndex]][pyramid[rowLen][colIndex + 1]];
                for (int b = 0; b < 7; b++) {
                    if (((encodedResult >> b) & 1) != 0) {
                        pyramid[rowLen - 1][colIndex] = b;
                        if (solve(pyramid, rowLen, colIndex + 1)) {
                            return true;
                        }
                    }
                }
                return false;
            }
        }
    }
}
