package p2000_;

/**
 * @author half-dead
 */
public class Puzzle1737 {

    class Solution {
        public int minCharacters(String a, String b) {
            int[] fa = new int[128], fb = new int[128];

            int maxFreqA = 0, maxFreqB = 0;
            for (char c : a.toCharArray()) maxFreqA = Math.max(maxFreqA, ++fa[c]);
            for (char c : b.toCharArray()) maxFreqB = Math.max(maxFreqB, ++fb[c]);

            // operations that makes a, b satisfy condition 3
            int res = a.length() - maxFreqA + b.length() - maxFreqB;

            // operations that makes a, b satisfy condition 1
            int opa = a.length(), opb = 0;
            for (char ca = 'a', cb = 'b'; cb <= 'z'; ca++, cb++) {
                opa -= fa[ca];
                opb += fb[ca];
                res = Math.min(res, opa + opb);
            }

            // operations that makes a, b satisfy condition 2
            opa = 0;
            opb = b.length();
            for (char ca = 'b', cb = 'a'; ca <= 'z'; ca++, cb++) {
                opa += fa[cb];
                opb -= fb[cb];
                res = Math.min(res, opa + opb);
            }
            return res;
        }
    }
}
