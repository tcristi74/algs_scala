package general


object countigourArray {

  def main(args: Array[String]) {
    // Call countSubarrays() with test cases here
    val arr :Array[Int] = Array(3, 4, 1, 6, 2)
    countSubarrays(arr)
  }

  def countSubarrays(arr: Array[Int]) : Array[Int] = {
    // Write your code here
    //val result : mutable.ArrayBuffer[Int]  =ArrayBuffer.empty
    val res = for (i <-0 to arr.length-1)   yield getarrays(i,arr)
    println(res.toList)
    res.toArray

  }

  def getarrays(idx :Int,arr:Array[Int]) :Int = {
    // left
    var retVal :Int= 1
    var tIndex  :Int= idx-1
    while (tIndex>=0 && arr(tIndex)<arr(idx) ){
      retVal+=1
      tIndex -=1
    }
    tIndex  = idx+1
    while (tIndex<arr.length && arr(tIndex)<arr(idx)) {
      retVal+=1
      tIndex +=1
    }
    retVal
  }
}
