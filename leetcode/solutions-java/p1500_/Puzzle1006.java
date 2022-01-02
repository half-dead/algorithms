package p1500_;

import java.util.LinkedList;

/**
 * https://leetcode.com/problems/clumsy-factorial/
 *
 * @author half-dead
 */
public class Puzzle1006 {
    public static void main(String[] args) {
        Solution s = new Puzzle1006().new Solution();
        for (int i = 1; i < 20; i++) {
            System.out.println(i + "\t" + s.clumsy(i));
        }
    }

    class MathSolution {
        public int clumsy(int N) {
            int[] magic = new int[]{1, 2, 2, -1, 0, 0, 3, 3};
            return N + ((N > 4) ? magic[N % 4] : magic[N + 3]);
        }
    }

    class Solution {
        public int clumsy(int n) {
            int op = 0, result = 0;
            LinkedList<Integer> q = new LinkedList<>();
            q.push(n);
            while (--n > 0) {
                if (op == 0) {
                    q.push(q.pop() * n);
                } else if (op == 1) {
                    q.push(q.pop() / n);
                } else if (op == 2) {
                    q.push(n);
                } else {
                    q.push(-n);
                }
                op = (op + 1) % 4;
            }
            while (q.size() > 0) result += q.pop();
            return result;
        }
    }
}
