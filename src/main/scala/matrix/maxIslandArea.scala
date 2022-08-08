package matrix



object maxAreaOfIslands {

  def main(args:Array[String]): Unit ={

    val m:Array[Array[Int]] = Array(
      Array(0,0,1,0,0,0,0,1,0,0,0,0,0),
      Array(0,0,0,0,0,0,0,1,1,1,0,0,0),
      Array(0,1,1,0,1,0,0,0,0,0,0,0,0),
      Array(0,1,0,0,1,1,0,0,1,0,1,0,0),
      Array(0,1,0,0,1,1,0,0,1,1,1,0,0),
      Array(0,0,0,0,0,0,0,0,0,0,1,0,0),
      Array(0,0,0,0,0,0,0,1,1,1,0,0,0),
      Array(0,0,0,0,0,0,0,1,1,0,0,0,0))

    val output = maxAreaOfIsland(m)
    println(output)
  }

  def maxAreaOfIsland(grid: Array[Array[Int]]): Int = {
    var cnt:Int = 0
    for(r<-grid.indices; c<-grid(r).indices) {
        val cell = grid(r)(c)
        if (cell == 1 ){
          cnt =cnt max checkArea(r, c, grid)
        }
      }
    cnt
  }

  def checkArea(r:Int,c:Int,grid: Array[Array[Int]]):Int = {
    grid match {
      case x if (r<0  || c<0 || r==x.length || c==x(r).length ) => 0
      case x if x(r)(c)==0 => 0
      case g =>
        g(r)(c)=0
        1+ checkArea(r+1,c,g)+checkArea(r-1,c,g)+checkArea(r,c-1,g)+checkArea(r,c+1,g)
    }
  }
}
