public boolean isIdentical(TreeNode one, TreeNode two) {
	if (one == null && two == null) return true;
	if (one == null || two == null || one.key != two.key) return false;

	return isIdentical(one.left, two.left) && isIdentical(one.right, two.right);
}

//  public int findHeight(TreeNode root) {
// 	 if (root == null) return 0;
// 	 int left = findHeight(root.left);
// 	 int right = findHeight(root.right);
	 
// 	 return Math.max(left, right) + 1;
// }