public void findSum(TreeNode root, int sum) {
	if (root == null) return;
	int depth = getHeight(root);
	int[] path = new int[depth];
	findSum(root, sum, path, 0);
}


public void findSum(TreeNode root, int sum, int[] path, int level) {
	if (root == null) return;
	path[level] = root.value;
	int t = 0;
	for (int i = leivel; i>= 0; i--) {
		t += path[i];
		if (t == sum) {
			print();
		}
	}

	findSum(root, sum, path, level+ 1);
	findSum(root, sum, path, level + 1);
}


