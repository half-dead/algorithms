/*
https://leetcode.com/problems/group-anagrams/description/

Given an array of strings, group anagrams together.

For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"],
Return:

[
  ["ate", "eat","tea"],
  ["nat","tan"],
  ["bat"]
]
Note: All inputs will be in lower-case.
*/
package main

import (
  "fmt"
  "sort"
  "strconv"
)

func groupAnagrams(strs []string) [][]string {
  dict := make(map[string][]string, 0)

  for _, str := range strs {
    stat := make([]int, 26)
    for _, c := range str {
      stat[int(c-'a')]++
    }

    hash := ""
    for i, c := range stat {
      if c != 0 {
        hash += strconv.Itoa(c) + string(byte(i+'a'))
      }
    }

    if arr, ok := dict[hash]; !ok {
      dict[hash] = []string{str}
    } else {
      dict[hash] = append(arr, str)
    }
  }

  return toSlice(dict)
}

func toSlice(dict map[string][]string) [][]string {
  res := make([][]string, len(dict))
  i := 0
  for _, v := range dict {
    res[i] = v
    i++
  }
  return res
}

// ///////////////////////////////////////////////////////////////////////////
type p049_sortSolution int

func (p049_sortSolution) groupAnagrams(strs []string) [][]string {
  dict := make(map[string][]string, 0)

  for _, str := range strs {
    bs := byteSlice(str)
    sort.Sort(bs)

    hash := string(bs)
    if arr, ok := dict[hash]; !ok {
      dict[hash] = []string{str}
    } else {
      dict[hash] = append(arr, str)
    }
  }

  return toSlice(dict)
}

type byteSlice []byte

func (p byteSlice) Len() int           { return len(p) }
func (p byteSlice) Less(i, j int) bool { return p[i] < p[j] }
func (p byteSlice) Swap(i, j int)      { p[i], p[j] = p[j], p[i] }

func main() {
  fmt.Println(groupAnagrams([]string{
    "eat", "ate", "tea", "nat", "tan", "bat",
  }))

  var p p049_sortSolution
  ans := p.groupAnagrams([]string{
    "eat", "ate", "tea", "nat", "tan", "bat",
  })
  fmt.Println(ans)
}
