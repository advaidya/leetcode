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
public class SameTree {

	public static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      public TreeNode(int x) { val = x; }
	}
	
    /*
     *  Given two binary trees, write a function to check if they are equal or not.

		Two binary trees are considered equal if they are structurally identical and 
		the nodes have the same value. 
     */
	public boolean isSameTree(TreeNode p, TreeNode q) {
		if (p==null && q == null)
			return true;
		else if (p==null || q==null) 
			return false;
		else 
			return isSame(p, q);
	}
	
	private boolean isSame(TreeNode p, TreeNode q) {
     
		if (p.left==null && p.right==null && q.left==null && q.right==null && p.val == q.val) {
			return true;
		} else if (p.left!=null && q.left!=null && p.right==null &&  q.right==null && p.val==q.val) {
			return isSameTree(p.left, q.left);
		} else if (p.left==null && q.left==null && p.right!=null &&  q.right!=null && p.val==q.val) {
			return isSameTree(p.right, q.right);
		} else if (p.left!=null && q.left!=null && p.right!=null &&  q.right!=null && p.val==q.val) {
			return (isSameTree(p.right, q.right)) && (isSameTree(p.left, q.left));
		}
		
		return false;
    }
	
	public static void main(String[] args) {
		
		TreeNode p = new TreeNode(0);
		p.left = new TreeNode(-5);
		
		TreeNode q = new TreeNode(0);
		q.left = new TreeNode(-8);
		
		System.out.println(new SameTree().isSameTree(p, q));
	}

}
