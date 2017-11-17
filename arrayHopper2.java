  public int minJump(int[] array) {
    int len = array.length;
    boolean[] n = new boolean[len];
    int[] m = new int[len];
    
    n[len - 1] = true;
    m[len - 1] = 0;
    
    for (int i = len - 2; i >= 0; i--) {
      if (i + array[i] >= len - 1) {
        n[i] = true;
        m[i] = 1;
        continue;
      }
      m[i] = Integer.MAX_VALUE - 1;
      
      for (int j = i; j <= i + array[i]; j++) {
        if (n[j]) {
          n[i] = true;
        }
        m[i] = Math.min(m[i], m[j] + 1);
      }
    }
    return n[0] == true ? m[0] : -1;
  }