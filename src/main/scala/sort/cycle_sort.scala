package sort

import scala.collection.mutable.ArrayBuffer

object cycle_sort {
  def main(args:Array[String]): Unit ={
    //val arr: Array[Int] = Array(1, 8, 3, 9, 10, 10, 2, 4)
    val arr: Array[Int] = Array(1, 2, 3, 4, 5, 6, 7,8 )
    var cycle :Array[Int] = Array(0,3,1)
    val n: Int = arr.length
    println(rotateCircular(arr, cycle).toList)
    cycle  = Array(5,6)
    println(rotateCircular(arr, cycle).toList)
    val cycles = findCycles(arr)
    cycles.foreach(c=> println(c.toList))
  }

  def rotateCircular(arr:Array[Int],cycle:Array[Int]):Array[Int]={
    require(cycle.length>1)
    val maxCycle = cycle.maxBy(p=>p)
    require(maxCycle<arr.length)
    var val0:Int=arr(cycle(0))
    var val1:Int=arr(cycle(1))
    for(cycleCnt<-0 until cycle.length){
      val arrIndex = if (cycleCnt+1==cycle.length) cycle(0) else  cycle(cycleCnt+1)
      val1 =arr(arrIndex)
      arr(arrIndex) = val0
      val0 = val1
    }
    arr
  }

  def findCycles(arr: Array[Int]): Array[Array[Int]] ={
    val cycles = ArrayBuffer[Array[Int]]()
    for(i<-arr.indices){
     if (arr(i) >i+1){
       val cycle= ArrayBuffer[Int]()
       var endIndex  = arr(i)-1
       var startIndex  = i
       var pos = arr(i)
       var done:Boolean = false
       while (!done){
         done = endIndex == i
         cycle+= endIndex
         val t = arr(endIndex)
         arr(endIndex)=pos
         pos = t
         startIndex = endIndex
         endIndex =pos-1
       }
       cycles +=cycle.reverse.toArray
     }
    }
    cycles.toArray
  }

/*
  def cycleSort(arr:Array[Int], n:Int):Array[Int]={

    val swap : (Int,Int)=>Unit = (a,b)=>{
      val t = arr(a)
      arr(a) = arr(b)
      arr(b) = t
    }

    for(cycle_start<-0 until n) {
      val item = arr(cycle_start)

      //find where to put the item
      var newPosition = cycle_start
      for(i<-newPosition+1 until n){
        if (arr(i)<item) { newPosition+=1}
      }
      if (cycle_start!=newPosition){
        // put the at th enew position ot right after duplicates
        while (item==arr(newPosition)){
          newPosition+=1
        }
        swap(cycle_start,newPosition)
      }

    }

  }
*/

}
