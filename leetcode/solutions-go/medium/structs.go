package main

import (
  "fmt"
  "strconv"
)

type ListNode struct {
  Val  int
  Next *ListNode
}

func NewListNodeFromIntSlice(vals []int) *ListNode {
  var head, prev *ListNode
  for _, v := range vals {
    if prev == nil {
      prev = &ListNode{v, nil}
      head = prev
    } else {
      prev.Next = &ListNode{v, nil}
      prev = prev.Next
    }
  }
  return head
}

func PrettyPrintListNode(node *ListNode) {
  fmt.Print("[")
  for node != nil {
    fmt.Print(strconv.Itoa(node.Val))
    if node.Next != nil {
      fmt.Print(" -> ")
    }
    node = node.Next
  }
  fmt.Println("]")
}

type TreeNode struct {
  Val   int
  Left  *TreeNode
  Right *TreeNode
}
