package matrix

import scala.collection.mutable.Queue

object flood_fill_733 {
  def main(args:Array[String]): Unit ={
    val mat= Array(
      Array(1, 1, 1),
      Array(1, 1, 0),
      Array(1, 0, 1))


    mat.foreach(p => println(p.toList))
    println(" ")
    floodFill(mat,1,1,2).foreach(l => println(l.toList))
  }

  type matrix[N] = Array[Array[N]]

  def floodFill(image: Array[Array[Int]], sr: Int, sc: Int, newColor: Int): Array[Array[Int]] = {

      if (sc<0 || sr<0 ||image.length<=sc || image(0).length<sr || image(sr)(sc)==newColor) Array.empty
      else {

        val initialColor =  image(sr)(sc)
        val q: Queue[(Int,Int)] = Queue(sr->sc)

        while (!q.isEmpty) {
          val (r,c) = q.dequeue()
          image(r)(c)=newColor
          //top
          if (r>0 && image(r-1)(c)==initialColor){
            q.enqueue((r-1) -> c)
          }
          if (r<image.length-1 && image(r+1)(c)==initialColor){
            q.enqueue((r+1)->c)
          }
          if (c>0 && image(r)(c-1)==initialColor){
            q.enqueue(r->(c-1))
          }
          if (c<image(r).length-1 && image(r)(c+1)==initialColor){
            q.enqueue(r-> (c+1))
          }
        }
        image
      }
  }
}
