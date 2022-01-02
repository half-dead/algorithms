/*
https://leetcode.com/problems/max-area-of-island/description/

Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

Find the maximum area of an island in the given 2D array. (If there is no island, the maximum area is 0.)

Example 1:
    [[0,0,1,0,0,0,0,1,0,0,0,0,0],
     [0,0,0,0,0,0,0,1,1,1,0,0,0],
     [0,1,1,0,1,0,0,0,0,0,0,0,0],
     [0,1,0,0,1,1,0,0,1,0,1,0,0],
     [0,1,0,0,1,1,0,0,1,1,1,0,0],
     [0,0,0,0,0,0,0,0,0,0,1,0,0],
     [0,0,0,0,0,0,0,1,1,1,0,0,0],
     [0,0,0,0,0,0,0,1,1,0,0,0,0]]
    Given the above grid, return 6. Note the answer is not 11, because the island must be connected 4-directionally.
Example 2:
    [[0,0,0,0,0,0,0,0]]
    Given the above grid, return 0.
Note: The length of each dimension in the given grid does not exceed 50.
*/

package main

func maxAreaOfIsland(grid [][]int) int {
  rows := len(grid)
  cols := 0
  if rows > 0 {
    cols = len(grid[0])
  }

  max := 0
  for r := 0; r < rows; r++ {
    for c := 0; c < cols; c++ {
      area := calc(grid, r, c, rows-1, cols-1)
      if area > max {
        max = area
      }
    }
  }
  return max
}

func calc(grid [][]int, r, c int, mr, mc int) int {
  if r < 0 || c < 0 || r > mr || c > mc {
    return 0
  }
  if grid[r][c] == 0 {
    return 0
  }

  area := 1
  grid[r][c] = 0

  area += calc(grid, r+1, c, mr, mc)
  area += calc(grid, r-1, c, mr, mc)
  area += calc(grid, r, c+1, mr, mc)
  area += calc(grid, r, c-1, mr, mc)
  return area
}

func main() {

}
