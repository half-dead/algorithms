/*
https://leetcode.com/problems/number-of-boomerangs/description/

Given n points in the plane that are all pairwise distinct, a "boomerang" is a tuple of points (i, j, k)
such that the distance between i and j equals the distance between i and k (the order of the tuple matters).

Find the number of boomerangs. You may assume that n will be at most 500 and coordinates of points are all in the range [-10000, 10000] (inclusive).

Example:
  Input:
  [[0,0],[1,0],[2,0]]

  Output:
  2

Explanation:
  The two boomerangs are [[1,0],[0,0],[2,0]] and [[1,0],[2,0],[0,0]]
 */

package main

import "fmt"

func numberOfBoomerangs(points [][]int) int {
  res := 0
  pLen := len(points)
  for i := 0; i < pLen; i++ {
    dMap := make(map[int]int, pLen)
    for j := 0; j < pLen; j++ {
      if i == j {
        continue
      }
      dMap[dSquare(points[i], points[j])]++
    }
    for distance := range dMap {
      count := dMap[distance]
      if count >= 2 {
        res += count * (count - 1)
      }
    }
  }
  return res
}

func dSquare(a, b []int) int {
  xDis := a[0] - b[0]
  yDis := a[1] - b[1]
  return xDis*xDis + yDis*yDis
}

func main() {
  x := numberOfBoomerangs([][]int{{0, 0}, {1, 0}, {2, 0}})
  fmt.Println(x)
}

func numberOfBoomerangs_ShittySolution(points [][]int) int {
  res := 0
  pLen := len(points)
  for i := 0; i < pLen; i++ {
    for j := i + 1; j < pLen; j++ {
      d1 := dSquare(points[i], points[j])
      for k := j + 1; k < pLen; k++ {
        d2, d3 := dSquare(points[i], points[k]), dSquare(points[j], points[k])
        if d1 == d2 || d1 == d3 || d2 == d3 {
          res += 2
        }
      }
    }
  }
  return res
}
