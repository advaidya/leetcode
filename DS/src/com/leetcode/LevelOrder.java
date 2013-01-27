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
import java.util.ArrayList;

public class LevelOrder {

	public static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      public TreeNode(int x) { val = x; }
	}
	
	public int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		} else {
			if (root.left == null && root.right == null) {
				return 1;
			} else if (root.left == null && root.right != null) {
				return 1 + maxDepth(root.right);
			} else if (root.left != null && root.right == null) {
				return 1 + maxDepth(root.left);
			} else {
				return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
			}
		}		       
    }
	
	/*
	 * Given a binary tree, return the level order traversal of 
	 * its nodes' values. (ie, from left to right, level by level).

		For example:
		Given binary tree {3,9,20,#,#,15,7},

    3
   / \
  9  20
    /  \
   15   7
   
   return its level order traversal as:

	[
  		[3],
  		[9,20],
  		[15,7]
	]
	 */
	
	public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
		
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();		
		int d = maxDepth(root);
		for (int i=0;i<d;i++) {
			list.add(new ArrayList<Integer>());
		}
		levelOrder(list,root,0);
		
		return list;		
    }
	
	private void levelOrder(ArrayList<ArrayList<Integer>> list, TreeNode n, int depth) {
		
		if (n == null)
			return;
		
		ArrayList<Integer> l = list.get(depth);		
		
		l.add(n.val);
		
		levelOrder(list, n.left, 1+depth);
		levelOrder(list, n.right, 1+depth);
	}

}
