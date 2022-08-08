package backtracking

import scala.collection.mutable.ListBuffer

/*Input: nums = [1,2,3]
  Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]*/
object permutations_46 {
  def main(args:Array[String]): Unit ={

   val ar: Array[Int] = (1 to 3).toArray
    val res = permute(ar)
    res.foreach(p=>println(p))
  }

  def permute(nums: Array[Int]): List[List[Int]] = {
    nums.length match {
      case 1 => List(List(nums.head))
      case _ => {
        val result = ListBuffer[List[Int]]()
        getPerm(nums,List.empty[Int],result)
        result.toList
      }
    }
  }

  def getPerm(nums: Array[Int],soFar:List[Int],result:ListBuffer[List[Int]]):Unit = {
    if(soFar.size == nums.size){
      result.append(soFar)
    } else {
      nums.foreach{num =>
        if(!soFar.contains(num)){
          getPerm(nums,soFar:+num,result)
        }
      }
    }
  }



}
