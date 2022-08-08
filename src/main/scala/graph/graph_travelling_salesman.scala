package graph

import scala.collection.mutable.Stack

object graph_travelling_salesman {

  case class Node(var parsed: Boolean, var neighb: Array[(Node, Int)] = null)


  def main(args: Array[String]) {

    val a: Node = Node(false)
    val b: Node = Node(false)
    val c: Node = Node(false)
    val d: Node = Node(false)

    a.neighb = Array(b -> 5, c -> 6)
    b.neighb = Array(a -> 5, d -> 5)
    c.neighb = Array(a -> 6, d -> 4)
    d.neighb = Array(c -> 4, b -> 5)

    val output = findShortestDistance(a)
    println(output)

  }

  def findShortestDistance(root: Node): Int = {
    var q: Stack[(Node, Int)] = Stack.empty
    q.push(root -> 0)
    var distance: Int = 0
    while (!q.isEmpty) {
      var np = q.pop()
      distance += np._2
      np._1.parsed = true
      for (nn <- np._1.neighb if !nn._1.parsed) {
        q.push(nn)
      }
    }
    distance
  }

}
