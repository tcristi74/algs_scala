package mathe
//bitwise
/*
Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
You must implement a solution with a linear runtime complexity and use only constant extra space.
*/


object single_number_136 {

  def main(args:Array[String]): Unit ={
    val arr = Array(1, 2, 5, 4, 6, 8, 9, 2, 1, 4, 5, 8, 9)
    println(singleNumber(arr))
  }

  def singleNumber(nums: Array[Int]): Int =
    nums.reduce((a,b)=> a ^ b)

}
