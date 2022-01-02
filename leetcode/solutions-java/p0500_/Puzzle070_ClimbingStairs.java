package p0500_;

// You are climbing a stair case. It takes n steps to reach to the top.
// Each time you can either climb 1 or 2 steps.
// In how many distinct ways can you climb to the top?

/**
 * https://leetcode.com/problems/climbing-stairs/
 */
public class Puzzle070_ClimbingStairs {

    // Bottom cases:
    //   if n <= 0, then the number of ways should be zero.
    //   if n == 1, then there is only way to climb the stair.
    //   if n == 2, then there are two ways to climb the stairs.

    // The key intuition to solve the problem is that given a number of stairs n,
    // if we know the number ways to get to the points [n-1] and [n-2] respectively, denoted as n1 and n2 ,
    // then the total ways to get to the point [n] is n1 + n2.
    // Because from the [n-1] point, we can take one single step to reach [n],
    // and from the [n-2] point, we could take two steps to get there.
    // There is NO overlapping between these two solution sets, because we differ in the final step.

    // fibonacci, using an array
    public class ArraySolution {
        public int climbStairs(int n) {
            if (n < 3) return n;
            int[] arr = new int[n];
            arr[0] = 1;
            arr[1] = 2;
            for (int i = 2; i < n; i++) {
                arr[i] = arr[i - 1] + arr[i - 2];
            }
            return arr[n - 1];
        }
    }

    public class Solution {
        public int climbStairs(int n) {
            if (n < 3) return n;
            int sum = n, one = 1, two = 2;
            for (int i = 2; i < n; i++) {
                sum = one + two;
                one = two;
                two = sum;
            }
            return sum;
        }
    }

    public class DivideAndConquerSolution {
        public int climbStairs(int n) {
            // bottom cases, anybody can easily understand
            if (n <= 0) return 0;
            if (n <= 3) return n;

            // split n stairs at the middle, into two parts: head, tail.
            // f(n) = f(head) * f(tail) + additional case.
            //
            // About the additional case:
            // The border on head and tail both contribute an '1', then we form a '2' in the middle.
            // So total case of additional case should = f(head - 1) * f(tail -1).
            int head = n >> 1;
            int tail = n - head;
            return climbStairs(head) * climbStairs(tail) + climbStairs(head - 1) * climbStairs(tail - 1);
        }
    }
}
