package backtracking

import scala.collection.mutable.{ArrayBuffer, ListBuffer}

/*Input: s = "a1b2"
  Output: ["a1b2","a1B2","A1b2","A1B2"]*/
object letter_case_permutations_784 {

  def main(args:Array[String]): Unit = {
    val s = "ab1"
    val res:List[String] = letterCasePermutation(s)
    println(res.toList)

  }

  def letterCasePermutation(s: String): List[String] = {

    val res = ListBuffer.empty[String]
    val l = s.toCharArray.filter(p=> !Character.isDigit(p)).length
    val no = math.pow(l,2).toInt
    val strMap = ArrayBuffer.empty[Int]
    for(i<-0 until s.length){
      if (!Character.isDigit(s(i))){
        strMap  +=i
      }
    }
    val bb:ArrayBuffer[Array[Int]] = ArrayBuffer.empty
    val ml = no.toBinaryString.length
    (0 to no).foreach { p =>
      val binPadded = p.toBinaryString.reverse.padTo(ml,'0').reverse
      val binS = binPadded.toCharArray.map(p => p.toString.toInt)
      bb += binS
    }
    val strx = s.toCharArray.map(p=>p.toString)
    for (ii<-0 until bb.length){
      val c = bb(ii).slice(1,bb(ii).length)
      println(c.toList)

      var str2 = strx.clone()
      for(x<- 0 until ml-1; if c(x)==1 ) {
        str2(strMap(x))= str2(strMap(x)).toUpperCase
      }
      res += str2.mkString

    }

    res.toList

  }

}
