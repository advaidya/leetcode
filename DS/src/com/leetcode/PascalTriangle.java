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
import java.util.Collections;
import java.util.Map;
import java.util.HashMap;

public class PascalTriangle {

	private Map<Integer, ArrayList<Integer>> m = new HashMap<Integer, ArrayList<Integer>>();
	
	/**
	  Given an index k, return the kth row of the Pascal's triangle.

	  For example, given k = 3,
	  Return [1,3,3,1].

	  Note:
	  Could you optimize your algorithm to use only O(k) extra space? 
	*/
	public ArrayList<Integer> getRow(int rowIndex) {
		
		ArrayList<Integer> l;
		
		if (!m.containsKey(rowIndex)) {			
			l = new ArrayList<Integer>(
				    Collections.nCopies(rowIndex+1, new Integer(-1)));
			m.put(rowIndex, l);
			
			if (0 == rowIndex) {
				l.set(0, 1);
				return l;
			} else if (1 == rowIndex) {
				l.set(0, 1);
				l.set(1, 1);
				return l;
			} else if (2 == rowIndex) {
				l.set(0, 1);
				l.set(1, 2);
				l.set(2, 1);
				return l;
			}
		} else {
			return m.get(rowIndex);
		}
		
		for (int i=0;i<=rowIndex/2;i++) {
			
			if (i==0) {
				l.set(0, 1);
			} else if (i==1) {			
				l.set(1, rowIndex);
			} else {				
				for (int j=2;j<=rowIndex/2;j++) {
					// Get previous row.
					ArrayList<Integer> pl = getRow(rowIndex-1);

					l.set(j, pl.get(j)+pl.get(j-1));
					if (j != rowIndex-j) {
						l.set(rowIndex-j, pl.get(j)+pl.get(j-1));
					}
				}				
			}
		}
		
		l.set(rowIndex-1, rowIndex);
		l.set(rowIndex, 1);
		
		return l;        
    }
	/**
	 Given numRows, generate the first numRows of Pascal's triangle.

	For example, given numRows = 5,
	Return

	[
	     [1],
	    [1,1],
	   [1,2,1],
	  [1,3,3,1],
	 [1,4,6,4,1]
	]

	*/
	public ArrayList<ArrayList<Integer>> generate(int numRows) {
        
		ArrayList<ArrayList<Integer>> l = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> fl = new ArrayList<Integer>();
		fl.add(1);
		
		if (numRows == 0) {			
		} else if (numRows == 1) {
			l.add(fl);
		} else {
			l.add(fl);
			for (int i=1;i<numRows;i++) {
				l.add(generate(l.get(i-1), i));
			}
			
		}
		
		return l;
    }
	
	private ArrayList<Integer> generate(ArrayList<Integer> pl, int numRows) {
		
		ArrayList<Integer> nl = new ArrayList<Integer>();
		
		nl.add(1);
		for (int i=1;i<pl.size();i++) {
			nl.add(pl.get(i-1)+pl.get(i));
		}
		nl.add(1);
		
		return nl;
	}
	
	public static void main(String[] args) {
	
		new PascalTriangle().generate(5);
		ArrayList<Integer> l = new PascalTriangle().getRow(6);
		
		System.out.println(l.toString());
	}

}
