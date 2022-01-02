package p2000_;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/three-divisors/
 *
 * @author half-dead
 */
public class Puzzle1952 {

    // square of primes less than 100;
    class Solution {
        public boolean isThree(int n) {
            int[] primes = new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97};
            Set<Integer> set = new HashSet<>(primes.length);
            for (int p : primes) set.add(p * p);
            return set.contains(n);
        }
    }
}
