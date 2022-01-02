package p1000_;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/bitwise-ors-of-subarrays/
 *
 * @author half-dead
 */
public class Puzzle898 {

    class Solution {
        public int subarrayBitwiseORs(int[] arr) {
            Set<Integer> all = new HashSet<>(), temp = new HashSet<>();
            for (int e : arr) {
                Set<Integer> next = new HashSet<>();
                for (int x : temp) {
                    next.add(x | e);
                }
                next.add(e);
                all.addAll(next);
                temp = next;
            }
            return all.size();
        }
    }
}
