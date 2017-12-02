
public class Solution {
  public List<Integer> majority(int[] array, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    
    for (int i = 0; i < array.length; i++) {
      if (map.containsKey(array[i])) {
        map.put(array[i], map.get(array[i]) + 1);
      } else if (map.size() < k) {
        map.put(array[i], 1);
      } else {
        List<Integer> keys = new ArrayList<>();
        for (int key : map.keySet()) {
          keys.add(key);
        }
        for (int key : keys) {
          map.put(key, map.get(key) - 1);
          if (map.get(key) == 0) {
            map.remove(key);
          }
        }
      }
    }
    
    for (int key : map.keySet()) {
      map.put(key, 0);
    }
    
    for (int i : array) {
      if (map.containsKey(i)) {
        map.put(i, map.get(i) + 1);
      }
    }
    
    List<Integer> res = new ArrayList<>();
    for (int key : map.keySet()) {
      if (map.get(key) > array.length / k) {
        res.add(key);
      }
    }
    Collections.sort(res);
    return res;
  }
}
