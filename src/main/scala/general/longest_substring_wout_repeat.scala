package general

case object prob3{

  def main(args: Array[String]): Unit = {

    var tMap: scala.collection.immutable.Map[Char,Int] =Map('u'->1)


    var tMap2=Map('u'->55)

    for ((k,v)<-tMap2){
      println(k,v)
    }

    val str = "this is anice stringgg because iysssss the bestttt ok"
    val subs:Int = longest_substring_wout_repeat.lengthOfLongestSubstring(str)
    println(subs)
  }
}

object longest_substring_wout_repeat {
  def lengthOfLongestSubstring(s: String): Int = {
    var maxval:Int=0
    var mtemp:Int=0
    var tstr :String=""

    for (c <-s){
      if (!tstr.contains(c)){
        mtemp+=1
        tstr +=c
      }
      else{
        maxval = math.max(maxval,mtemp)
        tstr=tstr.split(c) match {
          case x if x.length==2 => x(1)+c
          case _ => c.toString
        }
        mtemp=tstr.length
      }
    }
    maxval = math.max(maxval,mtemp)
    maxval
  }

}
