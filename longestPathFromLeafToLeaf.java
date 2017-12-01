public class Solution {
  private int max = 0;
  public int diameter(TreeNode root) {
    if (root == null) return max;
    helper(root);
    return max;
  }
  
  public int helper(TreeNode root) {
    if (root == null) return 0;
    int left = helper(root.left);
    int right = helper(root.right);
    int cur = left + right + 1;
    if (root.left != null && root.right != null) {
      max = Math.max(max, cur);
    }
    return Math.max(left, right) + 1;
  }
}