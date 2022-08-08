package general
import scala.collection.mutable.Map
object claimb_stairs_70 {

  def main(args:Array[String]): Unit = {
    val n:Int = 10


    println(climbStairs(n))

  }

  def climbStairs(n: Int): Int = {
    val s :Map[Int,Int] = Map(0->0,1->1,2->2)
    claim(n,0,n,s)
  }

  def claim(n:Int, counter:Int, left :Int,m:Map[Int,Int]): Int ={
    left match {
      case l if m.contains(l) => m(l)
      case 0 => 0
      case 1 => 1
      case 2=> 2
      case _ =>{
        val v1 = claim(n,counter+1,left-1,m)
        m+= left-1 -> v1
        val v2 = claim(n, counter+1, left-2,m)
        m+= left-2 -> v1
        v1+v2
      }
    }
  }

}
