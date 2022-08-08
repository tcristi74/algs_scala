package general

// We don’t provide test cases in this language yet, but have outlined the signature for you. Please write your code below, and don’t forget to test edge cases!
object fb_counting_triangles {

  def main(args: Array[String]) {
    // Call countDistinctTriangles() with test cases here

    val arr: Array[Array[Int]] = Array(Array(2, 2, 3), Array(3, 2, 2), Array(2, 5, 7), Array(2, 5, 33), Array(2, 5, 6))
    val newArr = for (a <- arr) yield a.sorted
    val cnt = countDistinctTriangles(newArr)
    println(cnt)
  }


  val isEqual: (Array[Int], Array[Int]) => Boolean = (a1, a2) => {
    (for (x <- 0 until 3; if a1(x) != a2(x)) yield 0).length == 0
  }

  def countDistinctTriangles[T](arr: Array[Array[Int]]): Int = {
    var setHelper: scala.collection.immutable.Set[Int] = Set.empty
    for (i <- 0 until arr.length; if !setHelper(i)) {
      for (j <- i + 1 until arr.length; if !setHelper(j)) {
        if (isEqual(arr(i), arr(j))) {
          setHelper += j
        }
      }
    }
    arr.length - setHelper.size
  }
}
