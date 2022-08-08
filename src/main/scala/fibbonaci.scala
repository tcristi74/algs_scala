import scala.collection.mutable




object fibbonaci {

  def main(args: Array[String]) {
    //first n numbers
    val n: Int = 20
    val output = recFirstN(n, List(1, 1), 1, 1)
    println(output)

  }

  val m :mutable.Map[Int,Int] = mutable.Map((1->1),(2->2))


  def getFibSum(maxNo: Int): Long = {
    var prev = 1
    var cur = 1
    for(x<- 1 to maxNo) {
      val t = cur
      cur = cur + prev
      prev = t
    }
    cur
  }

  def recFirstN(n:Int, ar: List[Long], cur: Long, prev: Long): List[Long] = {
    ar match {
      case a if a.length == n => a.reverse
      case a => {
        recFirstN(n,(cur + prev) :: a, cur+prev, cur)
      }
    }
  }

  //recursive with memoization
  def fib(n:Int):Int={
    n match  {
      case 0 =>0
      case 1 => 1
      case 2 => 2
      case x =>
        val f2 =  if  (m.get(x-2)!=None) m(x-2) else fib(n-2)
        val f1 =  if  (m.get(x-1)!=None) m(x-1) else fib(n-1)
        val vn = f1 + f2
        m.addOne(n->vn)
        vn
    }
  }
}
