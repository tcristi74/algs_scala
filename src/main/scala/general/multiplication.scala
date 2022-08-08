package general

import scala.math.log10
import scala.util.Random

object multiplication {
  def main(args: Array[String]) {
    val lengthNo: Int = 9
    val no1 = new Random().nextLong(math.pow(10, lengthNo).toLong).toString
    val no2 = new Random().nextLong(math.pow(10, lengthNo).toLong).toString
    println(no1, no2)
    val output = getMultiplication(no1, no2)
    println(output)
    println(no1.toLong * no2.toLong)
  }

  val numberPadLeft: (String, Int) => String = (str, ln) => {
    str match {
      case x if x.length >= ln => str
      case x =>
        "".padTo(ln - x.length, '0') + str
    }
  }

  def getMultiplication(no1: String, no2: String): String = {
    val maxLen = no1.length max no2.length
    val log2 = (x: Double) => log10(x) / log10(2.0)
    val closestPowerOfTwo = math.pow(2, log2(maxLen).ceil).toInt
    val no1Padded = numberPadLeft(no1, closestPowerOfTwo)
    val no2Padded = numberPadLeft(no2, closestPowerOfTwo)
    println(no1Padded, no2Padded)
    multiply(no1Padded, no2Padded).toString
  }

  def multiply(no1: String, no2: String): Long = {
    no1.length match {
      case x if x <= 2 => no1.toLong * no2.toLong
      case x => {
        val tup1 = no1.splitAt(no1.length / 2)
        val tup2 = no2.splitAt(no2.length / 2)
        val ac: Long = multiply(tup1._1, tup2._1)
        val bd: Long = multiply(tup1._2, tup2._2)
        val other: Long = multiply((tup1._1.toLong + tup1._2.toLong).toString, (tup2._1.toLong + tup2._2.toLong).toString)
        (ac * math.pow(10, x) + bd + (other - ac - bd) * math.pow(10, x / 2)).toLong
      }
    }
  }

}
