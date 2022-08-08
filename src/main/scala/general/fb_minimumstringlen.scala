package general

/*You are given two strings s and t. You can select any substring of string s and rearrange the characters of the selected substring. Determine the minimum length of the substring of s such that string t is a substring of the selected substring.
Signature
int minLengthSubstring(String s, String t)
Input
s and t are non-empty strings that contain less than 1,000,000 characters each
Output
Return the minimum length of the substring of s. If it is not possible, return -1
Example
s = "dcbefebce"
t = "fd"
output = 5
Explanation:
  Substring "dcbef" can be rearranged to "cfdeb", "cefdb", and so on. String t is a substring of "cfdeb". Thus, the minimum length required is 5.*/
object fb_minimumstringlen {

  var tMap: scala.collection.immutable.Map[Char, Int] = Map.empty

  def main(args: Array[String]) :Unit={
    // Call minLengthSubstring() with test cases here
    var tMap2 = Map('u' -> 55)

    for ((k, v) <- tMap2) {
      println(k, v)
    }

    val s = "dcbefebdefecbeftf"
    val t = "fd"
    val ret = minLengthSubstring(s, t)
    println(ret)
  }

  def minLengthSubstring(s: String, t: String): Int = {
    // Write your code here
    var myMinStringLen = Int.MaxValue
    //var tMap: scala.collection.immutable.Map[Char,Int] =Map.empty
    val tSet: scala.collection.immutable.Set[Char] = t.toSet
    for (i <- 0 to (s.length - 1)) {
      if (tSet.contains(s(i))) {
        //needs to check in Map
        if (tMap.contains(s(i))) {
          tMap -= s(i)
          tMap += (s(i) -> i)
        }
        else {
          tMap += (s(i) -> i)
          if (tMap.size == t.length) {
            // check the distance between the smallest and largest
            val x = findDistanceInMapvalues(tMap)
            myMinStringLen = myMinStringLen min x._1
            tMap -= x._2
          }
        }

      }
    }
    myMinStringLen
  }


  def findDistanceInMapvalues(myMap: Map[Char, Int]): (Int, Char) = {
    var myMin: Int = Int.MaxValue
    var myMax: Int = -1
    var myMinChar: Char = 'x'
    for ((k, v) <- myMap) {
      myMin = myMin.min(myMap(k))
      if (myMin == myMap(k)) {
        myMinChar = k
      }
      myMax = myMax.max(myMap(k))
    }

    (myMax - myMin + 1, myMinChar)
  }
}
