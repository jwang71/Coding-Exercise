public class Solution {
  public int max = Integer.MIN_VALUE;
  public int maxPathSum(TreeNode root) {
    if (root == null) return max;
    helper(root);
    return max;
  }
  public int helper(TreeNode root) {
    if (root == null) return 0;
    int left = helper(root.left);
    int right = helper(root.right);
    left = left < 0 ? 0 : left;
    right = right < 0 ? 0 : right;
    int cur = Math.max(left, right) + root.key;
    max = Math.max(cur, max);
    return cur;
  }
}