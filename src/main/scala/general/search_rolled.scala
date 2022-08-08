object seach_rolled extends App {
  println("search, rolled")
  val ar1 = scala.util.Random.nextBytes(10).map(_.toInt).toList.sorted
  val rotations = math.abs(scala.util.Random.nextInt(10))
  println("Rotations",rotations)
  val ret = rotate(ar1, rotations)
  //val ret = List(-112, -75, -17, -16, -16, 48, 94, 125, -122, -118)
  println(ret)
  val rindex: Int = findPoint(ret, 0, (ret.length - 1) / 2, ret.length - 1)
  require(rotations == rindex)
  val myNumber = ret(math.abs(scala.util.Random.nextInt(9)))
  println("NumbertoFind",myNumber)
  val find2 = if (rindex >0 && myNumber >= ret(0) && myNumber <=ret(rindex-1))  findValueIndex(ret, myNumber, 0, rindex / 2, rindex)
  else  findValueIndex(ret, myNumber, rindex, rindex + (ret.length - 1 - rindex) / 2, ret.length - 1)

  println("Index",find2)



  def rotate(ar: List[Int], rotations: Int): List[Int] = {
    if (rotations > 0) {
      rotate(ar.last :: ar.slice(0, ar.length - 1), rotations - 1)
    } else ar
  }

  def findPoint(ar: List[Int], start: Int, middle: Int, end: Int): Int = {
    if (ar(middle) < ar(middle - 1)) {
      middle
    }
    else {
      if (start == middle)
       0
      else {
        if (ar(start) <= ar(middle)) {
          findPoint(ar, middle, middle + (end - middle) / 2, end)
        }
        else {
          findPoint(ar, start, start + (middle - start) / 2, middle)
        }
      }
    }
  }

  def findValueIndex(ar:List[Int], valtofind:Int,start: Int, middle: Int, end: Int):Int={
    if (ar(middle) == valtofind) {
      middle
    }
    else {
      if (start == middle)
        -1
      else {
        if (ar(middle) < valtofind) {
          findValueIndex(ar,valtofind, middle, middle + (end - middle) / 2, end)
        }
        else {
          findValueIndex(ar, valtofind, start, start + (middle - start) / 2, middle)
        }
      }
    }
  }

}