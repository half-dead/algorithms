/*
https://leetcode.com/problems/task-scheduler/description/

Given a char array representing tasks CPU need to do. It contains capital letters A to Z where different letters represent different tasks.
Tasks could be done without original order. Each task could be done in one interval. For each interval, CPU could finish one task or just be idle.

However, there is a non-negative cooling interval n that means between two same tasks,
there must be at least n intervals that CPU are doing different tasks or just be idle.

You need to return the least number of intervals the CPU will take to finish all the given tasks.

Example 1:
  Input: tasks = ["A","A","A","B","B","B"], n = 2
  Output: 8
  Explanation: A -> B -> idle -> A -> B -> idle -> A -> B.
Note:
  The number of tasks is in the range [1, 10000].
  The integer n is in the range [0, 100].
 */
package main

import (
  "sort"
  "fmt"
  "strconv"
)

type pair struct {
  k byte
  v int
}

func (p pair) String() string {
  return string(p.k) + "=" + strconv.Itoa(p.v)
}

// debug version, will print the execution queue, '-' means idle
func leastIntervalDebugVersion(tasks []byte, n int) int {
  size := len(tasks)
  if n == 0 {
    return size
  }
  group := make(map[byte]int, 26)
  for _, t := range tasks {
    if _, ok := group[t]; ok {
      group[t]++
    } else {
      group[t] = 1
    }
  }

  queue := make([]pair, 0)
  for k, v := range group {
    queue = append(queue, pair{k, v})
  }

  sortFunction := func(i, j int) bool {
    return queue[i].v < queue[j].v
  }

  sort.Slice(queue, sortFunction)

  batch := n + 1
  qIndex := len(queue) - 1
  i := 0

  res := make([]byte, 0)
  for ; size > 0; i++ {
    if qIndex >= 0 && queue[qIndex].v > 0 {
      res = append(res, queue[qIndex].k)
      queue[qIndex].v --
      qIndex--
      size--
      batch--
    } else {
      res = append(res, '-')
      batch --
    }

    if batch == 0 {
      qIndex = len(queue) - 1
      batch = n + 1
      sort.Slice(queue, sortFunction)
    }
  }
  fmt.Println(string(res))
  return i
}

func leastInterval(tasks []byte, n int) int {
  size := len(tasks)
  if n == 0 {
    return size
  }
  queue := make([]int, 26)
  for _, t := range tasks {
    queue[t-'A']++
  }
  sort.Ints(queue)

  batch := n
  qIndex := 25
  i := 0
  for i = 0; size > 0; i++ {
    if qIndex >= 0 && queue[qIndex] > 0 {
      queue[qIndex] --
      qIndex--
      size--
      batch--
    } else {
      batch --
    }

    if batch < 0 {
      qIndex = 25
      batch = n
      sort.Ints(queue)
    }
  }
  return i
}

func main() {
  fmt.Println(leastInterval([]byte("AAAAAABCDEFG"), 2))
  fmt.Println(leastInterval8Ms([]byte("AAAAAABCDEFG"), 2))
}

func leastInterval8Ms(tasks []byte, n int) int {
  if n == 0 {
    return len(tasks)
  }

  rec := [26]int{}
  for _, c := range tasks {
    rec[c-'A']++
  }

  maxRepeatTimes := 0
  for _, n := range rec {
    if n > maxRepeatTimes {
      maxRepeatTimes = n
    }
  }

  // TODO couldn't understand, try next time
  idles := (maxRepeatTimes - 1) * (n + 1)
  for _, n := range rec {
    idles -= min(maxRepeatTimes-1, n)
  }
  return len(tasks) + max(0, idles)
}

func min(a, b int) int {
  if a < b {
    return a
  }
  return b
}

func max(a, b int) int {
  if a > b {
    return a
  }
  return b
}
