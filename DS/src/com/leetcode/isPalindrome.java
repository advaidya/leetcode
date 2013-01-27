package com.leetcode;

public class isPalindrome {

	/*
	 *  Given a string, determine if it is a palindrome, 
	 *  considering only alphanumeric characters and ignoring cases.
	 *  
	 *  For example,
	 *  "A man, a plan, a canal: Panama" is a palindrome.
	 *  "race a car" is not a palindrome.
	 *  Note:
	 *  Have you consider that the string might be empty? 
	 *  This is a good question to ask during an interview.
	 *  For the purpose of this problem, we define empty string as valid palindrome. 
	 */
	public boolean isPalindrome(String r) {
		
		int f = 0;
		int l = r.length()-1;
		
		while (f<l) {
			
			Character fc = Character.valueOf(r.charAt(f));
			Character lc = Character.valueOf(r.charAt(l));
			
			boolean fIsValid = Character.isLetterOrDigit(fc);
			boolean lIsValid = Character.isLetterOrDigit(lc);
			
			if (fIsValid && lIsValid)  {
				if (Character.toLowerCase(r.charAt(f)) != Character.toLowerCase(r.charAt(l))) {
					return false;
				} else {
					f++;l--;
					continue;
				}
			} else if (fIsValid) {
				l--;
			} else {
				f++;
			}
		}
		
		return true;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String s = "A man, a plan, a canal: panama";
		
		String r = s.replaceAll("\\s+", "");
		
		System.out.println(r);
		
		isPalindrome ip = new isPalindrome();
		System.out.println(ip.isPalindrome(r));
		
	}

}
