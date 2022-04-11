package p2500_;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/maximum-split-of-positive-even-integers/
 *
 * @author half-dead
 */
public class Puzzle2178 {

    public static void main(String[] args) {
        Solution s = new Puzzle2178().new Solution();
        System.out.println(s.maximumEvenSplit(12L));
    }

    class Solution {
        public List<Long> maximumEvenSplit(long finalSum) {
            if (finalSum % 2 != 0) return new ArrayList<>();
            LinkedList<Long> result = new LinkedList<>();
            for (long x = 2; finalSum >= x; x += 2) {
                finalSum -= x;
                result.add(x);
            }

            result.addLast(result.pollLast() + finalSum);
            return result;
        }
    }
}
