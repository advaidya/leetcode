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
