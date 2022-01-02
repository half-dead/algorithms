package p1000_;

/**
 * @author half-dead
 */
public class Puzzle984_StringWithoutAAAOrBBB {

    public static void main(String[] args) {
        Puzzle984_StringWithoutAAAOrBBB p = new Puzzle984_StringWithoutAAAOrBBB();
        Solution s = p.new Solution();
        System.out.println(s.strWithout3a3b(6, 14));
    }

    class Solution {
        public String strWithout3a3b(int A, int B) {
            int len = A + B;
            char c = 'a', d = 'b';
            int small = B;
            if (A < B) {
                c = 'b';
                d = 'a';
                small = A;
            }

            char[] chars = new char[len];
            for (int i = 0; i < len; i++) {
                chars[i] = c;
            }
            for (int i = 0; i < len; i += 3) {
                if (i + 2 < len) {
                    chars[i + 2] = d;
                    small--;
                }
                if (small <= 0) {
                    break;
                }
            }
            if (small > 0) {
                for (int i = 0; i < len; i += 3) {
                    chars[i] = d;
                    small--;
                    if (small <= 0) {
                        break;
                    }
                }
            }
            return new String(chars);
        }
    }
}
