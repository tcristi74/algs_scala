package general
import scala.collection.mutable
object fb_m_th_smallest_val {

  def main(args: Array[String]): Unit = {

    val arrays: Array[Array[Int]] = Array(Array(1, 3), Array(2, 4, 6), Array(0, 9, 10, 11))
    val output: Option[Int] = getNSmallest2(5, arrays)

    println(output.getOrElse("nope"))
  }

  val customOrdering: Ordering[(Int, Int, Int)] = (x: (Int, Int, Int), y: (Int, Int, Int)) => y._1 compare x._1

  def getNSmallest2(n: Int, arrays: Array[Array[Int]]): Option[Int] = {

    var no: Int = 0
    var picked: Int = 0

    val q2: mutable.PriorityQueue[(Int, Int, Int)] = mutable.PriorityQueue.empty(customOrdering)
    for (x <- arrays.indices if arrays.length > x)
      q2.enqueue((arrays(x)(0), 0, x))

    while (picked < n && q2.nonEmpty) {
      val t = q2.dequeue()
      no = t._1
      picked += 1
      if (t._2 < arrays(t._3).length - 1) {
        q2.enqueue((arrays(t._3)(t._2 + 1), t._2 + 1, t._3))
      }
    }
    picked match {
      case x if x < n || x == 0 => None
      case _ => Some(no)
    }
  }
}
