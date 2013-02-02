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

public class MaxPathSum {

	public static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      public TreeNode(int x) { val = x; }
	}
	
	private int maxsum;

	/**
	 *  Given a binary tree, find the maximum path sum.

		The path may start and end at any node in the tree.
	
		For example:
		Given the below binary tree,

	       	 1
      		/ \
	       2   3

	 * 	@author Adityanarayan M Vaidya
 	 *
 	 */

	public int maxPathSum(TreeNode root) {
		
		if (root!=null) {
			maxsum=root.val;
			mPathSum(root);
		}
		
		return maxsum;
	}
	
	private int mPathSum(TreeNode root) {
		
		if (root.right == null && root.left == null) {
			return root.val;
		} else if (root.right==null && root.left!=null) {
			
			int ls = mPathSum(root.left);
			int tmpsum = Math.max(Math.max(root.val, ls),root.val+ls);
			if (tmpsum>maxsum)
				maxsum=tmpsum;
			
			return Math.max(root.val, root.val+ls);
			
		} else if (root.right!=null && root.left==null) {
			
			int rs = mPathSum(root.right);
			int tmpsum = Math.max(Math.max(root.val, rs),root.val+rs);
			if (tmpsum>maxsum)
				maxsum=tmpsum;
			
			return Math.max(root.val, root.val+rs);
			
		} else {
			
			int rs = mPathSum(root.right);
			int ls = mPathSum(root.left);
			/*
			 * Find the max path among left path, right path and 
			 * current node.
			 */
			int tmpsum = Math.max(root.val, rs);
			tmpsum = Math.max(tmpsum,ls);
			tmpsum = Math.max(tmpsum, root.val+rs);
			tmpsum = Math.max(tmpsum, root.val+ls);
			tmpsum = Math.max(tmpsum, root.val+rs+ls);
			
			if (tmpsum>maxsum)
				maxsum=tmpsum;
			
			return Math.max(Math.max(root.val, root.val+rs),root.val+ls);
			
		}
	}
		
	public static void main(String[] args) {

		TreeNode root = new TreeNode(1);
		
		root.right = new TreeNode(-3);
		
		root.left = new TreeNode(-2);
		
		root.right.left = new TreeNode(-2);		
		
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);
		
		root.left.left.left = new TreeNode(-1);
		MaxPathSum mps = new MaxPathSum();
		System.out.println(mps.mPathSum(root));
	}

}
