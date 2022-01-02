package p0500_;

// Given an array of integers, find if the array contains any duplicates.
// Your function should return true if any value appears at least twice in the array,
// and it should return false if every element is distinct.

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author half-dead
 */
public class Puzzle217_ContainsDuplicate {

    public static void main(String[] args) {
        Puzzle217_ContainsDuplicate puzzle = new Puzzle217_ContainsDuplicate();
        BitMapSolution solution = puzzle.new BitMapSolution();
        int[] ints = new int[]{1, 2, 3, 4, 5, 6};
        boolean result = solution.containsDuplicate(ints);
        System.out.println(result);
    }

    class Solution {
        public boolean containsDuplicate(int[] nums) {
            Set<Integer> set = new HashSet<>();
            for (int i : nums) {
                if (set.contains(i)) {
                    return true;
                } else {
                    set.add(i);
                }
            }
            return false;
        }
    }

    class BitMapSolution {
        public boolean containsDuplicate(int[] nums) {
            byte[] mem = new byte[0x20000000];
            final int mask = Byte.MAX_VALUE;
            for (int i : nums) {
                long n = ((long) i + Integer.MAX_VALUE + 1);
                int index = (int) (n / 8);
                int mod = (int) (n % 8);
                int flag = mask & (1 << mod);
                if ((mem[index] & flag) != 0) {
                    return true;
                }
                mem[index] = (byte) flag;
            }
            return false;
        }
    }

    class TooLazySolution {
        public boolean containsDuplicate(int[] nums) {
            return nums.length > 0 && Arrays.stream(nums).distinct().boxed().collect(Collectors.toSet()).size() < nums.length;
        }
    }
}
