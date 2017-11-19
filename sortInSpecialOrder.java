  public int[] sortSpecial(int[] A1, int[] A2) {
    if (A1.length == 0) return A1;
    
    for (int i = 0; i < A1.length; i++) {
      int global = i;
      for (int j = i; j < A1.length; j++) {
        if (isSmaller(A1[j], A1[global], A2)) {
          global = j;
        }
      }
      int temp = A1[i];
      A1[i] = A1[global];
      A1[global] = temp;
    }
    return A1;
  }
  
  public boolean isSmaller(int a, int b, int[] array) {
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < array.length; i++) {
      map.put(array[i], i);
    }
    
    if (map.containsKey(a) && map.containsKey(b)) {
      if (map.get(a) < map.get(b)) {
        return true;
      }
    } else if (map.containsKey(a)) {
      return true;
    } else if (map.containsKey(b)){
      return false;
    } else {
      return a < b;
    }
    return false;
  }
