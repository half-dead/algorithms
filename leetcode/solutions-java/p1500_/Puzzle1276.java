package p1500_;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/number-of-burgers-with-no-waste-of-ingredients/
 *
 * @author half-dead
 */
public class Puzzle1276 {

    class Solution {
        public List<Integer> numOfBurgers(int t, int c) {
            List<Integer> res = new ArrayList<>();
            int x = (t - c * 2) / 2;
            if (x >= 0 && x <= c && x * 2 == t - c * 2) {
                res.add(x);
                res.add(c - x);
            }
            return res;
        }
    }
}
