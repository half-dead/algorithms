/*
https://leetcode.com/problems/keyboard-row/description/

Given a List of words, return the words that can be typed using letters of alphabet on only one row's of American keyboard like the image below.

Example 1:
    Input: ["Hello", "Alaska", "Dad", "Peace"]
    Output: ["Alaska", "Dad"]
Note:
    You may use one character in the keyboard more than once.
    You may assume the input string will only contain letters of alphabet.

*/

package main

import "strings"

var allRows = []string{
  "qwertyuiop",
  "asdfghjkl",
  "zxcvbnm",
}

func findWords(words []string) []string {
  res := make([]string, 0, 10)
  for _, word := range words {
    lowerWord := strings.ToLower(word)
    firstRune := rune(lowerWord[0])

    expectedRow := ""
    for _, row := range allRows {
      if strings.IndexRune(row, firstRune) != -1 {
        expectedRow = row
        break
      }
    }

    if expectedRow != "" {
      fit := true
      for _, r := range lowerWord {
        if strings.IndexRune(expectedRow, r) == -1 {
          fit = false
          break
        }
      }
      if fit {
        res = append(res, word)
      }
    }
  }
  return res
}

func main() {

}
