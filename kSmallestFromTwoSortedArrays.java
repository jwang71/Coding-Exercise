
  public int kthSum(int[] A, int[] B, int k) {
    PriorityQueue<Entry> minHeap = new PriorityQueue<>(11, new Comparator<Entry>(){
      public int compare(Entry e1, Entry e2) {
        if (e1.sum == e2.sum) {
          return 0;
        }
        return e1.sum < e2.sum ? -1 : 1;
      }
    });
    
    boolean[][] visited = new boolean[A.length][B.length];
    minHeap.offer(new Entry(0, 0, A[0] + B[0]));
    visited[0][0] = true;
    
    for (int i = 1; i < k; i++) {
      Entry temp = minHeap.poll();
      
      if (temp.x < A.length && temp.y + 1 < B.length && !visited[temp.x][temp.y + 1]) {
        minHeap.offer(new Entry(temp.x, temp.y + 1, A[temp.x] + B[temp.y + 1]));
        visited[temp.x][temp.y + 1] = true;        
      }
      if (temp.x + 1 < A.length && temp.y < B.length && !visited[temp.x + 1][temp.y]) {
        minHeap.offer(new Entry(temp.x + 1, temp.y, A[temp.x + 1] + B[temp.y]));
        visited[temp.x + 1][temp.y] = true;        
      }      
      
    }
    
    return minHeap.peek().sum;
  }
  
  public class Entry {
    int x;
    int y;
    int sum;
    
    public Entry (int x, int y, int sum) {
      this.x = x;
      this.y = y;
      this.sum = sum;
    }
  }
