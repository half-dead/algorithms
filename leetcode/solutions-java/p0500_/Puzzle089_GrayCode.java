package p0500_;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/gray-code/
 *
 * @author half-dead
 */
public class Puzzle089_GrayCode {

    public static void main(String[] args) {
        Solution s = new Puzzle089_GrayCode().new Solution();
        NeatSolution ns = new Puzzle089_GrayCode().new NeatSolution();
        List<Integer> list1 = s.grayCode(5);
        List<Integer> list2 = ns.grayCode(5);
        for (int i = 0; i < list1.size(); i++) {
            System.out.print(Integer.toBinaryString(list1.get(i)));
            System.out.print('\t');
            System.out.print(Integer.toBinaryString(list2.get(i)));
            System.out.println();
        }
    }

    class Solution {
        public List<Integer> grayCode(int n) {
            if (n == 0) {
                List<Integer> result = new ArrayList<>(1);
                result.add(0);
                return result;
            } else {
                List<Integer> prev = grayCode(n - 1);
                int size = prev.size();
                List<Integer> result = new ArrayList<>(size * 2);
                for (int i = 0; i < size; i++) {
                    result.add(prev.get(i));
                }
                int mask = 1 << (n - 1);
                for (int i = size - 1; i >= 0; i--) {
                    result.add(mask | prev.get(i));
                }
                return result;
            }
        }
    }

    // TODO didn't understand
    class NeatSolution {
        public List<Integer> grayCode(int n) {
            List<Integer> result = new ArrayList<>();
            for (int i = 0; i < 1 << n; i++) {
                result.add(i ^ i >> 1);
            }
            return result;
        }
    }
}
