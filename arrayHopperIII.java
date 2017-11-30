public class Solution {
  public int minJump(int[] array) {
    int len = array.length;
    int[] m = new int[len];
    boolean[] n = new boolean[len];
    m[len - 1] = 1;
    if (array[len - 1] >= 1) {
      n[len - 1] = true;
    }
    
    for (int i = len - 2; i >= 0; i--) {
      if (i + array[i] >= len) {
        n[i] = true;
        m[i] = 1;
        continue;
      }
      m[i] = Integer.MAX_VALUE - 1;
      for (int j = i + 1; j <= i + array[i]; j++) {
        if (n[j] == true) {
          n[i] = true;
        }
        m[i] = Math.min(m[i], m[j] + 1);
      }
    }
    return n[0] ? m[0] : -1;
  }
}

