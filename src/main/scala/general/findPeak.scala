package general

object findPeak {
  def main(args:Array[String]): Unit ={
    //find if a string has a peak
    //val ar: Array[Int] = Array(1,3,4,7,4,9,10,56,46,88,99,5,44)
    val ar: Array[Int] = Array(1,3,4,7,9,10,56,7)
    val ret =peakExists(ar,0,ar.length-1)
    println(ret)
  }

  def peakExists(ar:Array[Int],l:Int,r:Int):Boolean={
    val middle  = (l+r)/2
    if (l==r) false
    else{
      middle match {
        case m if ar(m)>ar(l) && ar(m)>ar(r) =>true
        case m =>
          val ex = peakExists(ar,l,m)
          ex match {
            case true => true
            case _ => peakExists(ar,m+1,r)
          }
      }
    }
  }


}
