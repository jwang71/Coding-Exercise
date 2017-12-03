public class Solution {
  public int missing(int[] array) {
    if (array == null || array.length == 0) return 1;
    Set<Integer> set = new HashSet<>();
    int n = array.length;
    
    for (int i = 0; i < n; i++) {
      set.add(array[i]);
    }
    
    for (int i = 1; i <= n + 1; i++) {
      if (!set.contains(i)) {
        return i;
      }
    }
    return 1;
  }
}
