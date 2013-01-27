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
