package edu.hackerrank;

import java.util.stream.IntStream;

public class Polyndrom {

	public static void main(String[] args) {
		System.out.println(palindromeIndex("aab"));
	}

	 public static int palindromeIndex(String s) {
	        char[] inAr = s.toCharArray();
	        int res = -1;
	        int start = 0;
	        int end = inAr.length - 1;
	        
	        while(start < end && inAr[start] == inAr[end]) {
	        	start++;
	        	end--;
	        }
	        
	        if(start >= end) {
	        	return -1;
	        }
	        
	        if(isPalindrom(s, start + 1, end)) return start;
	        if(isPalindrom(s, start, end - 1)) return end;
	        
	        return res;
	    }
	 
	 static boolean isPalindrom(String s, int start, int end) {
		 while(start < end && s.charAt(start) == s.charAt(end)) {
			 start++;
			 end--;
		 }
		 
		 return start >= end;
	 }
}
