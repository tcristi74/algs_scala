package linkedlist

object middle_linked_list {
  def main(args: Array[String]): Unit = {
    val l2 = ListNode(2, ListNode(4, ListNode(6, ListNode(1, ListNode(14, ListNode(12))))))
    //val l2 = ListNode(2, ListNode(4, ListNode(6, ListNode(1, ListNode(14)))))
    val l1 = middleNode(l2)
    println(l1.x)
  }


    def middleNode(head: ListNode): ListNode = {
      var cnt = 0
      var sn :ListNode =head
      var n  = head
      while (n.next!=null) {
        n = n.next
        cnt+=1
        if (cnt%2==0)
          sn = sn.next
      }
/*      if (cnt%2==1){
        sn = sn.next
      }*/
      sn

    }
}
