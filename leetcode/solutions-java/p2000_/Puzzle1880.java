package p2000_;

/**
 * https://leetcode.com/problems/check-if-word-equals-summation-of-two-words/
 *
 * @author half-dead
 */
public class Puzzle1880 {

    class Solution {
        public boolean isSumEqual(String fw, String sw, String tw) {
            char[] cf = fw.toCharArray(), cs = sw.toCharArray(), ct = tw.toCharArray();
            int decr = 'a' - '0';
            for (int i = 0; i < cf.length; i++) cf[i] -= decr;
            for (int i = 0; i < cs.length; i++) cs[i] -= decr;
            for (int i = 0; i < ct.length; i++) ct[i] -= decr;
            int first = Integer.parseInt(new String(cf)),
                    second = Integer.parseInt(new String(cs)),
                    target = Integer.parseInt(new String(ct));
            return first + second == target;

        }
    }
}
