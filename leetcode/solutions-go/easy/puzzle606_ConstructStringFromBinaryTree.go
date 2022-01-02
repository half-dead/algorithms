/*
https://leetcode.com/problems/construct-string-from-binary-tree/description/

You need to construct a string consists of parenthesis and integers from a binary tree with the preorder traversing way.

The null node needs to be represented by empty parenthesis pair "()". And you need to omit all the empty parenthesis pairs that don't affect the one-to-one mapping relationship between the string and the original binary tree.

    Example 1:
    Input: Binary tree: [1,2,3,4]
           1
         /   \
        2     3
       /
      4
    Output: "1(2(4))(3)"
    Explanation: Originallay it needs to be "1(2(4)())(3()())",
    but you need to omit all the unnecessary empty parenthesis pairs.
    And it will be "1(2(4))(3)".
Example 2:
    Input: Binary tree: [1,2,3,null,4]
           1
         /   \
        2     3
         \
          4
    Output: "1(2()(4))(3)"
    Explanation: Almost the same as the first example,
    except we can't omit the first parenthesis pair to break the one-to-one mapping relationship between the input and the output.

*/

package main

import (
  "bytes"
  "fmt"
  "strconv"
)

func tree2str(t *TreeNode) string {
  b := &bytes.Buffer{}
  tree2Bytes(t, b)
  return b.String()
}

func tree2Bytes(t *TreeNode, b *bytes.Buffer) {
  if t == nil {
    return
  }
  b.WriteString(strconv.Itoa(t.Val))
  if t.Left != nil {
    b.WriteByte('(')
    tree2Bytes(t.Left, b)
    b.WriteByte(')')
  } else if t.Right != nil {
    b.WriteString("()")
  }
  if t.Right != nil {
    b.WriteByte('(')
    tree2Bytes(t.Right, b)
    b.WriteByte(')')
  }
}

type p606_RawSolution int

func (p606_RawSolution) tree2str(t *TreeNode) string {
  if t == nil {
    return ""
  }

  res := strconv.Itoa(t.Val)
  if t.Left != nil {
    res += "(" + tree2str(t.Left) + ")"
  } else if t.Right != nil {
    res += "()"
  }
  if t.Right != nil {
    res += "(" + tree2str(t.Right) + ")"
  }
  return res
}

func main() {
  fmt.Println(tree2str(NewTreeNodeFromString("[1,2,3,4,5,6,7,8,9,10,11,12,null, 13,14,15]")))
}
