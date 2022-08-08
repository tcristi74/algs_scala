package general

object leet_433_min_gen_mutation {

  def main(args: Array[String]) {

    val startGene: String = "AACCGGTT"
    val endGene: String = "AAACGGTA"
    val bank: Array[String] = Array("AACCGATT", "AACCGATA", "AAACGATA", "AAACGGTA")


    val output = minMutation(startGene, endGene, bank)
    println(output)

  }

  def minMutation(start: String, end: String, bank: Array[String]): Int = {
    if (!bank.contains(end)) return -1
    //get all changes between start and end
    // 2-> (C->A), 7->(T->A), 0->(T->A)
    var changes: IndexedSeq[Tuple3[Int, Char, Char]] = for (i <- 0 until start.length if start(i) != end(i))
      yield (i, start(i), end(i))
    var seek: Boolean = true
    var tStart = start
    var transf: Int = 0
    while (seek) {
      var oneChangeArray = getOneChange(tStart, bank)
      var gotchange: IndexedSeq[(Int, Char, Char)] =
        for {x <- changes
             if oneChangeArray.count(p => {
               p(x._1) != tStart(x._1) && tStart(x._1) == x._2 && p(x._1) == x._3
             }) == 1
             }
        yield x
      //implement change
      if (gotchange.length > 0) {
        transf += 1
        tStart = (tStart.substring(0, gotchange(0)._1) + gotchange(0)._3 + (if (gotchange(0)._1 < tStart.length - 1) tStart.substring(gotchange(0)._1 + 1) else "")).toString
        changes = changes.filter(p => p._1 != gotchange(0)._1)
        seek = tStart != end
        if (changes.length == 0 && tStart != end) {
          transf = -1
          seek = false
        }
      }
      else {
        seek = false
        transf = -1
      }
    }
    transf
  }


  def getOneChange(start: String, ar: Array[String]): Array[String] = {
    ar.filter(p => {
      (for (x <- 0 until start.length if start(x) != p(x)) yield x).length == 1
    })
  }
}
