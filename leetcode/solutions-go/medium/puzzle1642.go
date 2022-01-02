// https://leetcode.com/problems/furthest-building-you-can-reach/

package main

import (
  "container/heap"
  "fmt"
)

type IntHeap []int

func (h IntHeap) Len() int           { return len(h) }
func (h IntHeap) Less(i, j int) bool { return h[i] < h[j] }
func (h IntHeap) Swap(i, j int)      { h[i], h[j] = h[j], h[i] }

func (h *IntHeap) Push(x interface{}) {
  *h = append(*h, x.(int))
}

func (h *IntHeap) Pop() interface{} {
  old := *h
  n := len(old)
  x := old[n-1]
  *h = old[0 : n-1]
  return x
}

func furthestBuilding(heights []int, bricks int, ladders int) int {
  q := &IntHeap{}
  heap.Init(q)

  for i := 1; i < len(heights); i++ {
    d := heights[i] - heights[i-1]
    if d > 0 {
      heap.Push(q, d)
    }
    if q.Len() > ladders {
      bricks -= heap.Pop(q).(int)
    }
    if bricks < 0 {
      return i - 1
    }
  }
  return len(heights) - 1
}

func main() {
  fmt.Println(furthestBuilding([]int{4, 2, 7, 6, 9, 14, 12}, 5, 1))
  fmt.Println(furthestBuilding([]int{4, 12, 2, 7, 3, 18, 20, 3, 19}, 10, 2))
  fmt.Println(furthestBuilding([]int{14, 3, 19, 3}, 17, 0))
}
