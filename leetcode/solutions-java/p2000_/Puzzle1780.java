package p2000_;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/check-if-number-is-a-sum-of-powers-of-three/
 *
 * @author half-dead
 */
public class Puzzle1780 {

    class Solution {
        public boolean checkPowersOfThree(int n) {
            int e = 4782969;
            while (e > 0) {
                if (n >= e) {
                    n -= e;
                }
                if (n == 0) return true;
                e /= 3;
            }
            return false;
        }
    }

    // brute force
    class Solution1 {
        public boolean checkPowersOfThree(int n) {
            Set<Integer> set = new HashSet<>();
            set.add(1);
            int e = 1;
            while (e <= n) {
                e *= 3;
                Set<Integer> temp = new HashSet<>();
                for (int x : set) {
                    temp.add(x + e);
                }
                set.addAll(temp);
                set.add(e);
                if (set.contains(n)) return true;
            }
            return false;
        }
    }
}
