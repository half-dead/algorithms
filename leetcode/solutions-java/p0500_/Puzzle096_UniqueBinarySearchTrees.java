/*
https://leetcode.com/problems/unique-binary-search-trees/description/

Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?

Example:

    Input: 3
    Output: 5
    Explanation:
    Given n = 3, there are a total of 5 unique BST's:

       1         3     3      2      1
        \       /     /      / \      \
         3     2     1      1   3      2
        /     /       \                 \
       2     1         2                 3
 */

package p0500_;

/**
 * @author half-dead
 */
public class Puzzle096_UniqueBinarySearchTrees {

    public static void main(String[] args) {
        Solution solution = new Puzzle096_UniqueBinarySearchTrees().new Solution();
        for (int i = 1; i <= 15; i++) {
            System.out.println(solution.numTrees(i));
        }
    }

    class Solution {
        public int numTrees(int n) {
            int[] dp = new int[n + 1];
            dp[0] = 1;
            dp[1] = 1;
            for (int i = 2; i <= n; i++) {
                int m = 0;
                for (int j = 0; j < i; j++) {
                    m += dp[j] * dp[i - j - 1];
                }
                dp[i] = m;
            }
            return dp[n];
        }
    }
}
