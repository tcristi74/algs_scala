package general
import scala.collection.mutable

object rotate_array_189 {
  def main(args:Array[String]): Unit ={
    val nums :Array[Int] = Array(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17)
    println(nums.toList)
    val k = 3
    rotate(nums,k)
    println(nums.toList)
  }

  def rotate(nums:Array[Int],k:Int): Unit ={
    var (l,r) = (0,nums.length-1)
    val nK = k % nums.length
    while(l<r){
      val tmp = nums(l)
      nums(l) = nums(r)
      nums(r) = tmp
      l+=1
      r-=1
    }

    l = 0
    r = nK-1
    while(l<r){
      val tmp = nums(l)
      nums(l) = nums(r)
      nums(r) = tmp
      l+=1
      r-=1
    }
    /*l = nK
    r = nums.length-1
    while(l<r){
      val tmp = nums(l)
      nums(l) = nums(r)
      nums(r) = tmp
      l+=1
      r-=1
    }*/

  }

  def rotate1(nums: Array[Int], x: Int): Unit = {
    val arLen = nums.length
    //require(arLen>=k)
    val q: mutable.Queue[Int] = mutable.Queue.empty
    //add last k to Queue
    val k:Int = x%arLen
    for(i<-arLen-k until arLen){
      q.enqueue(nums(i))
    }
    //move records
    for(i<-k until arLen)
      nums(arLen-i+k-1) =  nums(arLen-i-1)

    var index = 0
    while(!q.isEmpty){
      nums(index) = q.dequeue()
      index+=1
    }

  }

}
