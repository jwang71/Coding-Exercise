  public List<Integer> closest(int[] a, int[] b, int[] c, int k) {
    PriorityQueue<List<Integer>> minHeap = new PriorityQueue<>(k, new Comparator<List<Integer>>(){
      public int compare(List<Integer> l1, List<Integer> l2) {
        int d1 = getDistance(l1, a, b, c);
        int d2 = getDistance(l2, a, b, c);
        if (d1 == d2) {
          return 0;
        }
        return d1 < d2 ? -1 : 1;
      }
    });
 
    List<Integer> cur = Arrays.asList(0, 0, 0);
    HashSet<List<Integer>> visited = new HashSet<>();
    minHeap.offer(cur);
    visited.add(cur);
    
    while (k > 0) {
      cur = minHeap.poll();
      List<Integer> n = Arrays.asList(cur.get(0) + 1, cur.get(1), cur.get(2));
      if (n.get(0) < a.length && visited.add(n)) {
        minHeap.offer(n);
      }
      n = Arrays.asList(cur.get(0), cur.get(1) + 1, cur.get(2));
      if (n.get(1) < b.length && visited.add(n)) {
        minHeap.offer(n);
      }
      n = Arrays.asList(cur.get(0), cur.get(1), cur.get(2) + 1);
      if (n.get(2) < c.length && visited.add(n)) {
        minHeap.offer(n);
      }
      k--;
    }

    cur.set(0, a[cur.get(0)]);
    cur.set(1, b[cur.get(1)]);
    cur.set(2, c[cur.get(2)]);
    return cur;
  }
  
  public int getDistance(List<Integer> list, int[] a, int[] b, int[] c) {
    return a[list.get(0)] * a[list.get(0)] + b[list.get(1)] * b[list.get(1)] + c[list.get(2)] * c[list.get(2)];
  }

