public TreeNode lca(TreeNode root, TreeNode a, TreeNode b) {
	if (root == null) return null;
	if (a == root && b == root) return root;
	if (a == null || b == null) {
		return a == null ? b : a;
	}

	TreeNode left = lca(root.left, a, b);
	TreeNode right = lca(root.right, a, b);
	if (left != null && right != null) {
		return root;
	} else if (root == a || root == b) {
		return root == a ? a : b;
	}
	retu
}