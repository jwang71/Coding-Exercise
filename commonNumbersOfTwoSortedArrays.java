public class Solution {
  public List<Integer> common(List<Integer> A, List<Integer> B) {
    List<Integer> list = new ArrayList<>();
    if (A == null || B == null || A.size() == 0 || B.size() == 0) return list;
    
    int ia = 0;
    int ib = 0;
    
    while (ia < A.size() && ib < B.size()) {
      if (A.get(ia) == B.get(ib)) {
        list.add(A.get(ia));
        ia++;
        ib++;
      } else if (A.get(ia) < B.get(ib)) {
        ia++;
      } else {
        ib++;
      }
    }
    return list;
  }
}
