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
  public ListNode merge(List<ListNode> listOfLists) {
    if (listOfLists == null) return null;
    int n = listOfLists.size();
    PriorityQueue<ListNode> minHeap = new PriorityQueue<ListNode>(11, new Comparator<ListNode>(){
      public int compare(ListNode n1, ListNode n2) {
        if (n1.value == n2.value) return 0;
        return n1.value < n2.value ? -1 : 1;
      }      
    });
    
    ListNode dummy = new ListNode(0);
    ListNode copy = dummy;
    
    for (ListNode node : listOfLists) {
      if (node != null)
      minHeap.offer(node);
    }
    
    while (!minHeap.isEmpty()) {
      ListNode cur = minHeap.poll();
      copy.next = cur;
      if (cur.next != null) {
        minHeap.offer(cur.next);
      }
      copy = copy.next;
    }
    return dummy.next;
  }
