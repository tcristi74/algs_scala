package general

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

object leet_1_twosum {

  def main(args: Array[String]) {

    //val nums = Array(1,2,7,11,15)
    val nums = Array(0, 4, 3, 0)

    val s = 0 //9
    val output = twoSum(nums, s)
    println(output.toList)
  }

  def twoSum(nums: Array[Int], target: Int): Array[Int] = {

    val m1: mutable.Map[Int, Int] = mutable.Map.empty
    for (x <- 0 until nums.length if target - nums(x) >= 0) {
      m1 += (target - nums(x) -> x)
    }

    val ar: ArrayBuffer[Int] = ArrayBuffer.empty

    for (x <- 0 until nums.length if m1.contains(nums(x)) && x != m1(nums(x)) && ar.length == 0) {
      ar += m1(nums(x))
      ar += x
    }
    ar.toArray
  }


}
