package practice;

public class TreeTest {
	 public class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
	public TreeNode constructMaximumBinaryTree(int[] nums) {
		int startPos = 0;
		int endPos = nums.length - 1;
		TreeNode root = construct(nums, startPos, endPos);
		return root;
	}
	public TreeNode construct(int[] nums, int start, int end) {
		if (start > end) {
			return null;
		}
		int maxIndex = findMaxIndex(nums, start, end);
		TreeNode node = new TreeNode(nums[maxIndex]);
		node.left = construct(nums, start, maxIndex - 1);
		node.right = construct(nums, maxIndex + 1, end);
		return node;

	}
	public int findMaxIndex(int[] nums, int start, int end) {
		int max = start;
		for (int i = start; i <= end; ++i) {
			if (nums[max] < nums[i])
				max = i;
		}
		return max;
	}
	/* Find bottom left tree value */
    int leftMost = 0;
    int maxDepth = 0;
    public int findBottomLeftValue(TreeNode root) {
        traverse(root, 1);    
        return leftMost;
    }
    public void traverse(TreeNode root, int depth) {
        if (root == null)
            return;
        if (depth > maxDepth) {
            leftMost = root.val;
            maxDepth = depth;
        }
        traverse(root.left, depth+1);
        traverse(root.right, depth+1);
    }
}
