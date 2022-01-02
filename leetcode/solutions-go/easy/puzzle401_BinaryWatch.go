/*
https://leetcode.com/problems/binary-watch/description/

A binary watch has 4 LEDs on the top which represent the hours (0-11), and the 6 LEDs on the bottom represent the minutes (0-59).

Each LED represents a zero or one, with the least significant bit on the right.


For example, the above binary watch reads "3:25".

Given a non-negative integer n which represents the number of LEDs that are currently on, return all possible times the watch could represent.

Example:

Input: n = 1
	Return: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32"]
Note:
	The order of output does not matter.
	The hour must not contain a leading zero, for example "01:00" is not valid, it should be "1:00".
	The minute must be consist of two digits and may contain a leading zero, for example "10:2" is not valid, it should be "10:02".
*/

package main

import "fmt"

func readBinaryWatch(num int) []string {
  res := make([]string, 0)
  curr := make([]int, 10)
  all := make([][]int, 0, 10)

  dfs(0, 9, num, curr, &all)

  for _, arr := range all {
    hours := arr[:4]
    h := 0
    times := 1
    for i := len(hours) - 1; i >= 0; i-- {
      if hours[i] == 1 {
        h += times
      }
      times *= 2
    }
    if h > 11 {
      continue
    }

    minutes := arr[4:]
    m := 0
    times = 1
    for i := len(minutes) - 1; i >= 0; i-- {
      if minutes[i] == 1 {
        m += times
      }
      times *= 2
    }
    if m > 59 {
      continue
    }

    res = append(res, fmt.Sprintf("%d:%02d", h, m))
  }
  return res
}

func dfs(start, end, num int, curr []int, all *[][]int) {
  if num == 0 {
    tmp := make([]int, len(curr))
    copy(tmp, curr)
    *all = append(*all, tmp)
    return
  }

  if end-start+1 < num {
    return
  }
  curr[start] = 1
  dfs(start+1, end, num-1, curr, all)
  curr[start] = 0
  dfs(start+1, end, num, curr, all)
}

func main() {
  fmt.Println(readBinaryWatch(5))
}
