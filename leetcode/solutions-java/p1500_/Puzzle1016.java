package p1500_;

import java.util.HashSet;
import java.util.Set;

/**
 * @author half-dead
 */
public class Puzzle1016 {

    public static void main(String[] args) {
        Solution s = new Puzzle1016().new Solution();
        System.out.println(s.queryString("0110", 3));
    }

    class Solution {
        public boolean queryString(String s, int n) {
            Set<Integer> set = new HashSet<>();
            int len = s.length(), bits = Integer.toBinaryString(n).length();
            for (int i = 0; i < len; i++) {
                String temp = s.substring(i, Math.min(i + bits, len));
                int val = Integer.parseInt(temp, 2);
                while (val > 0) {
                    if (val <= n) {
                        if (!set.add(val))
                            break;
                    }
                    val >>= 1;
                }
            }
            return set.size() == n;
        }
    }
}
