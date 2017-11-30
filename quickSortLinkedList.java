
/**
 * class ListNode {
 *   public int value;
 *   public ListNode next;
 *   public ListNode(int value) {
 *     this.value = value;
 *     next = null;
 *   }
 * }
 */
public class Solution {
  public ListNode quickSort(ListNode head) {
    if (head == null || head.next == null) return head;
    
    ListNode mid = findMid(head);
    ListNode smallDummy = new ListNode(0);
    ListNode smallTail = smallDummy;
    ListNode largeDummy = new ListNode(0);
    ListNode largeTail = largeDummy;
    ListNode midDummy = new ListNode(0);
    ListNode midTail = midDummy;
    
    ListNode cur = head;
    while (cur != null) {
      if (cur.value < mid.value) {
        smallTail.next = cur;
        smallTail = smallTail.next;
      } else if (cur.value > mid.value){
        largeTail.next = cur;
        largeTail = largeTail.next;
      } else {
        midTail.next = cur;
        midTail = midTail.next;
      }
      cur = cur.next;
    }
    
    smallTail.next = null;
    midTail.next = null;
    largeTail.next = null;
    
    ListNode left = quickSort(smallDummy.next);
    ListNode right = quickSort(largeDummy.next);
    return concat(left, midDummy.next, right);
  }
  
  public ListNode concat(ListNode a, ListNode b, ListNode c) {
    ListNode dummy = new ListNode(0);
    ListNode tail = dummy;
    tail.next = a;
    tail = findTail(tail);
    tail.next = b;
    tail = findTail(tail);
    tail.next = c;
    return dummy.next;
  }
  
  public ListNode findTail(ListNode head) {
    if (head == null || head.next == null) return head;
    
    while (head != null && head.next != null) {
      head = head.next;
    }
    return head;
  } 
  public ListNode findMid(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;
    while (fast.next != null && fast.next.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow;
  }
}
