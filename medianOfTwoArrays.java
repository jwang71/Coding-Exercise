  public double median(int[] a, int[] b) {
    Arrays.sort(a);
    Arrays.sort(b);
    int len = a.length + b.length;
    if (len % 2 == 0) {
      return (helper(a, 0, b, 0, len/2) + helper(a, 0, b, 0, len/2+1))/2.0;
    } else {
      return helper(a, 0, b, 0, len/2 + 1);
    }
  }
  
  public double helper(int[] a, int a_start, int[] b, int b_start, int k) {
    if (a_start >= a.length) return b[b_start + k - 1];
    if (b_start >= b.length) return a[a_start + k - 1];
    if (k == 1) return Math.min(a[a_start], b[b_start]);
    
    int aval = a_start + k/2 - 1 >= a.length ? Integer.MAX_VALUE : a[a_start + k/2 -1];
    int bval = b_start + k/2 - 1 >= b.length ? Integer.MAX_VALUE : b[b_start + k/2 -1];
    if (aval > bval) {
      return helper(a, a_start, b, b_start + k/2, k-k/2);
    } else {
      return helper(a, a_start+k/2, b, b_start, k-k/2);
    }
  }

