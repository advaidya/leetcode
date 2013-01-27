package com.leetcode;


public class MinDepth {

	public static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      public TreeNode(int x) { val = x; }
	}
	
	
	public int minDepth(TreeNode root) {
		if (root == null) {
			return 0;
		} else {
			if (root.left == null && root.right == null) {
				return 1;
			} else if (root.left == null && root.right != null) {
				return 1 + minDepth(root.right);
			} else if (root.left != null && root.right == null) {
				return 1 + minDepth(root.left);
			} else {
				return 1 + Math.min(minDepth(root.left), minDepth(root.right));
			}
		}		       
    }
	
	public static void main(String[] args) {

		TreeNode n = new TreeNode(1);
		n.left = new TreeNode(2);
		
		System.out.println(new MinDepth().minDepth(n));
		
	}

}
