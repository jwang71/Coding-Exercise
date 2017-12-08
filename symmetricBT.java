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
  public boolean isSymmetric(TreeNode root) {
    // Write your solution here.
    if (root == null) return true;
    return helper(root.left, root.right);
  }
  
  public boolean helper(TreeNode one, TreeNode two) {
    if (one == null && two == null) return true;
    if (one == null || two == null || one.key != two.key) return false;
    return helper(one.left, two.right) && helper(one.right, two.left);
  }
}
