  public long kth(int k) {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    Set<Integer> set = new HashSet<>();
    
    minHeap.offer(3*5*7);
    int count = 1;
    while (count < k) {
      Integer temp = minHeap.poll();
      if (!set.contains(3*temp)) {
        set.add(3*temp);
        minHeap.offer(3*temp);
      } 
      if (!set.contains(5*temp)) {
        set.add(5*temp);
        minHeap.offer(5*temp);
      } 
      if (!set.contains(7*temp)) {
        set.add(7*temp);
        minHeap.offer(7*temp);
      } 
      count++;
    }
    
    return minHeap.poll();
  }
