  public int[] merge(int[][] arrays) {
    if (arrays == null || arrays.length == 0) {
      return new int[]{};
    }
    return helper(arrays, 0, arrays.length - 1);
  }
  
  public int[] helper(int[][] arrays, int start, int end) {
    if (start >= end) return arrays[start];
    int mid = start + (end - start)/2;
    int[] left = helper(arrays, start, mid);
    int[] right = helper(arrays, mid + 1, end);
    return merge(left, right);
  }
  
  public int[] merge(int[] left, int[] right) {
    int m = left.length;
    int n = right.length;
    int[] result = new int[m + n];
    
    int i = 0;
    int j = 0;
    int count = 0;
    while (i < m && j < n) {
      if (left[i] < right[j]) {
        result[count++] = left[i++];
      } else {
        result[count++] = right[j++];
      }
    }
    
    while (i < m) {
      result[count++] = left[i++];
    }
    while (j < n) {
      result[count++] = right[j++];
    }
    return result;
  }
