package general

import scala.collection.mutable.ArrayBuffer

object repeated_substring_pattern_lt459 {
  def main(args:Array[String]): Unit ={
     val s: String="abcabcabc"
    val x = repeatedSubstringPattern(s)
    println(x)
  }

  def repeatedSubstringPattern(s: String): Boolean = {
    val l =s.length
    var retVal = false
    if (l>=2) {
      val dv = findDivision(l)
      for (i <- dv if retVal == false) {
        val pattern = s.substring(0, i)
        var start = i
        var ok = true
        for (_ <- 1 until l / i if ok) {
          ok = pattern == s.substring(start, start + i)
          start = start + i
        }
        if (ok) {
          println(i)
          retVal = true
        }
      }
    }
    retVal
  }

  def findDivision(no:Int) :ArrayBuffer[Int] = {
    val ar:ArrayBuffer[Int] = ArrayBuffer.empty
    for(x<-1 to no/2){
      if (no%x==0){
        ar+=x
      }
    }
    ar
  }
}
