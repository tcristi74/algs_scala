package tree

import scala.collection.mutable.Queue

object bin_tree_checkidentity_leet_100 {

  case class TreeNode(value: Int, var left: TreeNode = null, var right: TreeNode = null)

  def main(args: Array[String]) {

    val tn = TreeNode(value = 1)
    tn.left = TreeNode(2)
    tn.right = TreeNode(3)
    /*
    tn.left.left = TreeNode(1)
    tn.left.right = TreeNode(6,left = TreeNode(4),right = TreeNode(7))
    tn.right.right = TreeNode(14,left = TreeNode(12))
*/

    val tn2 = TreeNode(value = 1)
    tn2.left = TreeNode(2)
    tn2.right = TreeNode(3)
    /*
    tn2.left.left = TreeNode(1)
    tn2.left.right = TreeNode(6,left = TreeNode(4),right = TreeNode(7))
    tn2.right.right = TreeNode(14,left = TreeNode(12))
*/

    val output = isSameTree(tn, tn2)
    println(output)


  }

  /**
   * Definition for a binary tree node.
   * class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
   * var value: Int = _value
   * var left: TreeNode = _left
   * var right: TreeNode = _right
   * }
   */

  def isSameTree(p: TreeNode, q: TreeNode): Boolean = {

    val st1: collection.mutable.Queue[TreeNode] = Queue.empty
    val st2: collection.mutable.Queue[TreeNode] = Queue.empty
    st1.enqueue(p)
    st2.enqueue(q)
    var isEqual: Boolean = true
    while (!st1.isEmpty && !st2.isEmpty && isEqual) {
      var x1 = st1.dequeue()
      var x2 = st2.dequeue()
      isEqual = (x1.value == x2.value && x1.left == x2.left && x1.right == x2.right)
      if (isEqual) {
        if (x1.left != null) st1.enqueue(x1.left)
        if (x1.right != null) st1.enqueue(x1.right)
        if (x2.left != null) st2.enqueue(x2.left)
        if (x2.right != null) st2.enqueue(x2.right)
      }
    }
    isEqual
  }

}
