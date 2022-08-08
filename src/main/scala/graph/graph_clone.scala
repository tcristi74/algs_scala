package graph

import scala.collection.mutable.Queue

object graph_clone {

  case class Node(value: Int, var nodes: List[Node] = List.empty) {
    override def toString: String = {
      value.toString

    }
  }

  def main(args: Array[String]) {
    val n1: Node = Node(1)
    val n2: Node = Node(2, List(n1))
    val n4: Node = Node(4, List(n1))
    val n3: Node = Node(3, List(n2, n4))
    n1.nodes = n1.nodes :+ n2 :+ n4
    n4.nodes :+= n3
    n2.nodes :+= n3
    val output = cloneGrapf(n1)
    println(output)

  }

  def cloneGrapf(n: Node): Node = {
    val n1: Node = Node(1)
    //val new1 = Node(n1.value)
    //var parsed:Array[Int]  = Array(n1.value)
    val q: Queue[Node] = Queue(n1.nodes: _*)
    var ntemp = n1
    while (!q.isEmpty) {
      ntemp = q.dequeue()
      var nn = Node(ntemp.value)
    }
    n1
  }
}
