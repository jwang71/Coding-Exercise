
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
  public ListNode selectionSort(ListNode head) {
    // Write your solution here.
    if (head == null || head.next == null) return head;
    
    for (ListNode node = head; node != null; node = node.next) {
      ListNode min = node;
      for (ListNode n = node; n != null; n = n.next) {
        if (n.value < min.value) {
          min = n;
        }
      }
      
      int temp = node.value;
      node.value = min.value;
      min.value = temp;
    }
    return head;
  }
