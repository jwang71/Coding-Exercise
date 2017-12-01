
public class Solution {
  TreeNode first = null;
  TreeNode second = null;
  TreeNode pre = new TreeNode(Integer.MIN_VALUE);
  
  public TreeNode recover(TreeNode root) {
    if (root == null) return root;
    inorder(root);
    int temp = first.key;
    first.key = second.key;
    second.key = temp;
    return root;
  }
  
  public void inorder(TreeNode root) {
    if (root == null) return;
    inorder(root.left);
    if (first == null && pre.key >= root.key) {
      first = pre;
    }
    if (first != null && pre.key >= root.key) {
      second = root;
    }
    pre = root;
    inorder(root.right);
  }
}
