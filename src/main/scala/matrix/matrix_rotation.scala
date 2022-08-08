package matrix

object matrix_rotation {

  //Question: How will you rotate a square (N x N) matrix by 90 degrees in the anti-clockwise direction without using any extra space?
  /*
  123       369
  456   --> 258
  789       147

  1234      48cg
  5678      37bf
  9abc  --> 26be
  defg      159d

*/
  type matrix[N] = Array[Array[N]]

  def main(args: Array[String]) {

    //var mat: matrix[Int] = Array(Array(1,2,3),Array(4,5,6),Array(7,8,9))
    var mat: matrix[Int] = Array(Array(1, 2, 3, 4), Array(5, 6, 7, 8), Array(9, 10, 11, 12), Array(13, 14, 15, 16))
    printx(mat)
    var output = rotateMatrix(mat)

    for (v <- output) {
      println(v.toList)
    }


  }

  def rotateMatrix(mat: matrix[Int]): matrix[Int] = {
    //go circle by circle
    var r = 0
    val l1 = mat.length - 1
    var l = mat.length - 1
    while (l >= mat.length / 2) {
      while (r < l1) {
        val ini = mat(l1 - l)(r)
        mat(l1 - l)(r) = mat(r)(l)
        mat(r)(l) = mat(l)(l1 - r)
        mat(l)(l1 - r) = mat(l1 - r)(l1 - l)
        mat(l1 - r)(l1 - l) = ini
        r += 1
      }
      l -= 1
      r = l
    }
    mat
  }

  def printx(ar: matrix[Int]): Unit = {

    for (v <- ar) {
      println(v.toList)
    }
  }
}
