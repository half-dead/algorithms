package p1000_;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/boats-to-save-people/
 *
 * @author half-dead
 */
public class Puzzle881_BoatsToSavePeople {
    public static void main(String[] args) {
        Puzzle881_BoatsToSavePeople p = new Puzzle881_BoatsToSavePeople();
        Solution s = p.new Solution();
        System.out.println(s.numRescueBoats(new int[]{
                2, 49, 10, 7, 11, 41, 47, 2, 22, 6, 13, 12, 33, 18, 10, 26, 2, 6, 50, 10
        }, 50));
    }

    class Solution {
        public int numRescueBoats(int[] people, int limit) {
            Arrays.sort(people);
            int left = 0, right = people.length - 1, count = 0;
            while (left <= right) {
                if (people[right] + people[left] <= limit) left++;
                right--;
                count++;
            }
            return count;
        }
    }
}
