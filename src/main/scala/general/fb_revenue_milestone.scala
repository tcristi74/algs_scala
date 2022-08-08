package general
import scala.collection.mutable.ArrayBuffer
object fb_revenue_milestone {

  def main(args: Array[String]) {
    // Call getMilestoneDays() with test cases here
    val revenues: Array[Int] = Array(10, 20, 30, 40, 50, 60, 70, 80, 90, 100)
    val milestones: Array[Int] = Array(100, 200, 500)
    val res = getMilestoneDays(revenues, milestones)
    println(res.toList)
    //output = [4, 6, 10]
  }

  def getMilestoneDays(revenues: Array[Int], milestones: Array[Int]): Array[Int] = {
    if (revenues.length == 0 || milestones.length == 0) Array.empty
    else {

      var revSubtotal: Int = 0
      var milestoneIndex = 0
      val res: ArrayBuffer[Int] = ArrayBuffer.empty
      for (x <- 0 to (revenues.length - 1); if res.length < milestones.length) {
        revSubtotal += revenues(x)
        if (revSubtotal >= milestones(milestoneIndex)) {
          res append (x + 1)
          milestoneIndex += 1
        }
      }
      res.toArray
    }
  }
}
