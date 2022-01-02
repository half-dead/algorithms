/*
https://leetcode.com/problems/implement-stack-using-queues/description/

Implement the following operations of a stack using queues.

    push(x) -- Push element x onto stack.
    pop() -- Removes the element on top of the stack.
    top() -- Get the top element.
    empty() -- Return whether the stack is empty.
Notes:
    You must use only standard operations of a queue -- which means only push to back, peek/pop from front, size, and is empty operations are valid.
    Depending on your language, queue may not be supported natively. You may simulate a queue by using a list or deque (double-ended queue), as long as you use only standard operations of a queue.
    You may assume that all operations are valid (for example, no pop or top operations will be called on an empty stack).
*/

package main

import "fmt"

type MyStack struct {
  q *underlyingQueue
}

/** Initialize your data structure here. */
func MyStackConstructor() MyStack {
  return MyStack{q: newUnderlyingQueue()}
}

/** Push element x onto stack. */
func (stack *MyStack) Push(x int) {
  nq := newUnderlyingQueue()
  nq.push(x)

  oq := stack.q
  for oq.size() > 0 {
    nq.push(stack.q.pop())
  }
  stack.q = nq
}

/** Removes the element on top of the stack and returns that element. */
func (stack *MyStack) Pop() int {
  return stack.q.pop()
}

/** Get the top element. */
func (stack *MyStack) Top() int {
  return stack.q.peek()
}

/** Returns whether the stack is empty. */
func (stack *MyStack) Empty() bool {
  return stack.q.empty()
}

/**
 * Your MyStack object will be instantiated and called as such:
 * obj := Constructor();
 * obj.Push(x);
 * param_2 := obj.Pop();
 * param_3 := obj.Top();
 * param_4 := obj.Empty();
 */

type underlyingQueue struct {
  mem []int
}

func newUnderlyingQueue() *underlyingQueue {
  p := &underlyingQueue{mem: make([]int, 0, 0)}
  return p
}

func (uq *underlyingQueue) push(x int) {
  uq.mem = append(uq.mem, x)
}

func (uq *underlyingQueue) pop() int {
  top := uq.mem[0]
  if uq.size() == 1 {
    uq.mem = make([]int, 0, 0)
  } else {
    uq.mem = uq.mem[1:]
  }
  return top
}
func (uq *underlyingQueue) peek() int {
  return uq.mem[0]
}

func (uq *underlyingQueue) size() int {
  return len(uq.mem)
}

func (uq *underlyingQueue) empty() bool {
  return uq.size() == 0
}

func main() {
  stack := MyStackConstructor()
  stack.Push(1)
  fmt.Println(stack.Pop())
  fmt.Println(stack.Empty())

}
