/*
https://leetcode.com/problems/h-index/description/

Given an array of citations (each citation is a non-negative integer) of a researcher, write a function to compute the researcher's h-index.

According to the definition of h-index on Wikipedia:
    "A scientist has index h if h of his/her N papers have at least h citations each,
    and the other N − h papers have no more than h citations each."

For example, given citations = [3, 0, 6, 1, 5],
which means the researcher has 5 papers in total and each of them had received 3, 0, 6, 1, 5 citations respectively.
Since the researcher has 3 papers with at least 3 citations each and the remaining two with no more than 3 citations each, his h-index is 3.

Note: If there are several possible values for h, the maximum one is taken as the h-index.
*/

package main

import (
  "fmt"
  "sort"
)

// TODO
// There is a better and faster solution without sorting,
// Try to figure it out next time

func hIndex(citations []int) int {

  sort.Ints(citations)
  cLen := len(citations)

  if cLen == 0 || citations[0] >= cLen {
    return cLen
  }

  left, right := 0, cLen-1

  for left <= right {
    mid := (left + right) / 2
    if citations[mid] >= cLen-mid {
      if mid == 0 || citations[mid-1] < cLen-mid+1 {
        return cLen - mid
      } else {
        right = mid - 1
      }
    } else {
      left = mid + 1
    }
  }
  return 0
}

func main() {
  fmt.Println(hIndex([]int{0, 1}))
}
