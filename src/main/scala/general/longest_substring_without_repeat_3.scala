package general
import scala.collection.mutable

object longest_substring_without_repeat_3 {

  def main(args:Array[String]){
    val s = "abfgcabcbbmnvpla"
    val cnt = lengthOfLongestSubstring(s)
    println(cnt)
  }

  def lengthOfLongestSubstring(s: String): Int = {
    var maxString:Int = 0
    val m: mutable.Map[Char,Int] =mutable.Map.empty

    var l = 0
    var r = 0

    for(i<-0 until s.length){
      if (m.contains(s(i)) && m(s(i))>=l){
        maxString = maxString max r-l
        l = m(s(i))+1
        m.update(s(i),i)
      }
      r+=1
      m.addOne(s(i)->i)
    }
    maxString max r-l
  }

}
