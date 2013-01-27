package com.leetcode;

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
