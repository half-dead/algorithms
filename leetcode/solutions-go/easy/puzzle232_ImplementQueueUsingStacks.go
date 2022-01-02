/*
https://leetcode.com/problems/implement-queue-using-stacks/description/

Implement the following operations of a queue using stacks.

    push(x) -- Push element x to the back of queue.
    pop() -- Removes the element from in front of queue.
    peek() -- Get the front element.
    empty() -- Return whether the queue is empty.
Notes:
    You must use only standard operations of a stack -- which means only push to top, peek/pop from top, size, and is empty operations are valid.
    Depending on your language, stack may not be supported natively. You may simulate a stack by using a list or deque (double-ended queue), as long as you use only standard operations of a stack.
    You may assume that all operations are valid (for example, no pop or peek operations will be called on an empty queue).

*/

package main

type MyQueue struct {
  s *underlyingStack
}

/** Initialize your data structure here. */
func Constructor() MyQueue {
  return MyQueue{
    s: newUnderlyingStack(),
  }
}

/** Push element x to the back of queue. */
func (q *MyQueue) Push(x int) {
  ns := newUnderlyingStack()
  ns.push(x)

  os := q.s
  ts := newUnderlyingStack()
  for os.size() > 0 {
    ts.push(os.pop())
  }

  for ts.size() > 0 {
    ns.push(ts.pop())
  }
  q.s = ns
}

/** Removes the element from in front of queue and returns that element. */
func (q *MyQueue) Pop() int {
  return q.s.pop()
}

/** Get the front element. */
func (q *MyQueue) Peek() int {
  return q.s.top()
}

/** Returns whether the queue is empty. */
func (q *MyQueue) Empty() bool {
  return q.s.empty()
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * obj := Constructor();
 * obj.Push(x);
 * param_2 := obj.Pop();
 * param_3 := obj.Peek();
 * param_4 := obj.Empty();
 */

func newUnderlyingStack() *underlyingStack {
  return &underlyingStack{
    mem:    make([]int, 0, 0),
    cursor: 0,
  }
}

type underlyingStack struct {
  mem    []int
  cursor int
}

func (stack *underlyingStack) push(x int) {
  stack.mem = append(stack.mem, x)
  stack.cursor++
}

func (stack *underlyingStack) pop() int {
  top := stack.top()
  stack.cursor--
  stack.mem = stack.mem[:stack.size()-1]
  return top
}

func (stack *underlyingStack) top() int {
  return stack.mem[stack.cursor-1]
}

func (stack *underlyingStack) size() int {
  return len(stack.mem)
}

func (stack *underlyingStack) empty() bool {
  return stack.size() == 0
}

func main() {
  q := Constructor()
  q.Push(1)
  q.Peek()
}
