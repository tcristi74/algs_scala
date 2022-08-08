package general

object fb_encryptedWords {

  def main(args: Array[String]) {
    // Call findEncryptedWord() with test cases here
    val myString: String = "abcxcba"
    val result = findEncryptedWord(myString)
    require(result == "xbacbca")
  }

  def findEncryptedWord(s: String): String = {
    // Write your code here
    s match {
      case x if x.length == 1 => s
      case x if x.length == 2 => s
      case _m => {
        val middle: Int = if (s.length % 2 == 0) s.length / 2 - 1 else s.length / 2
        val fString: String = s.substring(0, middle - 1)
        s(middle) + findEncryptedWord(s.substring(0, middle)) + findEncryptedWord(s.substring(middle + 1))
      }
    }

  }


}
