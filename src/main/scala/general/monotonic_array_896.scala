package general

object monotonic_array_896 {
  def main(args:Array[String]): Unit ={
    val nums:Array[Int] = Array(1,3,3,4,5)


    val isMono =isMonotonic(nums)
    println(isMono)


  }

  def isMonotonic(nums: Array[Int]): Boolean =
    if (nums.length<2){
      true
    } else{
      var v = nums(0)
      var positive :Option[Boolean] = Option.empty
      var notM:Boolean = false
      for(i<-1 until nums.length if notM==false){
        if (positive==None && v!=nums(i)){
          positive = Option(nums(i)>v)
        }
        else {
          notM =nums(i) match {
            case n if n > v && positive==Some(false)  =>
               true
            case n if n < v && positive==Some(true)  =>
               true
            case _ => notM
          }

        }
        v=nums(i)
      }
      !notM
    }
}
