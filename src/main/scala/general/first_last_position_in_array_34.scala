package general

/*
Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
If target is not found in the array, return [-1, -1].
You must write an algorithm with O(log n) runtime complexity.
*/



object first_last_position_in_array_34 {

  def main(args:Array[String]){
    //val nums:Array[Int] = Array(1,2,4,4,4,4,3,4,5,5,6,7,8,8,8,9,10)
   // val nums:Array[Int] = Array(5,7,7,8,8,10)
    //val nums:Array[Int] = Array.empty
   val nums:Array[Int] = Array(1)
    val target = 1
    val res = searchRange(nums,target).toList
    println(res)
  }

  def searchRange2(nums: Array[Int], target: Int): Array[Int] = {

    val f=  nums.indexOf(target)
    val l=  nums.lastIndexOf(target)
    (f,l) match {
      case (-1,-1) => Array(-1,-1)
      case (x,y) if x==y => Array(x)
      case (x,y) => Array(x,y)
    }
  }


  def searchRange3(nums: Array[Int], target: Int): Array[Int] = {
    var f:Int = -1
    var l:Int = -1
    for(i<- nums.indices; if nums(i)==target){
      f =  if (f == -1) i else f
      l = i
    }

    (f,l) match {
      case (x,y) if x==y => Array(x)
      case (x,y) => Array(x,y)
    }
  }

  def searchRange(nums: Array[Int], target: Int): Array[Int] = {

    val f = findVal(nums,target,0,nums.length,-1)
    val l = findVal(nums,target,0,nums.length,1)
    (f,l) match {
      case (x,y) if x==y => Array(x,x)
      case (x,y) => Array(x,y)
    }

  }

  def findVal(nums:Array[Int], target:Int, start:Int,end:Int, offset:Int):Int={

    val middle :Int = (start+end)/2
    println(s"middle=$middle;  start=$start;  end=$end")
    middle match {
      case x if x>=nums.size => -1
      case x if nums(x)==target =>
        offset match {
          case -1 if x==start || nums(x-1)<target => x
          case 1 if x==end-1 || nums(x+1)>target => x
          case -1 => findVal(nums, target, start, middle, offset)
          case 1 => findVal(nums, target, middle, end, offset)
        }
      case x if x==start  => -1
      case x if nums(x)>target => findVal(nums, target, start, middle, offset)
      case x if nums(x)<target => findVal(nums, target, middle, end, offset)
    }
  }
}
