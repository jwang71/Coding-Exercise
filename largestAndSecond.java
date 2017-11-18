public class Solution {
  public int[] largestAndSecond(int[] array) {
    // Write your solution here.
    // The first element is the largest number,
    // the second element is the second largest number.
    
    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < array.length; i++) {
      list.add(array[i]);
    }
    
    Map<Integer, List<Integer>> map = new HashMap<>();
    while (list.size() > 1) {
      List<Integer> nextRound = new ArrayList<>();
      for (int i = 0; i < list.size(); i+=2) {
        if(i == list.size() - 1) {
          nextRound.add(list.get(i));
        } else {
          if (list.get(i) > list.get(i + 1)) {
            nextRound.add(list.get(i));
            
            if (map.containsKey(list.get(i))) {
              List<Integer> temp = map.get(list.get(i));
              temp.add(list.get(i+1));
              map.put(list.get(i), temp);
            } else {
              List<Integer> temp = new ArrayList<>();
              temp.add(list.get(i+1));
              map.put(list.get(i), temp);
            }
            
          } else {
            nextRound.add(list.get(i+1));

            if (map.containsKey(list.get(i+1))) {
              List<Integer> temp = map.get(list.get(i+1));
              temp.add(list.get(i));
              map.put(list.get(i+1), temp);
            } else {
              List<Integer> temp = new ArrayList<>();
              temp.add(list.get(i));
              map.put(list.get(i+1), temp);
            }
          }
        }
      }
      list = nextRound;
    }
    
    int[] res = new int[2];
    res[0] = list.get(0);
    res[1] = getMax(map.get(list.get(0)));
    return res;
  }
  
  public int getMax(List<Integer> list) {
    int res = list.get(0);
    for (int i : list) {
      res = Math.max(res, i);
    }
    return res;
  }
  
}
