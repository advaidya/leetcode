package com.leetcode;

public class EditDistance {
	
	public int minDistance(String word1, String word2) {
		
		int[][] md = new int[word1.length()+1][word2.length()+1];
        
		for (int i=0;i<=word1.length();i++)
			md[i][0] = i;
		
		for (int j=0;j<=word2.length();j++)
			md[0][j] = j;
		
		for (int i=1;i<=word1.length();i++) {
			for(int j=1;j<=word2.length();j++) {
				
				if (word1.charAt(i-1) == word2.charAt(j-1)) {
					md[i][j] = md[i-1][j-1];
				} else {
					// Edit distance by addition
					int x = md[i-1][j] + 1;
					
					// Edit distance by deletion
					int y = md[i][j-1] + 1;
							
					// Edit distance by substitution
					int z = md[i-1][j-1] + 1;
					
					md[i][j] = Math.min(x, Math.min(y, z));
					
				}
				
			}
		}
		
		return md[word1.length()][word2.length()];
    }
	
	public static void main(String[] args) {

		System.out.println(new EditDistance().minDistance("", ""));
	}

}
