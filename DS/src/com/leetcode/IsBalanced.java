package com.leetcode;

public class IsBalanced {

	public static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      public TreeNode(int x) { val = x; }
	}
	
	/*
	 * Given a binary tree, determine if it is height-balanced.
	 * 
	 * For this problem, a height-balanced binary tree is defined
	 *  as a binary tree in which the depth of the two subtrees of 
	 *  every node never differ by more than 1. 
	 */
	public boolean isBalanced(TreeNode root) {
		
		if (root == null)
			return true;
		else {
			int ld = depth(root.left);
			int rd = depth(root.right);
			if (ld-rd == 1 || ld-rd == 0 || ld-rd == -1)
				return isBalanced(root.left) && isBalanced(root.right);
			else 
				return false;
		}			
	}
	
	private int depth(TreeNode n) {
	
		if (n == null) {
			return 0;
		} else {
			if (n.left == null && n.right == null) {
				return 1;
			} else if (n.left != null && n.right == null) {
				return 1 + depth(n.left);
			} else if (n.left == null && n.right != null) {
				return 1 + depth(n.right);
			} else {
				return 1 + Math.max(depth(n.left), depth(n.right));
			}
		}
	}
	 
	public static void main(String[] args) {

		TreeNode n = new TreeNode(1);
		n.left = new TreeNode(2);
		
		n.right = new TreeNode(3);
		n.right.right = new TreeNode(6);
		n.right.right.right = new TreeNode(8);
		
		n.left.left = new TreeNode(4);
		n.left.right = new TreeNode(5);
		
		n.left.left.left = new TreeNode(7);
				
		IsBalanced ib = new IsBalanced();
		System.out.println(ib.isBalanced(n));
	}

}
