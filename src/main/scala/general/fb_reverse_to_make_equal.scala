package general

// We don’t provide test cases in this language yet, but have outlined the signature for you. Please write your code below, and don’t forget to test edge cases!
object fb_reverse_to_make_equal {

 def main(args: Array[String]) {
   // Call areTheyEqual() with test cases here

   //we assume that any array A cn be made identical with Array B if
   val ar1: Array[Int] = Array(1, 2, 3, 4, 7, 3, 6, 8)
   val ar2: Array[Int] = Array(1, 3, 2, 4, 6, 7, 8, 9)
   println(areTheyEqual(ar1, ar2))
   //1. they got the same length
   // 2. they got the same elements ( when ordered they are ideantical )
 }

 def areTheyEqual(arr_a: Array[Int], arr_b: Array[Int]): Boolean = {
   // Write your code here
   (arr_a, arr_b) match {
     case arrs if arrs._1.length != arrs._2.length => false
     case _ => {
       var ar1s = arr_a.sorted
       var ar2s = arr_b.sorted
       var eq = true
       for (i <- 0 to (ar1s.length - 1) if eq) {
         eq = ar1s(i) == ar2s(i)
       }
       eq
     }
   }
 }
}
