public class Solution {
  public String[] topKFrequent(String[] combo, int k) {
    if (combo == null || combo.length == 0) return new String[]{};
    
    Map<String, Integer> map = new HashMap<>();
    for (String s : combo) {
      if (!map.containsKey(s)) {
        map.put(s, 1);
      } else {
        map.put(s, map.get(s) + 1);
      }
    }
    
    PriorityQueue<String> minHeap = new PriorityQueue<>(k, new Comparator<String>(){
      public int compare(String s1, String s2) {
        if (map.get(s1) == map.get(s2)) return 0;
        return map.get(s1) < map.get(s2) ? -1 : 1;
      }
    });
    
    for (Map.Entry<String, Integer> entry : map.entrySet()) {
      if (minHeap.size() < k) {
        minHeap.offer(entry.getKey());
      } else {
        if (entry.getValue() > map.get(minHeap.peek())) {
          minHeap.poll();
          minHeap.offer(entry.getKey());
        }
      }
    }
    List<String> list = new ArrayList<>();
    while (!minHeap.isEmpty()) {
      list.add(minHeap.poll());
    }
    Collections.reverse(list);
    return list.toArray(new String[0]);
  }
}
