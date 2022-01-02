/*
https://leetcode.com/problems/ransom-note/description/

Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.

Each letter in the magazine string can only be used once in your ransom note.

Note:
You may assume that both strings contain only lowercase letters.

    canConstruct("a", "b") -> false
    canConstruct("aa", "ab") -> false
    canConstruct("aa", "aab") -> true
*/

package main

func canConstruct(ransomNote string, magazine string) bool {
  ransomArray := make([]int, 26)
  magazineArray := make([]int, 26)

  for _, c := range ransomNote {
    ransomArray[int(c-'a')]++
  }
  for _, c := range magazine {
    magazineArray[int(c-'a')]++
  }

  for i, count := range ransomArray {
    if count > magazineArray[i] {
      return false
    }
  }
  return true
}

func main() {

}
