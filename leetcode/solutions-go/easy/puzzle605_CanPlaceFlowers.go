/*
https://leetcode.com/problems/can-place-flowers/description/

Suppose you have a long flowerbed in which some of the plots are planted and some are not. However, flowers cannot be planted in adjacent plots - they would compete for water and both would die.

Given a flowerbed (represented as an array containing 0 and 1, where 0 means empty and 1 means not empty), and a number n, return if n new flowers can be planted in it without violating the no-adjacent-flowers rule.

Example 1:
    Input: flowerbed = [1,0,0,0,1], n = 1
    Output: True
Example 2:
    Input: flowerbed = [1,0,0,0,1], n = 2
    Output: False
Note:
    The input array won't violate no-adjacent-flowers rule.
    The input array size is in the range of [1, 20000].
    n is a non-negative integer which won't exceed the input array size.
*/

package main

import "fmt"

func canPlaceFlowers(bed []int, n int) bool {
  size := len(bed)
  for i := 0; i < size; i++ {
    f := bed[i]
    if n == 0 {
      return true
    }
    if f == 0 {
      if (size == 1) ||
        (i == 0 && bed[i+1] == 0) ||
        (i == size-1 && bed[i-1] == 0) ||
        (i-1 > 0 && bed[i-1] == 0 && i+1 < size && bed[i+1] == 0) {
        bed[i] = 1
        n--
      }
    } else {
      i++
    }
  }
  return n <= 0
}

func main() {
  fmt.Println(canPlaceFlowers([]int{1, 0, 0, 0, 1, 0, 0}, 2))
}
