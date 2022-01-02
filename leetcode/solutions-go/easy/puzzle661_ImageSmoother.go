/*
https://leetcode.com/problems/image-smoother/description/

Given a 2D integer matrix M representing the gray scale of an image, you need to design a smoother to make the gray scale of each cell becomes the average gray scale (rounding down) of all the 8 surrounding cells and itself. If a cell has less than 8 surrounding cells, then use as many as you can.

Example 1:
    Input:
    [[1,1,1],
     [1,0,1],
     [1,1,1]]
    Output:
    [[0, 0, 0],
     [0, 0, 0],
     [0, 0, 0]]
    Explanation:
    For the point (0,0), (0,2), (2,0), (2,2): floor(3/4) = floor(0.75) = 0
    For the point (0,1), (1,0), (1,2), (2,1): floor(5/6) = floor(0.83333333) = 0
    For the point (1,1): floor(8/9) = floor(0.88888889) = 0
Note:
    The value in the given matrix is in the range of [0, 255].
    The length and width of the given matrix are in the range of [1, 150].
*/
package main

import "fmt"

func imageSmoother(m [][]int) [][]int {
  rows := len(m)
  cols := len(m[0])

  res := make([][]int, 0)
  for i := 0; i < rows; i++ {
    res = append(res, make([]int, cols))
  }
  for i := 0; i < rows; i++ {
    for j := 0; j < cols; j++ {
      sum, count := 0, 1
      sum += m[i][j]
      left, right, up, down := j-1, j+1, i-1, i+1
      if up >= 0 {
        sum += m[up][j]
        count++
      }
      if down < rows {
        sum += m[down][j]
        count++
      }
      if left >= 0 {
        sum += m[i][left]
        count++
      }
      if right < cols {
        sum += m[i][right]
        count++
      }
      if left >= 0 && up >= 0 {
        sum += m[up][left]
        count++
      }
      if left >= 0 && down < rows {
        sum += m[down][left]
        count++
      }
      if right < cols && up >= 0 {
        sum += m[up][right]
        count++
      }
      if right < cols && down < rows {
        sum += m[down][right]
        count++
      }
      res[i][j] = sum / count
    }
  }
  return res
}

func main() {
  res := imageSmoother([][]int{
    {2, 3, 4},
    {5, 6, 7},
    {8, 9, 10},
    {11, 12, 13},
    {14, 15, 16},
  })

  for _, r := range res {
    fmt.Println(r)
  }
}
