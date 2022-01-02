/*
https://leetcode.com/problems/max-increase-to-keep-city-skyline/description/

In a 2 dimensional array grid, each value grid[i][j] represents the height of a building located there.
We are allowed to increase the height of any number of buildings, by any amount (the amounts can be different for different buildings).
Height 0 is considered to be a building as well.

At the end, the "skyline" when viewed from all four directions of the grid, i.e. top, bottom, left, and right,
must be the same as the skyline of the original grid.
A city's skyline is the outer contour of the rectangles formed by all the buildings when viewed from a distance.
See the following example.

What is the maximum total sum that the height of the buildings can be increased?

Example:
Input: grid = [[3,0,8,4],[2,4,5,7],[9,2,6,3],[0,3,1,0]]
Output: 35
Explanation:
The grid is:
[ [3, 0, 8, 4],
  [2, 4, 5, 7],
  [9, 2, 6, 3],
  [0, 3, 1, 0] ]

The skyline viewed from top or bottom is: [9, 4, 8, 7]
The skyline viewed from left or right is: [8, 7, 9, 3]

The grid after increasing the height of buildings without affecting skylines is:

gridNew = [ [8, 4, 8, 7],
            [7, 4, 7, 7],
            [9, 4, 8, 7],
            [3, 3, 3, 3] ]

Notes:

1 < grid.length = grid[0].length <= 50.
All heights grid[i][j] are in the range [0, 100].
All buildings in grid[i][j] occupy the entire grid cell: that is, they are a 1 x 1 x grid[i][j] rectangular prism.

 */

package main

func maxIncreaseKeepingSkyline(grid [][]int) int {
  r, c := len(grid), len(grid[0])
  mr, mc := make([]int, c), make([]int, r)

  mi, mj := 0, 0
  for i := 0; i < r; i++ {
    maxr := 0
    for j := 0; j < c; j++ {
      if maxr < grid[i][j] {
        maxr = grid[i][j]
      }
    }
    mr[mi] = maxr
    mi++
  }

  for i := 0; i < c; i++ {
    maxc := 0
    for j := 0; j < r; j++ {
      if maxc < grid[j][i] {
        maxc = grid[j][i]
      }
    }
    mc[mj] = maxc
    mj++
  }

  res := 0
  for i := 0; i < r; i++ {
    for j := 0; j < c; j++ {
      res += min807(mr[i], mc[j]) - grid[i][j]
    }
  }
  return res
}

func min807(a, b int) int {
  if a < b {
    return a
  }
  return b
}

func main() {

}
