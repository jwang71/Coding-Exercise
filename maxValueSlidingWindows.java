  public List<Integer> maxWindows(int[] array, int k) {
    List<Integer> max = new ArrayList<Integer>();
    Deque<Integer> deque = new LinkedList<Integer>();
    
    for (int i = 0; i < array.length; i++) {
      while (!deque.isEmpty() && array[deque.peekFirst()] <= array[i]) {
        deque.pollFirst();
      }
      
      while (!deque.isEmpty() && deque.peekLast() <= i - k) {
        deque.pollLast();
      }
      
      deque.offerFirst(i);
      if (i >= k - 1) {
        max.add(array[deque.peekLast()]);
      }
    }
    
    return max;
  }
