/*
https://leetcode.com/problems/perfect-number/description/

We define the Perfect Number is a positive integer that is equal to the sum of all its positive divisors except itself.

Now, given an integer n, write a function that returns true when it is a perfect number and false when it is not.
Example:
    Input: 28
    Output: True
    Explanation: 28 = 1 + 2 + 4 + 7 + 14
Note: The input number n will not exceed 100,000,000. (1e8)
*/

package main

import "math"

func main() {

}

func checkPerfectNumber(num int) bool {
  maxDivisor := int(math.Floor(math.Sqrt(float64(num))))

  sum := 0
  for d1 := 1; d1 <= maxDivisor && d1 < num; d1++ {
    if num%d1 == 0 {
      sum += d1
      d2 := num / d1
      if d2 != d1 && d2 != num {
        sum += d2
      }
    }
  }
  return num > 0 && sum == num
}
