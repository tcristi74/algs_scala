package general

import scala.collection.mutable.SortedSet

case class MedianStruc(left:SortedSet[Int],var median:Double,right:SortedSet[Int]){

  def add(value :Int):Unit={
    if (value>median) {
      right+=value
    }
    else {
      left+=value
    }
    balance()
  }

  def balance(){
    (left,right) match {
      case x if x._1.size==x._2.size => median = (x._1.last+x._2.last).toDouble/2
      case x if x._1.size+1==x._2.size => median = x._2.last
      case x if x._2.size+1==x._1.size => median = x._1.last
      case x if x._1.size+2>=x._2.size =>
        //move an element from left to right
        x._1+=x._2.last
        x._2-=x._2.last
        balance()
      case x if x._2.size+2>=x._1.size =>
        //move an element from left to right
        x._2+=x._1.last
        x._1-=x._1.last
        balance()
    }
  }
}

object fb_stream_median {

  def main(args:Array[String]) {

    val mystruc = MedianStruc(SortedSet.empty, 0, SortedSet.empty(Ordering.Int.reverse))
    val ar1 = Array[Int](3, 6, 1, 9, 0)

    for (x <- 0 to 10) {
      val output = getMedian(mystruc, ar1.map(p => p + x))
      println(output)
      println(mystruc.left.toList)
      println(mystruc.right.toList)

    }
  }

  def getMedian(streamVals:MedianStruc, vals:Array[Int]): Double ={
    for (el <-vals){
      streamVals.add(el)
    }
    streamVals.median
  }

}
