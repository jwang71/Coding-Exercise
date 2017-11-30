
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
  public ListNode mergeSort(ListNode head) {
    if (head == null || head.next == null) return head;
    ListNode mid = findMid(head);
    ListNode midNext = mid.next;
    mid.next = null;
    ListNode first = mergeSort(head);
    ListNode second = mergeSort(midNext);
    return merge(first, second);
  }
  
  public ListNode merge(ListNode first, ListNode second) {
    ListNode dummy = new ListNode(0);
    ListNode cur = dummy;
    
    while (first != null && second != null) {
      if (first.value < second.value) {
        cur.next = first;
        first = first.next;
      } else {
        cur.next = second;
        second = second.next;
      }
      cur = cur.next;
    }
    
    if (first != null) {
      cur.next = first;
    }
    if (second != null) {
      cur.next = second;
    }
    return dummy.next;
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
