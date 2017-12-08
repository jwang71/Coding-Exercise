public class Solution {
  public int kthSmallest(int[][] matrix, int k) {
    PriorityQueue<Sum> minHeap = new PriorityQueue<>(k, new Comparator<Sum>(){
      @Override
      public int compare(Sum s1, Sum s2) {
        if (s1.sum == s2.sum) return 0;
        return s1.sum < s2.sum ? -1 : 1;
      }
    });
    
    int m = matrix.length;
    int n = matrix[0].length;
    boolean[][] visited = new boolean[m][n];
    minHeap.offer(new Sum(0,0,matrix[0][0]));
    visited[0][0] = true;
    
    for (int i = 1; i < k; i++) {
      Sum cur = minHeap.poll();
      if (cur.x + 1 < m && !visited[cur.x + 1][cur.y]) {
        minHeap.offer(new Sum(cur.x + 1, cur.y, matrix[cur.x + 1][cur.y]));
        visited[cur.x+1][cur.y] = true;
      }
      if (cur.y + 1< n && !visited[cur.x][cur.y+1]) {
        minHeap.offer(new Sum(cur.x, cur.y+1, matrix[cur.x][cur.y+1]));
        visited[cur.x][cur.y+1] = true;
      }
    }
    return minHeap.poll().sum;
  }
  
  public class Sum {
    int x;
    int y;
    int sum;
    
    public Sum(int x, int y, int sum) {
      this.x = x;
      this.y = y;
      this.sum = sum;
    }
  }
}
