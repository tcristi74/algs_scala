package general

import scala.collection.immutable.SortedSet

/*Given an unsorted integer array nums, return the smallest missing positive integer.
You must implement an algorithm that runs in O(n) time and uses constant extra space.
Input: nums = [1,2,0]
Output: 3*/
object first_missing_Positive {
  def main(args:Array[String]): Unit ={

    val nums = Array(3,4,8,-1,1,2,6,5)
    //val nums = Array(0)
    val output = firstMissingPositive2(nums)
    println(output)
  }


  def firstMissingPositive(nums: Array[Int]): Int = {

    //insert into a sortedset
    var ss:SortedSet[Int] = SortedSet.empty[Int]

    for(el<-nums if el>0){
      ss +=el
    }
    ss match {
      case x if x.size==0 =>1
      case x if x.firstKey>1 => 1
      case _ => {
          var start = ss.firstKey
          while (ss.size>0 && ss.firstKey==start){
            start = ss.firstKey+1
            ss -= ss.firstKey
          }
          start
      }
    }
  }

  def firstMissingPositive2(nums: Array[Int]): Int = {


    def swap(i: Int, j: Int): Unit = {
      val tmp = nums(i)
      nums(i) = nums(j)
      nums(j) = tmp
    }

    var i = 0
    while (i < nums.size) {
      if (nums(i) >= 1 && nums(i) <= nums.size && nums(i) != nums(nums(i)-1)) {
        swap(i, nums(i) - 1)
      } else {
        i += 1
      }
    }

    for (i <- 0 until nums.size) {
      if (nums(i) != i + 1) return i + 1
    }
    nums.size + 1

  }



}
