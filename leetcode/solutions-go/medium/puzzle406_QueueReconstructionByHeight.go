/*
https://leetcode.com/problems/queue-reconstruction-by-height/description/

Suppose you have a random list of people standing in a queue.
Each person is described by a pair of integers (h, k), where h is the height of the person
  and k is the number of people in front of this person who have a height greater than or equal to h.
Write an algorithm to reconstruct the queue.

Note:
  The number of people is less than 1,100.
Example
  Input:
    [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
  Output:
    [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 */

package main

import (
  "fmt"
  "sort"
)

func reconstructQueue(people [][]int) [][]int {
  dict := make(map[int][]int)
  for _, p := range people {
    dict[p[0]] = append(dict[p[0]], p[1])
  }

  heights := make([]int, len(dict))
  i := 0
  for k, v := range dict {
    heights[i] = k
    sort.Ints(v)
    i++
  }
  sort.Ints(heights)

  res := make([][]int, len(people))
  flags := make([]bool, len(people))
  for i = 0; i < len(heights); i++ {
    group := dict[heights[i]]
    k1, k3 := 0, 0
    for j := 0; j < len(group); j++ {
      k2 := group[j] - j - k3
      for ; flags[k1] || k2 > 0; {
        if !flags[k1] {
          k2--
          k3++
        }
        k1++
      }
      res[k1] = []int{heights[i], group[j]}
      flags[k1] = true
    }
  }
  return res
}

func main() {
  fmt.Println(reconstructQueue([][]int{{2, 4}, {3, 4}, {9, 0}, {0, 6}, {7, 1}, {6, 0}, {7, 3}, {2, 5}, {1, 1}, {8, 0}}))
}
