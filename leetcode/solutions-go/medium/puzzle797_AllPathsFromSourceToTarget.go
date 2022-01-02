/*
https://leetcode.com/problems/all-paths-from-source-to-target/description/

Given a directed, acyclic graph of N nodes.  Find all possible paths from node 0 to node N-1, and return them in any order.

The graph is given as follows:
  the nodes are 0, 1, ..., graph.length - 1.  graph[i] is a list of all nodes j for which the edge (i, j) exists.

Example:
  Input: [[1,2], [3], [3], []]
  Output: [[0,1,3],[0,2,3]]
  Explanation: The graph looks like this:
  0--->1
  |    |
  v    v
  2--->3
  There are two paths: 0 -> 1 -> 3 and 0 -> 2 -> 3.
Note:
  The number of nodes in the graph will be in the range [2, 15].
  You can print different paths in any order, but you should keep the order of nodes inside one path.
 */

package main

import "fmt"

func allPathsSourceTarget(graph [][]int) [][]int {
  res := &[][]int{}
  dfs797(graph, 0, &[]int{}, res)
  return *res
}

func dfs797(graph [][]int, start int, current *[]int, res *[][]int) {
  *current = append(*current, start)
  if start == len(graph)-1 {
    copied := make([]int, len(*current))
    copy(copied, *current)
    *res = append(*res, copied)
    return
  }
  for _, n := range graph[start] {
    dfs797(graph, n, current, res)
    *current = (*current)[:len(*current)-1]
  }
}

func main() {
  fmt.Println(allPathsSourceTarget([][]int{{1, 2}, {3}, {3}, {}}))
}
