package p1000_;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/add-to-array-form-of-integer/
 *
 * @author half-dead
 */
public class Puzzle989_AddToArrayFormOfInteger {
    public static void main(String[] args) {
        Puzzle989_AddToArrayFormOfInteger p = new Puzzle989_AddToArrayFormOfInteger();
        Solution s = p.new Solution();
        System.out.println(s.addToArrayForm(new int[]{1}, 999));
    }

    class Solution {
        public List<Integer> addToArrayForm(int[] a, int k) {
            LinkedList<Integer> result = new LinkedList<>();
            int carry = 0;
            for (int i = a.length - 1; i >= 0 || k > 0; i--) {
                int m = i >= 0 ? a[i] : 0, n = k % 10;
                int d = m + n + carry;
                result.push(d % 10);
                carry = d / 10;
                k /= 10;
            }
            if (carry > 0) result.push(carry);
            return result;
        }
    }
}
