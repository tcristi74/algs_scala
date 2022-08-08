package tree

import scala.collection.mutable
import scala.collection.mutable.{ArrayBuffer, HashMap}

object bin_tree_avg_levels_fb {

  case class TreeNode(value: Int, var left: TreeNode = null, var right: TreeNode = null)

  def main(args: Array[String]) = {

    val tn: TreeNode = TreeNode(value = 8)
    tn.left = TreeNode(3)
    tn.right = TreeNode(10)
    tn.left.left = TreeNode(1)
    tn.left.right = TreeNode(6, left = TreeNode(4), right = TreeNode(7))
    tn.right.right = TreeNode(14, left = TreeNode(13))

    val valueList: ArrayBuffer[Int] = ArrayBuffer.empty
    val valuesList = parseTreeDF(tn, valueList)

    val ht: mutable.HashMap[Int, ArrayBuffer[Int]] = mutable.HashMap.empty
    val ht2 = parseTreeIntoMap(tn, 0, ht)

    val avg: mutable.ArrayBuffer[Double] = ArrayBuffer.empty
    for ((k, v) <- ht2) {
      avg += v.reduce((a, b) => a + b).toDouble / v.length
      println(k, v)
    }

    println(avg.toList)

    println(valuesList.toList)
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

  def parseTreeIntoMap(node: TreeNode, level: Int, lst: HashMap[Int, ArrayBuffer[Int]]): HashMap[Int, ArrayBuffer[Int]] = {
    node match {
      case null => lst
      case _ => {
        if (!lst.contains(level)) {
          lst += (level -> ArrayBuffer(node.value))
        }
        else {
          lst(level) += node.value
        }
        parseTreeIntoMap(node.left, level + 1, lst)
        parseTreeIntoMap(node.right, level + 1, lst)
        lst
      }
    }
  }


}
