/*
https://leetcode.com/problems/complex-number-multiplication/description/

Given two strings representing two complex numbers.
You need to return a string representing their multiplication. Note i2 = -1 according to the definition.

Example 1:
  Input: "1+1i", "1+1i"
  Output: "0+2i"
  Explanation: (1 + i) * (1 + i) = 1 + i2 + 2 * i = 2i, and you need convert it to the form of 0+2i.
Example 2:
  Input: "1+-1i", "1+-1i"
  Output: "0+-2i"
  Explanation: (1 - i) * (1 - i) = 1 + i2 - 2 * i = -2i, and you need convert it to the form of 0+-2i.
Note:
  The input strings will not have extra blank.
  The input strings will be given in the form of a+bi, where the integer a and b will both belong to the range of [-100, 100].
  And the output should be also in this form.
 */

package main

import (
  "fmt"
  "strings"
  "strconv"
)

func complexNumberMultiply(a string, b string) string {
  ca, cb := strings.Split(a, "+"), strings.Split(b, "+")
  ra, _ := strconv.Atoi(ca[0])
  rb, _ := strconv.Atoi(cb[0])
  ia, _ := strconv.Atoi(strings.TrimRight(ca[1], "i"))
  ib, _ := strconv.Atoi(strings.TrimRight(cb[1], "i"))
  return strconv.Itoa(ra*rb-ia*ib) + "+" + strconv.Itoa(ra*ib+rb*ia) + "i"
}

func main() {
  fmt.Println(complexNumberMultiply("1+1i", "1+-1i"))
}
