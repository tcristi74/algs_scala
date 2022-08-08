package tree

import scala.collection.mutable
import scala.collection.mutable.{ArrayBuffer, Queue}


object merge_2_bin_tree_617 {

  def main(args:Array[String]): Unit ={
    val t1 :tree.TreeNode = new TreeNode(1,
      _left = new TreeNode(3,
        _left = new TreeNode(5)),
      _right = new TreeNode(2))

    val t2 :tree.TreeNode = new TreeNode(2,
      _left = new TreeNode(1,
        _right = new TreeNode(4)),
      _right = new TreeNode(3,
        _right = new TreeNode(7)))


    val aa = mergeTrees(t1,t2)
    println(aa)

  }
  def mergeTrees(n1: TreeNode, n2:TreeNode): TreeNode= {
    (n1,n2) match {
      case (null,n) => n
      case (n,null) => n
      case (a,b) => {
        new TreeNode(a.value+b.value,mergeTrees(a.left,b.left) ,mergeTrees(a.right,b.right))
      }
    }
  }








}
