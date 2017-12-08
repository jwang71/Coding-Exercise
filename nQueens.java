public class Solution {
  public List<List<Integer>> nqueens(int n) {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    if (n <= 0) return res;
    dfs(n, 0, list, res);
    return res;
  }
  
  public void dfs(int n, int index, List<Integer> list, List<List<Integer>> res) {
    if (n == index) {
      res.add(new ArrayList<>(list));
      return;
    }
    
    for (int i = 0; i < n; i++) {
      list.add(i);
      if (isValid(list)) {
        dfs(n, index+1, list, res);
      }
      list.remove(list.size() - 1);
    }
  }
  
  public boolean isValid(List<Integer> list) {
    int index = list.size() - 1;
    for (int i = index - 1; i >= 0; i--) {
      if (list.get(i) == list.get(index) || Math.abs(i - index) == Math.abs(list.get(i) - list.get(index))) {
        return false;
      }
    }
    return true;
  }
}
