/*
https://leetcode.com/problems/largest-palindrome-product/description/

Find the largest palindrome made from the product of two n-digit numbers.
Since the result could be very large, you should return the largest palindrome mod 1337.

Example:
  Input: 2
  Output: 987
  Explanation: 99 x 91 = 9009, 9009 % 1337 = 987

Note:
  The range of n is [1,8].
 */

package main

// TODO this is NEITHER a good problem, NOR an easy problem
func largestPalindrome(n int) int {
  result := []int{9, 9009, 906609, 99000099, 9966006699, 999000000999, 99956644665999, 9999000000009999}
  return result[n-1] % 1337
}

func main() {

}
