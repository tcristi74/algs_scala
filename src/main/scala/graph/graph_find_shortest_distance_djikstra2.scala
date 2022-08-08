package graph

object graph_find_shortest_distance_djikstra2 {

  def main(args: Array[String]): Unit = {
    //create graph
    var graph: Map[(String, String), Int] = Map.empty
    graph += ("S", "A") -> 15
    graph += ("S", "B") -> 10
    graph += ("A", "B") -> 2
    graph += ("A", "C") -> 10
    graph += ("B", "C") -> 5
    graph += ("B", "D") -> 1
    graph += ("D", "C") -> 3

    //shortest path discovered
    var results: Map[String, Int] = Map("S" -> 0)
    var remain: Set[(String, String)] = graph.toArray.map(p => p._1._1 -> p._1._2).toSet

    while (remain.size > 0) {
      val selEdges = getAllAvailableEdges(results, remain, graph)
      println(selEdges)
      //get min
      val cMin = calcMin(selEdges, results)
      results += cMin._1._2 -> cMin._2
      println(cMin)
      //clear available edges
      remain = remain.filter(p => !(results.contains(p._1) && results.contains(p._2)))
    }
    println(results.toList)
  }

  def getAllAvailableEdges(parsed: Map[String, Int], remain: Set[(String, String)], graph: Map[(String, String), Int]): List[((String, String), Int)] = {
    //get all edges from remain related to parsed
    val edges = remain.filter(p => parsed.contains(p._1) && !parsed.contains(p._2))
    graph.filter(p => edges.contains(p._1)).toList
  }

  def calcMin(selEdges: List[((String, String), Int)], results: Map[String, Int]): ((String, String), Int) = {
    var tVal: Int = Int.MaxValue
    var tEdge: (String, String) = null
    for (e <- selEdges if results.contains(e._1._1)) {
      //look for start value
      if (results(e._1._1) + e._2 < tVal) {
        tVal = results(e._1._1) + e._2
        tEdge = e._1
      }
    }
    tEdge -> tVal
  }
}
