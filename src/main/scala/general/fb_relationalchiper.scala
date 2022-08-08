package general

object fb_relationalchiper {

  def main(args: Array[String]) {
    // Call rotationalCipher() with test cases here
    val startStr = "this is my start string"
    val coded: String = rotationalCipher(startStr, 4)
    val initial: String = rotationalCipher(coded, -4)
    println(startStr)
    println(coded)
    println(initial)

  }

  def rotationalCipher(input: String, rotationFactor: Int): String = {

    var encString: scala.collection.immutable.List[Char] = List.empty
    for (c <- input) {
      encString = (c.toInt + rotationFactor).toChar :: encString
    }
    return encString.mkString("")
  }
}
