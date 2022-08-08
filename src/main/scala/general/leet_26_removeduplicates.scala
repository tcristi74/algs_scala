package general

object leet_26_removeduplicates {

  def main(args: Array[String]) {
    // Call areTheyEqual() with test cases here
    //we assume that any array A cn be made identical with Array B if
    var ar1: Array[Int] = Array(1, 2, 9, 9, 3, 4, 4, 7, 7, 6, 8)
    ar1 = Array(1, 1, 2)
    println(ar1.toList)
    val output = removeDuplicates((ar1))
    println(output)
    println(ar1.toList)

  }

  def removeDuplicates(nums: Array[Int]): Int = {
    var k: Int = 0
    var prev = nums(0)
    var x: Int = 1
    while (x + k < nums.length - 1) {
      if (prev == nums(x)) {
        k += 1
        moveElements(nums, x)
      }
      else {
        prev = nums(x)
        x += 1

      }
    }
    k
  }


  def moveElements(nums: Array[Int], index: Int) {
    for (x <- index until nums.length - 1) {
      nums(x) = nums(x + 1)
    }
    nums(nums.length - 1) = 0
  }

}
