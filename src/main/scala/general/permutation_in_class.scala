package general

import scala.collection.mutable

object permutation_in_class {
  def main(args: Array[String]): Unit = {

    val a = "abca"
    val b = "cbvathis isa abssc i think cb cb is not cbaasa"
    println(checkInclusion(a, b))
  }

  def checkInclusion(s1: String, s2: String): Boolean = {

    if (s1.length > s2.length) false
    else {

      val m: mutable.Map[Char, Int] = mutable.Map.empty
/*      s1.foreach { c =>
        val fi = m.getOrElse(c, 0)
        if (fi == 0)
          m.addOne(c -> 1)
        else
          m.update(c, fi + 1)
      }*/
      for (c <- s1) m.updateWith(c) {
        case Some(n) => Some(n + 1)
        case None => Some(1)
      }


      for (i <- 0 until s1.length) {
        val c = s2(i)
        m.updateWith(c) {
          case Some(n) =>
            val t = n + 1
            if (t == 0) None else Some(t)
          case None => Some(1)
        }
      }

      var m1 = m.clone()

      var slow = 0
      var fast = 0
      var found = false
      while (!found && fast < s2.length) {
        val fi = m1.getOrElse(s2(fast), 0)

        if (fi > 0) {
          found = fast + 1 - slow == s1.length
          m1.update(s2(fast), fi - 1)
          fast += 1
        }
        else {
          slow += 1
          fast = slow
          m1 = m.clone()
        }
      }
      found
    }
  }
}
