
public class Solution {
  public int kth(int k) {
    PriorityQueue<Sum> minHeap = new PriorityQueue<Sum>(k,new Comparator<Sum>(){
      public int compare(Sum s1, Sum s2) {
        if (s1.sum == s2.sum) return 0;
        return s1.sum < s2.sum ? -1 : 1;
      }
    });
    
    boolean[][] visited = new boolean[k][k];
    minHeap.offer(new Sum(0, 0, power(2,0)*power(3, 0)));
    visited[0][0] = true;
    
    for (int i = 1; i < k; i++) {
      Sum temp = minHeap.poll();
      if (!visited[temp.x + 1][temp.y]) {
        minHeap.offer(new Sum(temp.x+1, temp.y, power(2, temp.x+1)*power(3, temp.y)));
        visited[temp.x + 1][temp.y] = true;
      }
      if (!visited[temp.x][temp.y+1]) {
        minHeap.offer(new Sum(temp.x, temp.y+1, power(2, temp.x)*power(3, temp.y + 1)));
        visited[temp.x][temp.y+1] = true;
      }
    }
    return minHeap.poll().sum;
  }

  public class Sum{
    int x;
    int y;
    int sum;
    
    public Sum (int x, int y, int sum) {
      this.x = x;
      this.y = y;
      this.sum = sum;
    }
  }
  
  public int power(int a, int b) {
    if (b == 0) return 1;
    int half = power(a, b/2);
    if (b % 2 == 0) {
      return half*half;
    } else {
      return half*half*a;
    }
  }
}
