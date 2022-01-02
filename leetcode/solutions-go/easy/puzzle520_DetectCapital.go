/*
https://leetcode.com/problems/detect-capital/description/

Given a word, you need to judge whether the usage of capitals in it is right or not.

We define the usage of capitals in a word to be right when one of the following cases holds:

    All letters in this word are capitals, like "USA".
    All letters in this word are not capitals, like "leetcode".
    Only the first letter in this word is capital if it has more than one letter, like "Google".
Otherwise, we define that this word doesn't use capitals in a right way.
Example 1:
    Input: "USA"
    Output: True
Example 2:
    Input: "FlaG"
    Output: False
Note: The input will be a non-empty word consisting of uppercase and lowercase latin letters.
*/

package main

func detectCapitalUse(word string) bool {
  uppers := 0
  upperBeginning := word[0] >= 'A' && word[0] <= 'Z'

  for _, c := range word {
    if c >= 'A' && c <= 'Z' {
      uppers++
    }
  }

  return uppers == len(word) || uppers == 0 || (upperBeginning && uppers == 1)

}

func main() {

}
