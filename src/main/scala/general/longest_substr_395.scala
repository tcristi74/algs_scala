package general

import scala.collection.SortedMap
/*
Given a string s and an integer k,
return the length of the longest substring of s such that the frequency of each character in this substring is greater than or equal to k.
 */

case object slongestsubstr395{

  def main(args: Array[String]): Unit = {
    val str = "this is  anice stringgg because iysssss the bestttt ok"
    val k:Int = 2
    val subs:Int = sol395.longestSubstring(str,k)
    println(subs)
  }

}

object sol395 {
  def longestSubstring(s: String, k: Int): Int = {

    var sm:SortedMap[Int,Char] = SortedMap.empty
    var prevLetter :Char = s.head
    var counter = 1
    var insertok = false
    for (c <- s.tail){
      if (c==prevLetter){
        counter+=1
        insertok = counter>=k
      }
      else{
        if (insertok){
          sm+=(counter->prevLetter)
        }
        counter=1
        prevLetter=c
        insertok=false
      }
    }
    if (insertok){
      sm+=(counter->prevLetter)
    }
    if (sm.nonEmpty)  {
      println("char",sm(sm.lastKey))
      sm.lastKey
    }
    else {0}
  }
}


