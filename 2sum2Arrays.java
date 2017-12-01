
  public boolean existSum(int[] a, int[] b, int target) {
    Arrays.sort(a);
    Arrays.sort(b);
    int i = 0;
    int j = b.length - 1;
    while (i < a.length && j >= 0) {
      int val = a[i] + b[j];
      if (val == target) {
        return true;
      } else if (val < target) {
        i++;
      } else {
        j--;
      }
    }
    return false;
  }
