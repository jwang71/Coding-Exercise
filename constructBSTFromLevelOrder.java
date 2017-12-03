
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
public class Solution {
  public TreeNode reconstruct(int[] level) {
    if (level == null || level.length == 0) return null;
    List<Integer> list = new ArrayList<>();
    for (int i : level) {
      list.add(i);
    }
    return helper(list, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }
  
  public TreeNode helper(List<Integer> level, int min, int max) {
    if (level == null || level.size() == 0) return null;
    if (level.size() == 1) return new TreeNode(level.get(0));
    int rootVal = level.get(0);
    TreeNode root = new TreeNode(rootVal);
    
    List<Integer> left = new ArrayList<>();
    List<Integer> right = new ArrayList<>();
    
    for (int i = 1; i < level.size(); i++) {
      if (level.get(i) < rootVal && level.get(i) > min) {
        left.add(level.get(i));
      } else {
        right.add(level.get(i));
      }
    }
    
    root.left = helper(left, min, rootVal);
    root.right = helper(right, rootVal, max);
    return root;
  }
}
