package general

import scala.collection.mutable.Stack

object fb_reverseOperations {

  case class Listnode(var value: Int, var next: Listnode = null)

  def main(args: Array[String]): Unit = {
    var l = Listnode(1, Listnode(2, Listnode(8, Listnode(9, Listnode(12, Listnode(16))))))
    val output = reverseEven(l)
    println(l)
  }

  def reverseEven(lst: Listnode): Listnode = {
    val retTree: Listnode = Listnode(0)
    var newList = retTree
    var node1 = lst
    val stk: Stack[Int] = Stack.empty
    while (node1 != null) {
      if (node1.value % 2 == 0) {
        stk.push(node1.value)
      } else {
        // do we have something in stack ?
        while (stk.size > 0) {
          newList.next = Listnode(stk.pop())
          newList = newList.next
        }
        newList.next = Listnode(node1.value)
        newList = newList.next
      }
      node1 = node1.next
    }
    while (stk.size > 0) {
      newList.next = new Listnode(stk.pop())
      newList = newList.next
    }
    retTree.next
  }


}
