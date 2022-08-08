package general

object reverse_string_inplace_344 {

  def main(args:Array[String]): Unit ={
    val str = "thisistheend"
    //str.toArray.reverse
    val v = str.toCharArray
    reverseString(v)
    println(v.mkString)

  }

  def reverseString(ar: Array[Char]): Unit = {

    var l = 0
    var r = ar.length-1

    while (l<r){
      val tmp=ar(l)
      ar(l) = ar(r)
      ar(r) = tmp
      l+=1
      r-=1
    }


  }
}
