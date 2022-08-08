package general

import scala.collection.mutable.Stack

// We don’t provide test cases in this language yet, but have outlined the signature for you. Please write your code below, and don’t forget to test edge cases!
object fb_balance_brakets {

  def main(args: Array[String]) {
    // Call isBalanced() with test cases here
    //val input:String = "({()})"
    val input: String = "({([)]})"
    val output = isBalanced(input)
    println(output)
    //require(output)


  }

  def isBalanced(s: String): Boolean = {
    // define three stacks
    //val sCurly :Stack[Int] = Stack.empty
    //val sSquare :Stack[Int] = Stack.empty
    //val sRound :Stack[Int] = Stack.empty
    //    val input:String = "({()})"

    val stk: Stack[Char] = Stack.empty

    var isGood: Boolean = true
    for (c <- s) {

      if (c == '{' || c == '[' || c == '(') {
        stk.push(c)
      }
      if (c == '}' || c == ']' || c == ')') {
        val tchar = stk.pop
        isGood &&= (tchar match {
          case '{' if c == '}' => true
          case '[' if c == ']' => true
          case '(' if c == ')' => true
          case _ => false
        })
      }
      if (!isGood) return false

    }
    isGood
  }
}
