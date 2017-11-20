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
  public boolean exist(TreeNode root, int target) {
    List<TreeNode> list = new ArrayList<>();
    return helper(root, target, list);
  }
  
  public boolean helper(TreeNode root, int target, List<TreeNode> list) {
    if (root == null) return false;
    list.add(root);
    if (check(list, target)) {
      return true;
    }
    if (helper(root.left, target, list) || helper(root.right, target, list)) {
      return true;
    }
    list.remove(list.size() - 1);
    return false;
  }
  
  public boolean check(List<TreeNode> list, int target) {
    int sum = 0;
    for (int i = list.size() - 1; i >= 0; i--) {
      sum += list.get(i).key;
      if (sum == target) {
        return true;
      }
    }
    return false;
  }
  
