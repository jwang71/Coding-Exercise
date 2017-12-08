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
  public boolean isBST(TreeNode root) {
    return helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }
  public boolean helper(TreeNode root, int min, int max) {
    if (root == null) return true;
    if (root.key <= min || root.key >= max) {return false;}
    return helper(root.left, min, root.key) && helper(root.right, root.key, max);
  }
}
