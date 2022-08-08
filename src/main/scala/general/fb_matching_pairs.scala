package general

// We don’t provide test cases in this language yet, but have outlined the signature for you. Please write your code below, and don’t forget to test edge cases!
object fb_matching_pairs {

  def main(args: Array[String]) {
    // Call matchingPairs() with test cases here
    val s = "abcd"
    val t = "abcd"
    val output = matchingPairs(s, t)
    println(output)
  }

  def matchingPairs(s: String, t: String): Int = {
    // Write your code here
    //count common elements
    //count common one s
    var cnt = 0


    for (i1 <- 0 to s.length - 1; if s(i1) == t(i1)) {
      cnt += 1
    }
    if (cnt == s.length) {
      cnt - 2
    }
    else {

      var r = 0
      for {i1 <- 0 to s.length - 1
           i2 <- 0 to t.length - 1
           if s(i1) != t(i1)
           } {

        if (s(i1) == t(i2) && s(i2) == t(i1)) {
          r = 2
        } else if (s(i1) == t(i2)) {
          r = r max 1
        }
      }

      r + cnt
    }

  }
}
