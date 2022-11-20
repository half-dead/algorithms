package p2500_;

/**
 * https://leetcode.com/problems/determine-if-two-events-have-conflict/
 */
public class Puzzle2446 {
    class Solution {
        public boolean haveConflict(String[] a, String[] b) {
            return a[0].compareTo(b[1]) <= 0 && a[1].compareTo(b[0]) >= 0;
        }
    }
}
