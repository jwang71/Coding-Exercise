  public RandomListNode copy(RandomListNode head) {
    Map<RandomListNode, RandomListNode> map = new HashMap<>();
    
    RandomListNode cur = head;
    RandomListNode dummy = new RandomListNode(0);
    RandomListNode copy = dummy;
    while (cur != null) {
      if (!map.containsKey(cur)) {
        map.put(cur, new RandomListNode(cur.value));
      } 
      copy.next = map.get(cur);
      
      if (cur.random != null) {
        if (!map.containsKey(cur.random)) {
          map.put(cur.random, new RandomListNode(cur.random.value));
        }
        copy.next.random = map.get(cur.random);
      }
      cur = cur.next;
      copy = copy.next;
    }
    
    return dummy.next;
  }