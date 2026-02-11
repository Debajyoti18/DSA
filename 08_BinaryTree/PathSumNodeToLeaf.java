class Solution {

    public int maxPathSum(TreeNode root) {
        int[] ans = new int[1];
        ans[0] = Integer.MIN_VALUE;

        maxPathSumHelp(root, ans);
        return ans[0];
    }

    public int maxPathSumHelp(TreeNode root, int[] ans) {

        if (root == null)
            return 0;

        int left = Math.max(0, maxPathSumHelp(root.left, ans));
        int right = Math.max(0, maxPathSumHelp(root.right, ans));

        // update global maximum (path through root)
        ans[0] = Math.max(ans[0], left + right + root.val);

        // return best single-branch path to parent
        return root.val + Math.max(left, right);
    }
}
