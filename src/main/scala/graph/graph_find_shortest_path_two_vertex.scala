package graph

import scala.collection.mutable.Queue

object graph_find_shortest_path_two_vertex {

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
    edges +:= Array(5, 10)

    val output = shortestPath(9, 7, edges)
    println(output)
  }

  def shortestPath(start: Int, end: Int, edges: Array[Array[Int]]): Int = {
    var parsed: Set[Int] = Set(start)
    val q: Queue[(Int, Int)] = Queue.empty
    var pathLen: Int = 0
    var pathFound: Boolean = false
    q.enqueue(start -> 0)
    while (!q.isEmpty && !pathFound) {
      val d = q.dequeue()
      if (d._1 == end) {
        pathLen = d._2
        pathFound = true
      }
      else {
        val vert1: Array[Int] = for (e <- edges if e.contains(d._1)) yield (if (e(0) == d._1) e(1) else e(0))
        for (v <- vert1) {
          if (!parsed(v)) {
            q.enqueue(v -> (d._2 + 1))
            parsed += v
          }
        }
      }
    }
    if (pathFound) pathLen else Int.MaxValue
  }
}
