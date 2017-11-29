  public int maxTrapped(int[] array) {
    if (array.length == 0) return 0;
    int[] left = new int[array.length];
    int[] right = new int[array.length];
    left[0] = 0;
    right[array.length - 1] = 0;
    
    for (int i = 1; i < array.length; i++) {
      left[i] = Math.max(left[i-1], array[i - 1]);
    }
    
    for (int i = array.length - 2; i >= 0; i--) {
      right[i] = Math.max(right[i + 1], array[i + 1]);
    }
    
    int res = 0;
    for (int i = 0; i < array.length; i++) {
      int h = Math.min(left[i], right[i]);
      if (h > array[i]) {
        res += (h - array[i]);
      } 
    }
    return res;
  }
