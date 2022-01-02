// https://leetcode.com/problems/water-bottles/

package main

import "fmt"

func numWaterBottles(numBottles int, numExchange int) int {
  answer := numBottles
  for ; numBottles >= numExchange; {
    answer += numBottles / numExchange
    numBottles = numBottles/numExchange + (numBottles % numExchange)
  }
  return answer
}

func main() {
  fmt.Println(numWaterBottles(9, 3))
  fmt.Println(numWaterBottles(15, 4))
  fmt.Println(numWaterBottles(5, 5))
  fmt.Println(numWaterBottles(2, 3))
}
