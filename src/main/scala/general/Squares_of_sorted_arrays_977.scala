package general

import scala.collection.mutable

object Squares_of_sorted_arrays_977 {
  def main(args:Array[String]): Unit ={
    val arr:Array[Int] = Array(-4,-1,0,3,10)
    val sortedSquareRoot = sortedSquares(arr)
    println(sortedSquareRoot.toList)
  }
  def sortedSquares(nums: Array[Int]): Array[Int] = {
    //val pq : scala.collection.mutable.PriorityQueue[Int] = mutable.PriorityQueue.empty(Ordering[Int].reverse)
    val pos = for(i<-0 until nums.length) yield math.pow(nums(i),2).toInt
    val pq2 = mutable.PriorityQueue(pos:_*)(Ordering[Int].reverse)
    val aa =  for ( i<-0 until pq2.size ; if !pq2.isEmpty) yield pq2.dequeue()
    aa.toArray
  }

}
