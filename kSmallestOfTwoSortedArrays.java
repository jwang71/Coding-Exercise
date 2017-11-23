  public int kth(int[] a, int[] b, int k) {
    int ia = 0;
    int ib = 0;
    int result = Integer.MAX_VALUE;
    k = k - 1;
    
    while (k > 0 && ia < a.length && ib < b.length) {
      if (a[ia] < b[ib]) {
        ia++;
      } else {
        ib++;
      }
      k--;
    }
    
    while (k > 0 && ia < a.length) {
      k--;
      ia++;
    }
    while (k > 0 && ib < b.length) {
      k--;
      ib++;
    }
    
    if (ia == a.length) {
      return b[ib];
    } 
    if (ib == b.length) {
      return a[ia];
    }

    return Math.min(a[ia], b[ib]);
  }


//solution 2
  public int kthSolution2(int[] a, int[] b, int k) {
    return helper(a, 0, b, 0, k);
  }
  
  public int helper(int[] a, int a_start, int[] b, int b_start, int k) {
    if (a_start >= a.length) return b[b_start + k - 1];
    if (b_start >= b.length) return a[a_start + k - 1];
    if (k == 1) return Math.min(a[a_start], b[b_start]);
    
    int aval = a_start + k/2 - 1 >= a.length? Integer.MAX_VALUE : a[a_start + k/2 - 1];
    int bval = b_start + k/2 - 1 >= b.length? Integer.MAX_VALUE : b[b_start + k/2 - 1];
    if (aval > bval) {
      return helper(a, a_start, b, b_start + k/2, k - k/2);
    } else {
      return helper(a, a_start + k/2, b, b_start, k - k/2);
    }
  }
