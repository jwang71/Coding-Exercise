
/**
 * class SkipListNode {
 *   public int value;
 *   public SkipListNode next;
 *   public SkipListNode forward;
 *   public SkipListNode(int value) {
 *     this.value = value;
 *   }
 * }
 */
public class Solution {
  public SkipListNode copy(SkipListNode head) {
    Map<SkipListNode, SkipListNode> map = new HashMap<>();
    SkipListNode dummy = new SkipListNode(0);
    SkipListNode cur = dummy;
    
    while (head != null) {
      if (map.containsKey(head)) {
        cur.next = map.get(head);
      } else {
        map.put(head, new SkipListNode(head.value));
        cur.next = map.get(head);
      }
      
      if (head.forward != null) {
        if (map.containsKey(head.forward)) {
          cur.next.forward = map.get(head.forward);
        } else {
          map.put(head.forward, new SkipListNode(head.forward.value));
          cur.next.forward = map.get(head.forward);
        }
      }

      head = head.next;
      cur = cur.next;
    }
    return dummy.next;
  }
}
