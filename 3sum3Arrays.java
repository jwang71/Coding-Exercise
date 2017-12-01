  public boolean exist(int[] a, int[] b, int[] c, int target) {
    Arrays.sort(a);
    Arrays.sort(b);
    Arrays.sort(c);
    for (int i = 0; i < a.length; i++) {
      int j = 0;
      int k = c.length - 1;
      while (j < b.length && k >= 0) {
        int val = a[i] + b[j] + c[k];
        if (val == target) {
          return true;
        } else if (val < target) {
          j++;
        } else {
          k--;
        }
      }
    }
    return false;
  }