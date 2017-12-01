
public class Solution {
  public TreeNode lowestCommonAncestor(TreeNode root,
      TreeNode one, TreeNode two) {
    if (root == null || !find(root, one) || !find(root, two)) return null;
    return lca(root, one, two);
  }
  
  public TreeNode lca(TreeNode root, TreeNode one, TreeNode two) {
    if (root == null || root == one || root == two) return root;
    TreeNode left = lca(root.left, one, two);
    TreeNode right = lca(root.right, one, two);
    if (left == null && right == null) return null;
    if (left != null && right != null) return root;
    return left == null ? right : left;
  }
  
  public boolean find(TreeNode root,  TreeNode node) {
    if (root == null) return false;
    if (root == node) return true;
    return find(root.left, node) || find(root.right, node);
  }
}
