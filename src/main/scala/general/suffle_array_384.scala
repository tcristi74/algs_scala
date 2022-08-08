case object suffle_array_384{

  def main(args: Array[String]): Unit = {

    val nums :Array[Int] = scala.util.Random.nextBytes(10).map(_.toInt).toArray
    println("initial",nums.toList)
    println(nums)
    val obj = new Solution384(nums)
    var param_2 = obj.shuffle()
    println("shuffle",param_2.toList)
    println(param_2)
    var param_1 = obj.reset()
    println("reset",param_1.toList)
    println(param_1)


  }
}


class Solution384(_nums: Array[Int]) {

  val initialArray =_nums.clone()

  def reset(): Array[Int] = {
    initialArray
  }

  def shuffle(): Array[Int] = {

    val newArray = _nums.clone()
    for (i <-0 to _nums.length-1) {
      val rid=scala.util.Random.between(0 ,_nums.length-1 )
      val v1 = newArray(i)
      val v2 = newArray(rid)
      if (v1!=v2) {
        newArray.update(i, v2)
        newArray.update(rid, v1)
      }
    }
    newArray
  }
}
