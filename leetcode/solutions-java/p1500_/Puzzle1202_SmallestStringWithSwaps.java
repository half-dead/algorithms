package p1500_;

import java.util.*;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/smallest-string-with-swaps/
 *
 * @author half-dead
 */
public class Puzzle1202_SmallestStringWithSwaps {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.smallestStringWithSwaps("habcdefg", convert(new int[][]{{0, 1}, {1, 2}, {2, 3}, {4, 5}, {5, 6}, {6, 7}, {7, 2}})));
    }

    static List<List<Integer>> convert(int[][] arr) {
        return Arrays.stream(arr).map(pair -> Arrays.stream(pair).boxed().collect(Collectors.toList())).collect(Collectors.toList());
    }

    // Priority Queue
    class Solution2 {
        public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
            int len = s.length();
            int[] dsu = new int[len];
            for (int i = 0; i < len; i++) dsu[i] = i;
            for (List<Integer> pair : pairs) union(pair.get(0), pair.get(1), dsu);

            char[] chars = s.toCharArray();
            Map<Integer, PriorityQueue<Character>> pqs = new LinkedHashMap<>();
            for (int i = 0; i < len; i++)
                pqs.computeIfAbsent(find(dsu[i], dsu), (root) -> new PriorityQueue<>()).offer(chars[i]);

            for (int i = 0; i < len; i++) {
                chars[i] = pqs.get(find(dsu[i], dsu)).poll();
            }
            return new String(chars);
        }

        private void union(int x, int y, int[] dsu) {
            int px = find(x, dsu), py = find(y, dsu);
            dsu[Math.max(px, py)] = Math.min(px, py);
        }

        private int find(int x, int[] dsu) {
            while (dsu[x] != x) {
                dsu[x] = dsu[dsu[x]];
                x = dsu[x];
            }
            return dsu[x];
        }
    }

    // Bucket sort
    static class Solution {

        public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
            int len = s.length();
            int[] dsu = new int[len];
            for (int i = 0; i < len; i++) dsu[i] = i;
            for (List<Integer> pair : pairs) union(dsu, pair.get(0), pair.get(1));

            Map<Integer, List<Integer>> map = new LinkedHashMap<>();
            for (int i = 0; i < len; i++)
                map.computeIfAbsent(find(dsu, dsu[i]), (root) -> new LinkedList<>()).add(i);

            char[] chars = s.toCharArray();
            for (List<Integer> list : map.values()) {
                int[] count = new int[26];
                for (int pos : list) count[chars[pos] - 'a']++;

                int idx = 0;
                for (int pos : list) {
                    while (count[idx]-- == 0) idx++;
                    chars[pos] = (char) ('a' + idx);
                }
            }
            return new String(chars);
        }

        static void union(int[] dsu, int x, int y) {
            int px = find(dsu, x), py = find(dsu, y);
            dsu[Math.max(px, py)] = Math.min(px, py);
        }

        static private int find(int[] dsu, int x) {
            while (dsu[x] != x) {
                dsu[x] = dsu[dsu[x]];
                x = dsu[x];
            }
            return dsu[x];
        }
    }


}
