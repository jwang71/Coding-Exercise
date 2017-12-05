public class Solution {
  public List<Integer> allAnagrams(String s, String l) {
    List<Integer> list = new ArrayList<>();
    
    int i = 0;
    while (i <= l.length() - s.length()) {
      if (isAnagram(l.substring(i, i + s.length()), s)) {
        list.add(i);
      }
      i++;
    }
    return list;
  }
  
  public boolean isAnagram(String a, String b) {
    Map<Character, Integer> amap = new HashMap<>();

    for (int i = 0; i < a.length(); i++) {
      if (amap.containsKey(a.charAt(i))) {
        amap.put(a.charAt(i), amap.get(a.charAt(i)) + 1);
      } else {
        amap.put(a.charAt(i), 1);
      }
    }
    
    for (int i = 0; i < b.length(); i++) {
      if (!amap.containsKey(b.charAt(i))) {
        return false;
      } else {
        amap.put(b.charAt(i), amap.get(b.charAt(i)) - 1);
      }
    }
    
    for (Map.Entry<Character, Integer> entry : amap.entrySet()) {
      if (entry.getValue() != 0) {
        return false;
      }
    }
    return true;
  }
}
