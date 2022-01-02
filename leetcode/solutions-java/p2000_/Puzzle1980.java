package p2000_;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author half-dead
 */
public class Puzzle1980 {

    // take 1 bit from each string(0th bit from 0th string, 1th bit from 1th string ....)
    // then flip every bit, it's the answer.
    class Solution {
        public String findDifferentBinaryString(String[] nums) {
            StringBuilder ans = new StringBuilder();
            for (int i = 0; i < nums.length; i++) ans.append(nums[i].charAt(i) == '0' ? '1' : '0');
            return ans.toString();
        }
    }

    // just try every numbers, since nums.length <= 16, we only need to try at most 16 numbers
    class DumbSolution {
        public String findDifferentBinaryString(String[] nums) {
            Set<String> set = Arrays.stream(nums).collect(Collectors.toSet());

            String ones = "1111111111111111", zeros = "0000000000000000";
            int n = nums.length, max = Integer.parseInt(ones.substring(0, n), 2);

            String temp = Integer.toBinaryString(max);
            while (set.contains(temp))
                temp = Integer.toBinaryString(--max);

            if (temp.length() < n) temp = zeros.substring(0, n - temp.length()) + temp;
            return temp;
        }
    }
}
