package p1500_;

/**
 * https://leetcode.com/problems/get-equal-substrings-within-budget/
 *
 * @author half-dead
 */
public class Puzzle1208 {

    public static void main(String[] args) {
        Solution s = new Puzzle1208().new Solution();
        Solution2 s2 = new Puzzle1208().new Solution2();
        System.out.println(s.equalSubstring("thjdoffka", "qhrnlntls", 11));
        System.out.println(s2.equalSubstring("thjdoffka", "qhrnlntls", 11));
    }

    // O(1) space
    // the final state of start/end may be invalid, but it doesn't matter because we only need the length of the window
    class Solution {
        public int equalSubstring(String s, String t, int k) {
            int n = s.length(), start = 0, end = 0;
            for (; end < n; end++) {
                k -= Math.abs(s.charAt(end) - t.charAt(end));
                if (k < 0) k += Math.abs(s.charAt(start) - t.charAt(start++));
            }
            return end - start;
        }
    }

    // O(n) space
    class Solution2 {
        public int equalSubstring(String s, String t, int maxCost) {
            int n = s.length(), max = 0, start = 0, end = 0, cost = 0;
            int[] costs = new int[n];
            for (int i = 0; i < n; i++) costs[i] = Math.abs(s.charAt(i) - t.charAt(i));

            while (end < n) {
                if ((cost += costs[end++]) <= maxCost)
                    max = Math.max(max, end - start);
                while (cost > maxCost)
                    cost -= costs[start++];
            }
            return max;
        }
    }
}
