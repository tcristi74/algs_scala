package graph

import scala.collection.mutable

object graph_find_path_ifExists_leet1971 {

  case class Node(value: Int, var nodes: List[Node] = List.empty) {
    override def toString: String = {
      value.toString
    }
  }


  def main(args: Array[String]): Unit = {
    var edges: Array[Array[Int]] = Array.empty
    var source: Int = 0
    var destination: Int = 0

    edges +:= Array(1, 2)
    edges +:= Array(1, 4)
    edges +:= Array(1, 6)
    edges +:= Array(3, 4)
    edges +:= Array(4, 5)
    edges +:= Array(5, 6)
    edges +:= Array(7, 8)
    edges +:= Array(8, 9)

    val output = validPath(9, edges, 1, 2)
    println(output)
  }

  def validPath(n: Int, edges: Array[Array[Int]], source: Int, destination: Int): Boolean = {
    if (n <= 1 || edges.length == 0) false
    else {
      val q: mutable.Queue[Int] = mutable.Queue(source)
      var m: Set[Int] = Set(source)
      //find start index
      var found: Boolean = false
      while (!q.isEmpty && !found) {
        val s1 = q.dequeue()
        val sources = for (e <- edges if e.contains(s1)) yield e
        for (s <- sources) {
          val encVal: Int = if (s(0) == s1) s(1) else s(0)
          if (encVal == destination) found = true
          else {
            if (!m.contains(encVal)) {
              m += encVal
              q.enqueue(encVal)
            }
          }
        }
      }
      found
    }
  }
}
