package tree

object first_bad_version_278 {
  def main(args:Array[String]) :Unit={
    val n :Int = 2126753390

    val fb = firstBadVersion(n)
    println(fb)
  }

  def firstBadVersion(n: Int): Int = {
    val middle = n/2
    firstBadVersion2(n,middle)

  }


  def firstBadVersion2(n: Int, middle :Int): Int = {


      middle match {
        case m if m == 0 =>
          n match {
            case x if isBadVersion(x) => x
            case _ => 0
          }
        case m if m == n && isBadVersion(m) => m
        case m if n==m+1 && isBadVersion(m) => m
        case m if n==m+1 && !isBadVersion(m) => n
        case m if isBadVersion(m) && !isBadVersion(m - 1) => m
        case m if isBadVersion(m) => firstBadVersion2(middle, middle / 2)
        case _ => firstBadVersion2(n, middle + (n-middle) / 2)
      }
    }


  def isBadVersion(version: Int): Boolean = { version>= 1702766719}

}
