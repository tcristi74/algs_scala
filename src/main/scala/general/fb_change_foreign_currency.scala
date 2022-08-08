package general

// We don’t provide test cases in this language yet, but have outlined the signature for you. Please write your code below, and don’t forget to test edge cases!
object fb_change_foreign_currency {

  def main(args: Array[String]) {
    // Call canGetExactChange() with test cases here
    //val denominations = Array(5, 10, 25, 100, 200)
    val denominations = Array(4, 17, 29)
    val targetMoney = 94
    val output = canGetExactChange(targetMoney, denominations)
    println(output)
  }

  def canGetExactChange(targetMoney: Int, denominations: Array[Int]): Boolean = {
    // Write your code here
    /*    var found = false
    for (d <- denominations; if found==false) {
      val newamount = tr
    }
    found*/
    val newArray = denominations.filter(_ <= targetMoney)
    tryFind(targetMoney, newArray)
  }

  def tryFind(amount: Int, denom: Array[Int]): Boolean = {
    var fval = false
    amount match {
      case 0 => fval |= true
      case x if x < 0 => {
        false
      }
      case x if x > 0 => {
        for (d <- denom; if d <= x)
          fval |= tryFind(x - d, denom)
      }
    }
    fval
  }
}
