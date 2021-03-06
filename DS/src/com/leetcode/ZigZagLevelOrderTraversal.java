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
import java.util.PriorityQueue;
import java.util.Queue;

import com.leetcode.LevelOrder.TreeNode;

public class ZigZagLevelOrderTraversal {

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
     * Given a binary tree, return the zigzag level order 
     * traversal of its nodes' values. (ie, from left to right, 
     * then right to left for the next level and alternate between).

		For example:
		Given binary tree {3,9,20,#,#,15,7},

    3
   / \
  9  20
    /  \
   15   7

		return its zigzag level order traversal as:

		[
  			[3],
  			[20,9],
  			[15,7]
		]

     */
	public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();		
		int d = maxDepth(root);
		for (int i=0;i<d;i++) {
			list.add(new ArrayList<Integer>());
		}
		zigzagLevelOrder(list,root,0,true);
		
		return list;
		
    }
	
	private void zigzagLevelOrder(ArrayList<ArrayList<Integer>> list, TreeNode n, int depth, boolean r2l) {
		
		if (n == null)
			return;
		
		ArrayList<Integer> l = list.get(depth);		
		
		if (r2l)
			l.add(n.val);
		else 
			l.add(0, n.val);
		
		zigzagLevelOrder(list, n.left, 1+depth, !r2l);
		zigzagLevelOrder(list, n.right, 1+depth,!r2l);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TreeNode n = new TreeNode(1);
		
		n.left = new TreeNode(2);
		n.right = new TreeNode(3);
		
		n.left.left = new TreeNode(4);
		n.right.right = new TreeNode(5);
		
		new ZigZagLevelOrderTraversal().zigzagLevelOrder(n);
		
	}}
