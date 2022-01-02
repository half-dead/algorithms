/*
https://leetcode.com/problems/minimum-size-subarray-sum/description/

Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s.
If there isn't one, return 0 instead.

For example, given the array [2,3,1,2,4,3] and s = 7,
the subarray [4,3] has the minimal length under the problem constraint.
click to show more practice.

More practice:
  If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n).
 */

package main

import (
  "fmt"
)

// couldn't figure out an O(n log n) solution, STUPID

func minSubArrayLen(s int, nums []int) int {
  head, sum, res := 0, 0, 0
  for i := 0; i < len(nums); i++ {
    sum += nums[i]
    for ; sum >= s && head <= i; head ++ {
      size := i - head + 1
      if res == 0 || res > size {
        res = size
      }
      sum -= nums[head]
    }
  }
  return res
}

func main() {
  fmt.Println(minSubArrayLen(7, []int{2, 3, 1, 2, 4, 3}))
}

/*
  TODO try to understand this solution next time

  Now let’s move on to the O(nlogn) solution. Well, this less efficient solution is far more
  difficult to come up with. The idea is to first maintain an array of accumulated summations
  of elements in nums. Specifically, for nums = [2, 3, 1, 2, 4, 3] in the problem statement,
  sums = [0, 2, 5, 6, 8, 12, 15]. Then for each element in sums, if it is not less than s,
  we search for the first element that is greater than sums[i] - s (in fact, this is just
  what the upper_bound function does) in sums using binary search.

  Let’s do an example. Suppose we reach 12 in sums, which is greater than s = 7.
  We then search for the first element in sums that is greater than sums[i] - s = 12 - 7 = 5
  and we find 6. Then we know that the elements in nums that correspond to 6, 8, 12
  sum to a number 12 - 5 = 7 which is not less than s = 7. Let’s check for that: 6 in sums
  corresponds to 1 in nums, 8 in sums corresponds to 2 in nums, 12 in sums corresponds to 4 in nums.
  1, 2, 4 sum to 7, which is 12 in sums minus 5 in sums.

  We add a 0 in the first position of sums to account for cases like nums = [3], s = 3.
*/
