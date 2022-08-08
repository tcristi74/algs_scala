package general

object pascal_triangle{
  def main(args:Array[String]): Unit = {

    val output = generate(7)

    output.foreach(x=> println(x))
  }


  def generate(numRows: Int): List[List[Int]] = {

    numRows match {
      case 0 => List.empty
      case 1 => List(List(1))
      case 2 => List(List(1),List(1,1))
      case x =>{
        var slist = List(List(1),List(1,1))
        for(n<-3 to numRows) {
          val ll :List[Int]= slist.last
          var nlist =List(1)
          for(i<-1 until ll.length){
            nlist =  nlist :+ ll(i-1)+ll(i)
          }
          nlist :+=1
          slist :+= nlist
        }
        slist
      }
    }
  }

}
