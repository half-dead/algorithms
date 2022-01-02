// https://leetcode.com/problems/slowest-key/

package main

import "fmt"

func slowestKey(releaseTimes []int, keysPressed string) byte {
  size := len(releaseTimes)
  for i := size - 1; i > 0; i-- {
    releaseTimes[i] -= releaseTimes[i-1]
  }
  max := 0
  res := keysPressed[0]
  for i, n := range releaseTimes {
    if n > max {
      max = n
      res = keysPressed[i]
    } else if n == max && keysPressed[i] > res {
      res = keysPressed[i]
    }
  }
  return res
}

func main() {
  fmt.Println(slowestKey([]int{9, 29, 49, 50}, "cbcd"))
  fmt.Println(slowestKey([]int{12, 23, 36, 46, 62}, "spuda"))
}
