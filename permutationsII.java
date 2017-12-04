public class Solution {
  public List<String> permutations(String set) {
    List<String> res = new ArrayList<>();
    if (set == null) return res;
    char[] array = set.toCharArray();
    dfs(array, 0, res);
    return res;
  }
  
  public void dfs(char[] array, int index, List<String> res) {
    if (index == array.length) {
      res.add(new String(array));
    }
    
    Set<Character> hashset = new HashSet<>();
    
    for (int i = index; i < array.length; i++) {
      if (!hashset.contains(array[i])) {
        hashset.add(array[i]);
        swap(array, index, i);
        dfs(array, index + 1, res);
        swap(array, index, i);
      }
    }
  }

  public void swap(char[] array, int i, int j) {
    char c = array[i];
    array[i] = array[j] ;
    array[j] = c;
  }
}
