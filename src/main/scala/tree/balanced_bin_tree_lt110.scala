package tree

  class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
    var value: Int = _value
    var left: TreeNode = _left
    var right: TreeNode = _right
  }

object balanced_bin_tree_lt110 {


  def main(args:Array[String])={
    val tree = new TreeNode(3,new TreeNode(9), new TreeNode(20,new TreeNode(15), new TreeNode(7,new TreeNode(3))))
    val res = isBalanced(tree)
    println(res)
  }

  def isBalanced(root: TreeNode): Boolean =
    root match {
      case null => true
      case n =>{
        math.abs(nodeheight(n.left) -nodeheight(n.right))<2 &&
          isBalanced(n.left) && isBalanced(n.right)
      }
    }



  def nodeheight(node:TreeNode,h:Int=0) :Int ={
    node match {
      case null => h
      case n =>
        (nodeheight(n.left,h) max nodeheight(n.right,h))+1
   }
  }

}
