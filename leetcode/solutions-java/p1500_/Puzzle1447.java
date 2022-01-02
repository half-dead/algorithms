package p1500_;

import java.util.ArrayList;
import java.util.List;

/**
 * @author half-dead
 */
public class Puzzle1447 {

    class Solution {
        public List<String> simplifiedFractions(int n) {
            List<String> res = new ArrayList<>();
            for (int a = 1; a < n; a++) {
                for (int b = a + 1; b <= n; b++) {
                    if (a == 1 || gcd(a, b) == 1) {
                        res.add(a + "/" + b);
                    }
                }
            }
            return res;
        }

        int gcd(int a, int b) {
            return a > 0 ? gcd(b % a, a) : b;
        }
    }
}
