package linkedlist
/*Input: list1 = [1,2,4], list2 = [1,3,4]
  Output: [1,1,2,3,4,4]*/
object merge_2_sorted_lists_21 {
  def main(args: Array[String]): Unit = {

    val l1 = ListNode(1, next = ListNode(2, ListNode(4)))
    val l2 = ListNode(1, next = ListNode(3, ListNode(4)))
    var rety = mergeTwoLists(l1, l2)

    while (rety != null) {
      println(rety.x)
      rety = rety.next
    }

  }

  def mergeTwoLists(list1: ListNode, list2: ListNode): ListNode = {
    var l1 = list1
    var l2 = list2
    val ln_head: ListNode = new ListNode()
    var lx = ln_head
    while (l1 != null && l2 != null) {
      val v1 = l1.x
      val v2 = l2.x
      lx.next = ListNode(v1 min v2)
      lx = lx.next
      if (v1 <= v2) {
        l1 = l1.next
      } else {
        l2 = l2.next
      }
    }
    if (l1 != null) {
      lx.next = l1
    }
    if (l2 != null) {
      lx.next = l2
    }

    ln_head.next

  }

}
