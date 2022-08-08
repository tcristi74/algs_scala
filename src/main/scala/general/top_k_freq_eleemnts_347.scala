package general

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

object top_k_freq_eleemnts_347 {
  def main(args: Array[String]): Unit = {
    val nums= Array(1,1,1,1,2,2,2,2,3,3,3,4,4,4,444,44,4,5,6,7,8,8,8,8,8,8)
    val k = 20
    val output= topKFrequent(nums,k)
    println(output.toList)
  }

  def topKFrequent(nums: Array[Int], k: Int): Array[Int] = {
    val ord :Ordering[(Int,Int)] = (x:(Int,Int) , y:(Int,Int)) => x._1 compare y._1
    val q2: mutable.PriorityQueue[(Int,Int)] = mutable.PriorityQueue.empty(ord)
    val groups = nums.groupBy(x=> x)
    groups.foreach{ i=>
      q2.enqueue((i._2.length,i._1))
    }
    var ab = ArrayBuffer.empty[Int]
    if (k<=q2.size) {
      (0 until k).foreach(_ => ab.append(q2.dequeue()._2))
    }
     ab.toArray
  }
}
