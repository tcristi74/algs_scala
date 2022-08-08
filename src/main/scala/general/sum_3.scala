package general

import scala.collection.mutable

/*
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
Notice that the solution set must not contain duplicate triplets.
Example 1:
  Input: nums = [-1,0,1,22,22,2,-1,-4]
  Output: [[-1,-1,2],[-1,0,1]]
*/

object sum_3 {
  def main(args:Array[String]): Unit = {
    val ar = Array(-1,0,1,2,-1,-4)

    val output: List[List[Int]] = threeSum(ar)
    output.foreach(x=>println(x))
  }


  def threeSum(nums: Array[Int]): List[List[Int]] = {
    var output : List[List[Int]] = List.empty
    var sNeg = nums.filter(p=>p<0)
    var sPos = nums.filter(p=>p>=0)
    val mPos = fillMap2(sPos)
    val mNeg = fillMap2(sNeg)

    if (sPos.count(p=>p==0)>=3){
      output :+=List(0,0,0)
    }

    sNeg = sNeg.distinct
    sPos = sPos.distinct



    for (x<-sNeg){
      val v = getPair2(x,mPos,sPos)
      if (v.nonEmpty){
        for (l<-v)
        output :+=l
      }
    }
    for (x<-sPos){
      val v = getPair2(x,mNeg,sNeg)
      if (v.nonEmpty){
        for (l<-v)
          output :+=l
      }
    }
    output

  }

  def fillMap2(ar:Array[Int]): mutable.Map[Int, Boolean]={
    val m: mutable.Map[Int, Boolean] = mutable.Map.empty
    for (x <- ar.indices) {
      if (m.contains(ar(x))){
        m.update(ar(x), true)
      }
      else {
        m += (ar(x) -> false)
      }
    }
    m
  }



  def getPair2(n:Int, mp:mutable.Map[Int,Boolean],ar:Array[Int]): List[List[Int]]={
    var res : List[List[Int]]=List.empty

    var used:Set[Int] =Set.empty

    for (el<-ar.indices if !used.contains(ar(el))) {
      val toFind:Int = -(n+ar(el))
      if (mp.contains(toFind)) {
        if (ar(el)!=toFind || mp(toFind)==true) {
          res :+= List(n, ar(el), toFind)
          used +=toFind
          used +=ar(el)

        }
      }
   }
     res
  }
}

