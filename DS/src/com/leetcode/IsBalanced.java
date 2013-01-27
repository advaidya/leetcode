package com.leetcode;

/**
Copyright (c) <2013> <Adityanarayan M Vaidya>
Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files
(the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify,
merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished
to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE
FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
**/
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
