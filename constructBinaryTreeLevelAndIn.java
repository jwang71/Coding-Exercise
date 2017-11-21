/**
 * public class TreeNode {
 *   public int key;
 *   public TreeNode left;
 *   public TreeNode right;
 *   public TreeNode(int key) {
 *     this.key = key;
 *   }
 * }
 */
  public TreeNode reconstruct(int[] in, int[] level) {
    if (in == null || level == null || in.length != level.length) {
      return null;
    }
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < in.length; i++) {
      map.put(in[i], i);
    }
    
    List<Integer> list = new ArrayList<>();
    for (int i : level) {
      list.add(i);
    }
    
    return helper(in, 0, in.length - 1, list, map);
  }
  
  public TreeNode helper(int[] in, int in_start, int in_end, List<Integer> list,
    Map<Integer, Integer> map) {
    if (in_start > in_end) return null;
    
    TreeNode root = new TreeNode(list.get(0));
    int index = map.get(root.key);
    
    List<Integer> leftList = new ArrayList<>();
    List<Integer> rightList = new ArrayList<>();
    
    Set<Integer> set = new HashSet<>();
    for (int i = in_start; i < index; i++) {
      set.add(in[i]);
    }
    
    for (int i = 1; i < list.size(); i++) {
      if (set.contains(list.get(i))) {
        leftList.add(list.get(i));
      } else {
        rightList.add(list.get(i));
      }
    }
    
    root.left = helper(in, in_start, index - 1, leftList, map);
    root.right = helper(in, index + 1, in_end, rightList, map);
    return root;
  }