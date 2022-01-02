/*
https://leetcode.com/problems/swap-nodes-in-pairs/description/

Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
*/

package main

import (
  "fmt"
  "strconv"
)

func swapPairs(head *ListNode) *ListNode {
  dummyHead := &ListNode{Next: head}
  current := dummyHead

  for current.Next != nil && current.Next.Next != nil {
    left, right := current.Next, current.Next.Next
    left.Next, right.Next = right.Next, left
    current.Next = right
    current = current.Next.Next
  }

  return dummyHead.Next
}

func main() {
  listNode := NewListNodeFromIntSlice([]int{0, 1, 2, 3, 4, 5, 6, 7, 8, 9})
  PrettyPrintListNode(listNode)
  PrettyPrintListNode(swapPairs(listNode))
}

// copied from ../structs.go
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
