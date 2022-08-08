package linkedlist

object remove_n_node_19 {
  def main(args:Array[String]){
    //val l2 = ListNode(2, ListNode(4, ListNode(6, ListNode(1, ListNode(14, ListNode(12))))))
    val l2 = ListNode(2, ListNode(4, null))
    val n=2
    val l =  removeNthFromEnd(l2,n)
    println(l)
    println(removeNthFromEnd(ListNode(1),1))
  }

  def removeNthFromEnd(head: ListNode, n: Int): ListNode = {



    n match {
      case 0 => head
      case 1 if head.next == null => null
      case _ =>

        val dummy = ListNode(-1)
        dummy.next = head
        var index1: Int = 0

        var n0 = dummy
        var n1 = dummy

        while (n0.next != null) {
          index1 += 1
          n0 = n0.next
          if (index1 >= n && n0.next != null) {
            n1 = n1.next
          }
        }
        val n2 = n1
        n2.next = n1.next.next
        dummy.next
    }
  }


}
