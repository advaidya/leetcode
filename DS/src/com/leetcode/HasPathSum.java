package com.leetcode;

import java.util.ArrayList;

public class HasPathSum {

		public static class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      public TreeNode(int x) { val = x; }
		}
		
		/*
		 *  Given a binary tree and a sum, determine if the tree
		 *   has a root-to-leaf path such that adding up all the 
		 *   values along the path equals the given sum.
		 *   For example:
		 *   Given the below binary tree and sum = 22,

              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
        
        return true, as there exist a root-to-leaf path 
        5->4->11->2 which sum is 22.
		 */
		public boolean hasPathSum(TreeNode n, int sum) {
			if (n == null)
				return false;
			else
				return hasSum(n, sum);
									
		}

		private boolean hasSum(TreeNode n, int sum) {
			if (n.left == null && n.right == null) {
				if (sum-n.val == 0)
					return true;
				else
					return false;
			} else if (n.left == null && n.right != null) {
				return hasPathSum(n.right, sum-n.val);
			} else if (n.left != null && n.right == null) {
				return hasPathSum(n.left, sum-n.val);
			} else {
				return (hasPathSum(n.left, sum-n.val) || hasPathSum(n.right, sum-n.val)) ? true : false;
			}
		}
		
		/*
		 *  Given a binary tree and a sum, find all root-to-leaf 
		 *  paths where each path's sum equals the given sum.
		 *  For example: 
		 *  Given the below binary tree and sum = 22,

              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
        
        return
        [
        	[5,4,11,2],
        	[5,8,4,5]
        	
        ]

		 */
		public ArrayList<ArrayList<Integer>> pathSum(TreeNode n, int sum) {			
		
			ArrayList<ArrayList<Integer>> al = new ArrayList<ArrayList<Integer>>();
			if (n == null)
				return al;
			pSum(n, sum, al);
			
			return al;
	        
	    }
		
		private ArrayList<ArrayList<Integer>> pSum(TreeNode n, int sum, ArrayList<ArrayList<Integer>> al) {
			if (n.left == null && n.right == null) {
				if (sum-n.val == 0) {
					ArrayList<Integer> l = new ArrayList<Integer>();
					l.add(n.val);
					al.add(l);					
				}				
				return al;				
			} else if (n.left == null && n.right != null) {
				int bs = al.size();
				ArrayList<ArrayList<Integer>> r = pSum(n.right, sum-n.val, al);
				
				for (int i=bs;i<r.size();i++) {
					ArrayList<Integer> list = r.get(i);
					if (list.size()>0) {
						list.add(0, n.val);
					}
				}
				return al;
			} else if (n.left != null && n.right == null) {
				int bs = al.size();
				ArrayList<ArrayList<Integer>> l = pSum(n.left, sum-n.val, al);
				
				for (int i=bs;i<l.size();i++) {
					ArrayList<Integer> list = l.get(i);
					if (list.size()>0) {
						list.add(0, n.val);
					}
				}
				return al;
				
			} else {
				int bs = al.size();
				
				ArrayList<ArrayList<Integer>> ls = pSum(n.left, sum-n.val, al);
				
				for (int i=bs;i<ls.size();i++) {
					ArrayList<Integer> list = ls.get(i);
					if (list.size()>0) {
						list.add(0, n.val);
					}
				}
				
				bs = al.size();
				ArrayList<ArrayList<Integer>> rs =  pSum(n.right, sum-n.val, al);				
				
				for (int i=bs;i<rs.size();i++) {
					ArrayList<Integer> list = rs.get(i);
					if (list.size()>0) {
						list.add(0, n.val);
					}
				}
				
				return al;
					
			}
		}
		
		public static void main(String[] args) {
			
			TreeNode root = new TreeNode(1);
			
			root.left = new TreeNode(-2);
			root.right = new TreeNode(-3);
			
			root.right.right = new TreeNode(-2);
			
			root.left.left = new TreeNode(1);
			root.left.right = new TreeNode(3);
			
			root.left.left.right = new TreeNode(-1);
			
			HasPathSum hps = new HasPathSum();
			ArrayList<ArrayList<Integer>> l = hps.pathSum(root, 2);
			
			
			for (ArrayList<Integer> il : l) {
				for (Integer v : il) {
					System.out.println(v);
				}
				System.out.println("-");
			}
			
		}

}
