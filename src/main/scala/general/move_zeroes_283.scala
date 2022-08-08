package general

object move_zeroes_283 {
  def main(args:Array[String]): Unit ={
    val nums = Array(0,1,0,0,0,3,12)
    moveZeroes(nums)
    println(nums.toList)
  }

  def moveZeroes(nums: Array[Int]): Unit = {

    var indexZero = -1
    var index = 0
    while (index<=nums.length-1){
      var current = nums(index)
      if (current==0 && indexZero == -1) {
        indexZero = index
      }
      if (indexZero >= 0 && current != 0) {
        nums(indexZero) = current
        nums(index)=0
        index=indexZero+1
        indexZero = -1
      }
      else {
        index+=1
      }

    }
  }

}
