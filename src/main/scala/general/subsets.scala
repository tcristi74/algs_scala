package general
/*
  Given an integer array nums of unique elements, return all possible subsets (the power set).
  The solution set must not contain duplicate subsets. Return the solution in any order.
  Input: nums = [1,2,3]
  Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
*/

object subsets {

  def main(args:Array[String]): Unit ={
    val nums = Array(1,2,3,4)
    val out = subsets(nums)
    out.foreach(x=> println(x))
  }


  def subsets(nums: Array[Int]): List[List[Int]] = {
    var newLists:List[List[Int]]=List.empty
    for(n<-nums){
      newLists = addLists(n,newLists)
    }
    newLists :+ List.empty
  }

  def addLists(el:Int,lists:List[List[Int]]) :List[List[Int]]= {
    var newLists:List[List[Int]]=List(List(el))
    for(lst<-lists){
      val nl = lst :+ el
      newLists :+= nl
    }
    newLists ::: lists
  }

}
