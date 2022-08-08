package mathe

object power_of_two_231 {

  def main(args:Array[String]): Unit ={

    val n=100
    println(isPowerOfTwo(n))

  }

  def isPowerOfTwo(n1: Int): Boolean = {
    var n = n1
    if (n == 0)
      return false;

    while (n != 1) {
      if (n % 2 != 0)
        return false;
      n = n / 2;
    }
    true;

  }

}
