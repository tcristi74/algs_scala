import scala.collection.mutable.ArrayBuffer

val ar2 = scala.util.Random.nextBytes(
  5).map(_.toInt).toList.sortBy(x=> x.toInt)

val ar1 = scala.util.Random.nextBytes(5).map(_.toInt).toList.sorted



def merge2(ar1:List[Int], ar2:List[Int]) :List[Int] = {
  println("start")
  val one_length = ar1.length
  val two_length = ar2.length
  var one_index = 0
  var index2 = 0


  var ret : List[Int] = List.empty
  while ( one_index<one_length && index2<two_length ){
   if (ar1(one_index)<=ar2(index2)){
     ret = ar1(one_index) :: ret
     one_index+=1
   } else {
     ret = ar2(index2) :: ret
     index2 += 1
   }
  }
  // add rest
  while  (one_index<one_length){
    ret = ar1(one_index) :: ret
    one_index+=1
  }

  while  (index2<two_length){
    ret = ar2(index2) :: ret
    index2+=1
  }
  ret.reverse.toList
}


val finar = merge2(ar1,ar2)
println(finar)