package general

object two_sum_ordered_array_167 {
  //umbers = [2,7,11,15], target = 9

  def main(args:Array[String]): Unit ={
    val nums = Array(-100,-50,-49,1,2,5,7,11,15)
    val k = 9
    val arr= twoSum(nums,k)
    println(arr.toList)
  }

  def twoSum(numbers: Array[Int], target: Int): Array[Int] = {
    var l = 0
    var r=numbers.length-1
    var done:Boolean = false
    //var r_down = true

    while (!done && l<r) {
      done = numbers(l) + numbers(r) == target
      if (!done) {
        if (numbers(l) + numbers(r) > target) {
         // if (r_down) {
            r -= 1
/*
          } else {
            l += 1
            r_down =! r_down
          }
*/
        } else {
//          if (r_down) {
            l += 1
 //           r_down =! r_down
  /*        }
          else {

  */        }
        }

      }

    if (!done) Array.empty[Int] else Array(l+1,r+1)
  }
}
