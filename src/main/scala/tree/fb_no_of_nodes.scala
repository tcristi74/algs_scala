package tree

object fb_no_of_nodes {

  case class TreeNode(value: Int, var left: TreeNode = null, var right: TreeNode = null)

  def main(args: Array[String]): Unit = {

    val tn: TreeNode = TreeNode(value = 8)
    tn.left = TreeNode(3)
    tn.right = TreeNode(10)
    tn.left.left = TreeNode(1)
    tn.left.right = TreeNode(6, left = TreeNode(4), right = TreeNode(7))
    tn.right.right = TreeNode(14, left = TreeNode(13))
    val noNodes = get_node_count(tn)
    println(noNodes)
    require(noNodes == 4)
  }


  def get_node_count(root: TreeNode): Int = {
    if (root.left == null && root.right == null) 0
    else {
      readNode(root, 1)
    }
  }

  def readNode(node: TreeNode, depth: Int): Int = {
    if (node == null) depth - 1
    else {
      if (node.left == null && node.right == null) depth
      else {
        val d1 = readNode(node.left, depth + 1)
        val d2 = readNode(node.right, depth + 1)
        d1 max d2
      }
    }
  }

}
