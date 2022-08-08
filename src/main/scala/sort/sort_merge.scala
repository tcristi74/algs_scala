package sort

import scala.collection.mutable.ArrayBuffer

object mergesort {
  def main(args: Array[String]): Unit ={
    println("merge sort")
    val arr:List[Int] = List(3,5,2,8,7,1,9,10,6)

    val startIndex :Int= 0
    val endIndex :Int  = arr.length-1
    val newArr =merge(arr,startIndex,endIndex)
    println(finalArr)

   }
   val finalArr : ArrayBuffer[Int]=ArrayBuffer.fill(9)(0)

  def merge(arr:List[Int],start:Int, end:Int) : Unit ={
    if (start<end){
      val middle :Int =start+ (end-start)/2
      merge(arr,start,middle)
      merge(arr, middle+1,end)
      order(arr,start,end,middle )
    }
  }
  def order(arr:List[Int], startIndex:Int,endIndex:Int,middle:Int) = {
    var left:Int = startIndex
    var right:Int = middle+1
    var newIndex :Int = left
    while(left <= middle && right<endIndex){
      if (arr(left)>arr(right)){
        finalArr.update(newIndex,arr(right))
        right+=1
      } else {
        finalArr.update(newIndex,arr(left))
        left+=1
      }
      newIndex+=1
    }

    //add ledft over
    while (left <= middle){
      finalArr.update(newIndex,arr(left))
      left+=1
      newIndex+=1
    }
    //add ledft over
    while (right < endIndex){
      finalArr.update(newIndex,arr(right))
      right+=1
      newIndex+=1
    }

  }
}