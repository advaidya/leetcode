package com.leetcode;

import com.leetcode.IsBalanced.TreeNode;

public class MaxDepth {
	
	private int maxDepth(TreeNode n) {
		
		if (n == null) {
			return 0;
		} else {
			if (n.left == null && n.right == null) {
				return 1;
			} else if (n.left != null && n.right == null) {
				return 1 + maxDepth(n.left);
			} else if (n.left == null && n.right != null) {
				return 1 + maxDepth(n.right);
			} else {
				return 1 + Math.max(maxDepth(n.left), maxDepth(n.right));
			}
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		TreeNode n = new TreeNode(1);
		n.left = new TreeNode(2);
		
		System.out.println(new MaxDepth().maxDepth(n));
	}

}
