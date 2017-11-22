  public List<List<Integer>> allPairs(int[] array, int target) {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    if (array == null || array.length < 2) return res;

    Map<Integer, List<Integer>> map = new HashMap<>();
    
    for (int i = 0; i < array.length; i++) {
      if (map.containsKey(target - array[i])) {
        List<Integer> list = map.get(target-array[i]);
        for (int index : list) {
          res.add(Arrays.asList(index, i));
        }
      } 
      List<Integer> list;
      if (!map.containsKey(array[i])) {
        list = new ArrayList<>();
      } else {
        list = map.get(array[i]);
      }
      list.add(i);
      map.put(array[i], list);
    }
    return res;
  }
