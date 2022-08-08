package linkedlist


 case class ListNode(var x: Int = 0, var next: ListNode = null)

object Solution {
  def main(args: Array[String]): Unit ={

    val l1 = ListNode(2,ListNode(4,ListNode(6,ListNode(1))))
    val l3 = ListNode(5,ListNode(6,ListNode(4)))


    var res = addTwoNumbers( l1,l3)
    while(res.next!=null){
      println(res.x)
      res = res.next
    }
  }


  def addTwoNumbers(l1: ListNode, l2: ListNode): ListNode = {

    var vl1 = l1
    var vl2  = l2
    val ln_head :ListNode= new ListNode()
    var ln = ln_head
    while(vl1!=null || vl2!=null){
      val n1 = if (vl1!=null) vl1.x else 0
      val n2 = if (vl2!=null) vl2.x else 0
      val n = (ln.x+n1+n2)%10
      val reminder=if (ln.x+n1+n2>9) 1 else 0
      ln.x = n
      vl1 = if (vl1!=null) vl1.next else null
      vl2 = if (vl2!=null) vl2.next else null
      if (vl1!=null || vl2!=null || reminder>0) {
        ln.next = new ListNode(reminder)
        ln = ln.next
      }
    }
    ln_head
  }
}