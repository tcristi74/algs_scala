package general

// We don’t provide test cases in this language yet, but have outlined the signature for you. Please write your code below, and don’t forget to test edge cases!
object fb_one_billion_users {

  def main(args: Array[String]) {
    // Call getBillionUsersDay() with test cases here
    //val growthRates :Array[Float]= Array(1.5f)
    val growthRates: Array[Float] = Array(1.1f, 1.2f, 1.3f)
    val output = getBillionUsersDay(growthRates)
    println(output)

  }

  def getBillionUsersDay(arr: Array[Float]): Int = {
    // Write your code here
    var day: Int = 0
    var count: Double = 0
    while (count < 1000000000) {
      count = 0
      for (a <- arr) {
        day += 1
        count += math.pow(a.toDouble, day)
        println(count)
      }
    }
    day
  }
}
