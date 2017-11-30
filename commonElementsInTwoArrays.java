  public List<Integer> common(List<Integer> a, List<Integer> b) {
    List<Integer> list = new ArrayList<>();
    if (a == null || b == null) return list;
    Collections.sort(a);
    Collections.sort(b);
    int ai = 0;
    int bi = 0;
    while (ai < a.size() && bi < b.size()) {
      if (a.get(ai) < b.get(bi)) {
        ai++;
      } else if (a.get(ai) > b.get(bi)) {
        bi++;
      } else {
        list.add(a.get(ai));
        ai++;
        bi++;
      }
    }
    return list;
  }