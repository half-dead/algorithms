/*
https://leetcode.com/problems/relative-ranks/description/

Given scores of N athletes, find their relative ranks and the people with the top three highest scores, who will be awarded medals: "Gold Medal", "Silver Medal" and "Bronze Medal".

Example 1:
    Input: [5, 4, 3, 2, 1]
    Output: ["Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"]
    Explanation: The first three athletes got the top three highest scores, so they got "Gold Medal", "Silver Medal" and "Bronze Medal".
    For the left two athletes, you just need to output their relative ranks according to their scores.
Note:
    N is a positive integer and won't exceed 10,000.
    All the scores of athletes are guaranteed to be unique.

*/

package main

import (
  "sort"
  "strconv"
)

func findRelativeRanks(nums []int) []string {
  numsLen := len(nums)

  sorted := make([]int, numsLen, numsLen)
  copy(sorted, nums)
  sort.Ints(sorted)

  gold, silver, bronze := 0, 0, 0
  if numsLen > 0 {
    gold = sorted[numsLen-1]
  }
  if numsLen > 1 {
    silver = sorted[numsLen-2]
  }
  if numsLen > 2 {
    bronze = sorted[numsLen-3]
  }

  res := make([]string, numsLen, numsLen)
  for i, n := range nums {
    if n == gold && numsLen > 0 {
      res[i] = "Gold Medal"
    } else if n == silver && numsLen > 1 {
      res[i] = "Silver Medal"
    } else if n == bronze && numsLen > 2 {
      res[i] = "Bronze Medal"
    } else {
      res[i] = strconv.Itoa(numsLen - sort.SearchInts(sorted, n))
    }
  }

  return res
}

func main() {

}
