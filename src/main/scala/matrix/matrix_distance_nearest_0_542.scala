package matrix

import scala.collection.mutable


/*
Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.
The distance between two adjacent cells is 1.
*/

object matrix_distance_nearest_0_542 {
  var i = 0

  def main(args: Array[String]): Unit = {

      val mat= Array(
      Array(1, 2, 3, 4),
      Array(5, 0, 7, 8),
      Array(9, 10, 11, 12),
      Array(0, 0, 15, 16))
/*    val mat = Array(
      Array(0, 2, 10, 10))*/

    mat.foreach(p => println(p.toList))
    println(" ")
    updateMatrix(mat).foreach(l => println(l.toList))

  }

  def updateMatrix(mat: Array[Array[Int]]): Array[Array[Int]] = {

    //crete new matrix
    val rl = mat.length
    val cl = mat(0).length
    var newMat :Array[Array[Int]] = Array.fill(rl)(Array.fill(cl)(9999))
    for (r<-0 until rl;c<-0 until cl)
      newMat(r)(c) =  (r,c) match {
        case (r1,c1) if mat(r1)(c1)==0 =>0
        case (r1,c1) if r1>0 || c1>0 =>
          var v = newMat(r1)(c1)
          if (r1>0) {
            v = v min  newMat(r1-1)(c1)+1
          }
          if (c1>0) {
            v = v min  newMat(r1)(c1-1)+1
          }
          v
        case _ => newMat(r)(c)
      }
    newMat.foreach(l => println(l.toList))
    for (r<-0 until rl;c<-0 until cl){
      newMat(r)(c) =  (r,c) match {
        case (r1,c1) if mat(r1)(c1)==0 =>0
        case (r1,c1) if r1<rl-1 || c1<cl-1 =>
          var v = newMat(r1)(c1)
          if (r1<rl-1) {
            v = v min  newMat(r1+1)(c1)+1
          }
          if (c1<cl-1) {
            v = v min  newMat(r1)(c1+1)+1
          }
          v
        case _ => newMat(r)(c)
      }
    }
    //check corners
    if (newMat(0)(0)>0 && rl>1 ){
      newMat(0)(0)= newMat(0)(0) min newMat(1)(0)+1
    }
    if (newMat(0)(0)>0 && cl>1 ){
      newMat(0)(0)= newMat(0)(0) min newMat(0)(1)+1
    }


  newMat

  }






}
