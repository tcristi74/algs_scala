package backtracking
/*Given two integers n and k, return all possible combinations of k numbers out of the range [1, n].
You may return the answer in any order.
nput: n = 4, k = 2
  Output:
  [
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
  ]*/
object combinations_77 {
  def main(args:Array[String]): Unit ={
    val n=5
    val k = 6
    val v = combine(n,k)
    v.foreach(p=> println(p))
  }

  def combine(n: Int, k: Int): List[List[Int]] = {

    val ar: List[Int] = (1 to n).toList

    var inp = for (i <- ar) yield List(i)
    for (_ <- 1 until k) {
      var res: List[List[Int]] = List.empty
      for (ll <- inp) {
        res :::= comb1(ll, ar)
      }
      inp=res
    }
   inp
  }

  def comb1(ar1:List[Int],ar2: List[Int]):List[List[Int]]={
    for (x <-ar2 if x>ar1.reduce((a,b)=> a max b)  )  yield ar1 :+ x
  }

}



