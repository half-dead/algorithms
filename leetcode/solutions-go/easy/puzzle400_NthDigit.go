/*
https://leetcode.com/problems/nth-digit/description/

Find the nth digit of the infinite integer sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...

Note:
n is positive and will fit within the range of a 32-bit signed integer (n < 231).

Example 1:
    Input:  3
    Output: 3
Example 2:
    Input:  11
    Output: 0

Explanation:
    The 11th digit of the sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... is a 0, which is part of the number 10.
*/

package main

import (
  "fmt"
)

/*
 1位数有9个，2位数有90个，3位数有900个，以此类推
*/
func findNthDigit(n int) int {
  numDigits, numNumbers := 1, 9
  for x := numDigits * numNumbers; n > x; {
    n = n - x
    numDigits++
    numNumbers *= 10
    x = numDigits * numNumbers
  }

  num := (numNumbers / 9) + ((n - 1) / numDigits)

  // count from left
  digitIndex := (n - 1) % numDigits

  // count from right
  digitIndex = numDigits - digitIndex - 1
  for ; digitIndex > 0; digitIndex-- {
    num = num / 10
  }
  return num % 10
}

type p400PrintfSolution int

func (p400PrintfSolution) findNthDigit(n int) int {
  numDigits, numNumbers := 1, 9
  for x := numDigits * numNumbers; n > x; {
    n = n - x
    numDigits++
    numNumbers *= 10
    x = numDigits * numNumbers
  }

  num := (numNumbers / 9) + ((n - 1) / numDigits)

  digitIndex := (n - 1) % numDigits
  return int([]rune(fmt.Sprintf("%d", num))[digitIndex] - '0')
}

func main() {
  fmt.Println(findNthDigit(1000))

  var v p400PrintfSolution
  fmt.Println(v.findNthDigit(1000))
}
