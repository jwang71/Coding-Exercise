public class Solution {
  public int[] kSmallest(int[] array, int k) {
    if (k == 0) return new int[]{};
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, new Comparator<Integer>(){
      public int compare(Integer i1, Integer i2) {
        if (i1 == i2) return 0;
        return i1 > i2 ? -1 : 1;
      }
    });
    
    for (int i : array) {
      if (maxHeap.size() < k) {
        maxHeap.offer(i);
      } else {
        if (i < maxHeap.peek()) {
          maxHeap.poll();
          maxHeap.offer(i);
        }
      }
    }
    int[] res = new int[k];
    for (int i = k -1; i>=0; i--) {
      res[i] = maxHeap.poll();
    }
    return res;
  }
}
