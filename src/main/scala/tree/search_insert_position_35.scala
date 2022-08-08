package tree

object search_insert_position_35 {

  def main(args:Array[String]): Unit ={
    val nums :Array[Int] = Array(1,3,5,6,8,9,12,56,78,90,333)
    val target :Int=1000

    val x = searchInsert(nums, target)
    println(x)

  }

  def searchInsert(nums: Array[Int], target: Int): Int = {
    require(nums.length>0)
    recSearch(nums,0,nums.length-1,target)
  }

  def recSearch(nums:Array[Int], startIndex:Int, endIndex:Int, target:Int) :Int =
    startIndex match {
      case x if x==endIndex => x
      case x if endIndex-1==x =>
        target match {
          case t if t<=nums(x) => x
          case t if t<=nums(endIndex) => endIndex
          case _ => endIndex+1
        }
      case _=>
        val middle :Int = startIndex+(endIndex-startIndex)/2
        middle match {
          case m if nums(m)==target => m
          case m if nums(m)>target => recSearch(nums,startIndex,middle,target)
          case _ => recSearch(nums,middle+1,endIndex,target)
        }
    }
}
