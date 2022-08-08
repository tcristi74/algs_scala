package tree
import scala.collection.mutable

object bin_tree_max_level {

  case class TreeNode(value: Int, var left: TreeNode = null, var right: TreeNode = null)
/*        8
    3       10
  1   6         14
     4  7    13*/

  def main(args: Array[String]): Unit = {

    val tn: TreeNode = TreeNode(value = 8)
    tn.left = TreeNode(3)
    tn.right = TreeNode(10)
    tn.left.left = TreeNode(1)
    tn.left.right = TreeNode(16, left = TreeNode(4), right = TreeNode(7))
    tn.right.right = TreeNode(14, left = TreeNode(13))
    val noNodes = getMaxPerLevel(tn)
    noNodes.foreach( t=>{
      println(s"Level:${t._1} value: ${t._2}")
    })
  }


  def getMaxPerLevel(node:TreeNode) :mutable.Map[Int,Int] = {
    val ml = mutable.Map[Int,Int](0->node.value)
    val q:  mutable.Queue[(TreeNode,Int)] = mutable.Queue.empty
    q.enqueue(node->0)
    while (!q.isEmpty){
      val nl = q.dequeue()
      val x = ml.get(nl._2) match {
        case Some(x) => x max nl._1.value
        case None => nl._1.value
      }
      ml.update(nl._2, x)
      if (nl._1.left!=null){
        q.enqueue(nl._1.left->(nl._2+1))
      }
      if (nl._1.right!=null){
        q.enqueue(nl._1.right-> (nl._2+1))
      }
    }
    ml
  }
}
