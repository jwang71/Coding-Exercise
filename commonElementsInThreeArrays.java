  public List<Integer> common(int[] a, int[] b, int[] c) {
    List<Integer> list = new ArrayList<>();
    
    int ia = 0;
    int ib = 0;
    int ic = 0;
    
    while (ia < a.length && ib < b.length && ic < c.length) {
      if (a[ia] == b[ib] && b[ib] == c[ic]) {
        list.add(a[ia]);
        ia++;
        ib++;
        ic++;
      } else if (a[ia] <= b[ib] && a[ia] <= c[ic]) {
        ia++;
      } else if (b[ib] <= a[ia] && b[ib] <= c[ic]) {
        ib++;
      } else {
        ic++;
      }
    }
    return list;
  }
