package general

import scala.collection.mutable.ArrayBuffer

object backt_gen_paranthesis_leet22 {

  //Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
  //Input: n = 3
  //Output: ["((()))","(()())","(())()","()(())","()()()"]

  def main(args: Array[String]) {
    val n: Int = 3
    val ar: ArrayBuffer[String] = ArrayBuffer.empty
    val output = gen(n, n, "", ar)
    println(output)

  }


  def gen(lp: Int, rp: Int, body: String, bodies: ArrayBuffer[String]): List[String] = {
    println(body)
    if (lp + rp == 0) {
      if (bodyIsCorrect(body)) {
        bodies += body
      }
    }
    else {
      if (lp > 0) {
        gen(lp - 1, rp, body + "(", bodies)
      }
      if (rp > 0) {
        gen(lp, rp - 1, body + ")", bodies)
      }
    }
    bodies.toList
  }

  def bodyIsCorrect(body: String): Boolean = {
    var x: Int = 0
    for (c <- body if x >= 0) {
      if (c == '(')
        x += 1
      else {
        x -= 1
      }
    }
    x == 0
  }

}
