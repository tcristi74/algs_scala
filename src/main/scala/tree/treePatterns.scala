package tree

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

class treePatterns {

  def cloneTreeNode(root1: TreeNode): TreeNode ={
    root1 match {
      case null =>null
      case _ =>
        new TreeNode(root1.value,
          _left = cloneTreeNode(root1.left),
          _right = cloneTreeNode(root1.right))
    }
  }

  def parseTreeDF(node: TreeNode, lst: ArrayBuffer[Int]): Array[Int] = {
    node match {
      case null => lst.toArray
      case _ => {
        lst append node.value
        parseTreeDF(node.left, lst)
        parseTreeDF(node.right, lst)
        lst.toArray
      }
    }
  }

  def parseTreeBFS(root: TreeNode): scala.collection.mutable.ArrayBuffer[Int] = {
    val retArray: mutable.ArrayBuffer[Int] = mutable.ArrayBuffer.empty
    if (root != null) {
      val q: mutable.Queue[TreeNode] = mutable.Queue.empty
      q.enqueue(root)
      while (!q.isEmpty) {
        val node = q.dequeue()
        retArray += node.value
        if (node.left != null) q.enqueue(node.left)
        if (node.right != null) q.enqueue(node.right)
      }
    }
    retArray
  }

}
