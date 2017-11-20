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
  public int max = Integer.MIN_VALUE;
  public int maxPathSum(TreeNode root) {
    // Write your solution here.
    if (root == null) {
      return max;
    }
    helper(root);
    return max;
  }
  
  public int helper(TreeNode root) {
    if (root ==null) return 0;
    int left = helper(root.left);
    int right = helper(root.right);
    left = left < 0 ? 0 : left;
    right = right < 0 ? 0 : right;
    
    int cur = root.key + left + right;
    max = cur > max ? cur : max;
    return root.key + Math.max(left, right);
  }
