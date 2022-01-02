package p1000_;

/**
 * https://leetcode.com/problems/reach-a-number/
 *
 * @author half-dead
 */
public class Puzzle754_ReachANumber {

    public static void main(String[] args) {
        Puzzle754_ReachANumber p = new Puzzle754_ReachANumber();
        Solution s = p.new Solution();
        System.out.println(s.reachNumber(2));
    }

    class Solution {
        public int reachNumber(int target) {
            if (target < 0) {
                target = -target;
            }
            double root = Math.sqrt(target * 2 + 0.25d) - 0.5d;
            double closest = Math.ceil(root);
            if (root == closest) {
                return (int) closest;
            }
            int base = (int) closest;
            int max = base * (base + 1) / 2;
            boolean targetIsEven = target % 2 == 0;
            boolean maxIsEven = max % 2 == 0;
            if (maxIsEven == targetIsEven) {
                return base;
            } else {
                return base % 2 == 0 ? (base + 1) : (base + 2);
            }
        }
    }
}
