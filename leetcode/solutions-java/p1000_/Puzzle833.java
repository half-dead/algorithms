package p1000_;

import java.util.TreeMap;

/**
 * https://leetcode.com/problems/find-and-replace-in-string/
 *
 * @author half-dead
 */
public class Puzzle833 {
    public static void main(String[] args) {
        Solution s = new Puzzle833().new Solution();
        System.out.println(s.findReplaceString("vmokgggqzp", new int[]{3, 5, 1}, new String[]{"kg", "ggq", "mo"}, new String[]{"s", "so", "bfr"}));
    }

    class Solution {
        public String findReplaceString(String s, int[] indexes, String[] sources, String[] targets) {
            char[] copy = s.toCharArray();
            int n = indexes.length;
            for (int i = 0; i < n; i++) {
                for (int j = indexes[i], max = j + sources[i].length(); j < max; j++)
                    copy[j] = ' ';
            }

            TreeMap<Integer, String> map = new TreeMap<>();
            int from = 0, to = 0;
            while (to < copy.length) {
                while (to < copy.length && copy[to] != ' ') to++;
                if (to > from) map.put(from, new String(copy, from, to - from));
                while (to < copy.length && copy[to] == ' ') to++;
                from = to;
            }

            for (int i = 0; i < n; i++) {
                int idx = indexes[i];
                if (s.indexOf(sources[i], idx) == idx) map.put(idx, targets[i]);
                else map.put(idx, s.substring(idx, idx + sources[i].length()));
            }

            StringBuilder sb = new StringBuilder();
            for (String part : map.values()) sb.append(part);
            return sb.toString();
        }
    }
}
