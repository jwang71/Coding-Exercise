
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

  public ListNode cycleNode(ListNode head) {
    if (head == null || head.next == null) return null;
    
    ListNode slow = head;
    ListNode fast = head;
    
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if (fast == null || fast.next == null) {
        return null;
      }
      if (slow == fast) {
        break;
      }
    }
    
    fast = head;
    while (fast != slow) {
      slow = slow.next;
      fast = fast.next;
    }
    
    return slow;
  }

