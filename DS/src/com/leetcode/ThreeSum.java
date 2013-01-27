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
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ThreeSum {
	
	
	public static Set<String> Cubic3Sum(int[] e) {
		
		Set<String> s = new HashSet<String>(); 
		
		Arrays.sort(e);
		
		for (int i=0; i < e.length-2; i++) {
			for (int j=i+1; j < e.length-1; j++)
				for (int k =j+1;k<e.length;k++) {
				
					if (e[i] + e[j] + e[k] == 0) {
						String p = e[i] + "" + "" + e[j] + "" + e[k];
					
						if (!s.contains(p))
							s.add(p);
					}
			}
		}
		
		return s;
	}
	
	/*
	 * Given an array S of n integers, 
	 * are there elements a, b, c in S such 
	 * that a + b + c = 0? Find all unique triplets 
	 * in the array which gives the sum of zero.
	 */
	public static Set<String> Quadratic3Sum(int[] e) {
		
		Set<String> s = new HashSet<String>(); 
		ArrayList<ArrayList<Integer>> al = new ArrayList<ArrayList<Integer>>();
		
		Arrays.sort(e);
		
		for (int i=0;i<e.length-2;i++) {
			int j = i+1;
			int k = e.length-1;
			
			while (j!=k) {
			    
				int sum = e[i] + e[j] + e[k];
				String p = e[i] + "," + "" + e[j] + "," + e[k];
				
				if (sum == 0) {
					s.add(p);
					j++;
				} else if (sum < 0) {
					j++;
				} else {
					k--;
				}
					
			}
		}
		
		for (String a: s) {
			String[] t= a.split(",");
			ArrayList<Integer> list = new ArrayList<Integer>();
			for (int i=0;i<t.length;i++){				
				list.add(Integer.parseInt(t[i]));
			}
			al.add(list);
		}
		
		return s;
		
	}
	
	/*
	 * Given an array S of n integers, find three integers
	 *  in S such that the sum is closest to a given number, 
	 *  target. Return the sum of the three integers. You may 
	 *  assume that each input would have exactly one solution.
	 */
	public static int Quadratic3SumClosest(int[] e, int t) {
		
		int diff = Integer.MAX_VALUE;
		int closestSum = Integer.MAX_VALUE;
		
		Arrays.sort(e);
				
		for (int i=0; i < e.length-2; i++) {
			
			int j = i+1;
			int k = e.length-1;
			while (j!=k) {
			    
				int sum = e[i] + e[j] + e[k];				
					
				if(diff > Math.abs(sum-t)) {
					diff = Math.abs(sum-t);
					closestSum = sum;
				}
				
				if (sum == t) {
					return sum;					
				} else if (sum > t) {			
					k--;
				} else {					
					j++;
				}
					
			}
		}
		
		return closestSum;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int[] e = {-1 ,0, 1, 2, -3, 7, -5};
		
		Set<String> cr = Cubic3Sum(e);
		
		for (String s : cr) {
			//System.out.println(s);
		}
		
		Set<String> qr = Quadratic3Sum(e);
		
		for (String s : qr) {
			//System.out.println(s);
		}
		
		int clr = Quadratic3SumClosest(e, -2);
		
		System.out.println("closest " + clr);
	}

}
