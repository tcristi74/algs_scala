package linkedlist
import scala.collection.mutable.Stack
object reverse_linked_list_206 {
  def main(args: Array[String]): Unit = {

    val l1 = ListNode(1, next = ListNode(2, ListNode(3,ListNode(4,ListNode(5)))))

    var rety =reverseList(l1)

    while (rety != null) {
      println(rety.x)
      rety = rety.next
    }
  }
  def reverseList(head: ListNode): ListNode = {
    var prev: ListNode = null
    var curr: ListNode = head
    while (curr != null) {
      var tmp = curr.next
      curr.next = prev
      prev = curr
      curr = tmp
    }
    prev


  }

  def reverseList2(head: ListNode): ListNode = {

    val rev :ListNode= ListNode()
    var ln =head

    val q = Stack.empty[Int]

    while(ln!=null){
      q.push(ln.x)
      ln = ln.next
    }
    ln = rev
    while (!q.isEmpty){
      ln.next = ListNode(q.pop())
      ln = ln.next
    }
    rev.next
  }

}
