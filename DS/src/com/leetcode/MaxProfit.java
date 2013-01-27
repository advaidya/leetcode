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
public class MaxProfit {

	/*
	 * Say you have an array for which the ith element is the price 
	 * of a given stock on day i. If you were only permitted to complete 
	 * at most one transaction (ie, buy one and sell one share of the stock), 
	 * design an algorithm to find the maximum profit.
	 */
	public static int maxProfit(int[] e) {
		
		int mp=0;
		int sp=0;
		
		if (e.length>1) {			
			for (int i=1;i<e.length;i++) {
				if (e[sp] >= e[i]) {
					sp=i;
				} else {
					int tmp = e[i]-e[sp];
					if(tmp>mp) {
						mp=tmp;
					}
				}
			}
		}
		
		return mp;
	}
	
	/*
	 * Design an algorithm to find the maximum profit. 
	 * You may complete as many transactions as you like 
	 * (ie, buy one and sell one share of the stock multiple times).
	 *  However, you may not engage in multiple transactions at the 
	 *  same time (ie, you must sell the stock before you buy again).
	 */
	
	public static int maxProfit2(int[] e) {
		
		int mp=0;
		
		if (e.length>1) {			
			for (int i=1;i<e.length;i++) {
				int tmp = e[i] - e[i-1];
				if (tmp>0) {
					mp+=tmp;
				}
			}
		}
		
		return mp;
	}

	public static int maxProfit31(int[] e, int x,int y) {
		
		int mp=0;
		int sp=x;
		
		if (y>1) {			
			for (int i=x+1;i<y;i++) {
				if (e[sp] >= e[i]) {
					sp=i;
				} else {
					int tmp = e[i]-e[sp];
					if(tmp>mp) {
						mp=tmp;
					}
				}
			}
		}
		
		return mp;
	}

	/*
	 * Design an algorithm to find the maximum profit. 
	 * You may complete at most two transactions.
	 */
	public static int maxProfit3(int[] e) {
				
		int mp=0;
		if (e.length>2) {
		for (int k=1;k<e.length;k++) {
			if (e[k+1]>=e[k])
				continue;
			int tmp = maxProfit31(e, 0, k+1)+maxProfit31(e,k+1, e.length);
			if (tmp>mp)
				mp=tmp;
		}
		} else if (e.length == 2) {
			if (e[1]>e[0])
				mp=e[1]-e[0];
		}
		return mp;		
	}

	public static void main(String[] args) {

		int[] e = {1,4,2};
		
		System.out.println(maxProfit3(e));
		
	}

}
