package com.leetcode;

public class SortedArray {

	
	public int search(int[] A, int key) {
		if (A==null) {
			return -1;			
		} else {
			if (A.length==1) {
				if (A[0]==key) {
					return 0;
				} else {
					return -1;
				}
			} else if (A.length == 2) {
				if (A[0] == key) {
					return 0;
				} else if (A[1] == key) {
					return 1;
				} else {
					return -1;
				}
			} else {
				return search(A, key, 0, A.length);
			}
		}
    }
	
	private int search(int[] A, int key, int low, int high) {
		
		if (high<=low)
			return -1;
		
		int mid = low + (high-low)/2;
		
		if (A[mid] == key) {
			return mid;
		} else {
			
			if (isSorted(A, mid, high)) {
				if (A[mid]<key && key <=A[high-1]) {
					return search(A, key, mid+1, high);
				} else {
					return search(A, key, low, mid);
				}				
			} else {
				if (mid-low==1) {
					if (A[low] == key) {
						return low;
					} else {
						return -1;
					}
				} else {
					if (A[low] <= key && key < A[mid]) {
						return search(A, key, low, mid);
					} else {
						return search(A, key, mid+1, high);
					}
				}
			}
		}
	}
	
	private boolean isSorted(int[] A, int low, int high) {
		
		if (A[low]<A[high-1]) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SortedArray sa = new SortedArray();
		
		int[] i = { 0,  1,  2,  3, 4, 5, 6, 7,  8}; 
		int[] A = { 9 , 1,  2, 3,  4, 5, 6, 7,  8};
		int key = 9;
		
		System.out.println(sa.search(A, key));
	}

}
