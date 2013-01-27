package com.leetcode;

public class MaxPathSum {

	public static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      public TreeNode(int x) { val = x; }
	}
	
	 public int maxPathSum(TreeNode root) {
				
		 if (root!=null) {
			 int mSum = root.val;
			 
			 if (root.left==null && root.right==null) {
				 return mSum;
			 } else if (root.left == null) {
				 int rSum = maxpath(root.right);
				 
				 return Math.max(root.val+rSum,Math.max(rSum, root.val));
			 } else if (root.right == null) {
				 int lSum = maxpath(root.left);
				 return Math.max(root.val+lSum,Math.max(lSum, root.val));
			 } else {
				 int lSum = maxpath(root.left);
				 int rSum = maxpath(root.right);
				 return Math.max(mSum+lSum+rSum,Math.max(mSum+rSum, Math.max(mSum+lSum, Math.max(mSum, Math.max(lSum, rSum)))));
			 }
		 } else {
			 return -1;
		 }		 
	 }
	 
	 private int maxpath(TreeNode n) {
		 if ( n == null) {
			 return 0;
		 } 
		 
		 if (n.left == null && n.right == null)
			 return n.val;
		 else if (n.left == null && n.right !=null) {
			 return Math.max(n.val,n.val + maxpath(n.right));
		 } else if (n.left != null && n.right == null) {
			 return Math.max(n.val, n.val + maxpath(n.left));
		 } else {
			 return Math.max(n.val, n.val + Math.max(maxpath(n.left), maxpath(n.right)));
		 }
		 
	 }
	
	public static void main(String[] args) {

		/*TreeNode root = new TreeNode(10);
		
		root.left = new TreeNode(5);
		root.right = new TreeNode(13);
		
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(7);
		
		root.left.right.left = new TreeNode(6);
		root.left.right.right = new TreeNode(8);
		
		root.right = new TreeNode(13);
		root.right.right = new TreeNode(16);
		root.right.right.left = new TreeNode(14);*/
		
		//TreeNode root = new TreeNode(-2);
		//root.right = new TreeNode(-1);
		
		TreeNode root = new TreeNode(1);
		
		root.right = new TreeNode(2);
		
		root.right.right = new TreeNode(3);
		
		root.right.right.right = new TreeNode(4);		
		
		root.right.right.right.right = new TreeNode(5);
		
		MaxPathSum mps = new MaxPathSum();
		System.out.println(mps.maxPathSum(root));
		
		//root.left = null;
		//System.out.println(mps.maxPathSum(root));
	}

}
