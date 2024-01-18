package edu.hackerrank;

public class CaesarCipher {

	public static void main(String[] args) {
		System.out.println(caesarCipher("middle-Outz", 2)); // 2
	}

	public static String caesarCipher(String s, int k) {
	    // Write your code here
	        char[] input = s.toCharArray();
	        char[] ciphered = new char[input.length];
	        
	        for(int i = 0; i < input.length; i++) {
	            if(input[i] >= 65 && input[i] <= 90) {	              
	                int originalPos = input[i] - 'a';
	                int newPos = (originalPos + k) % 26;
	                ciphered[i] = (char)(newPos + 'a');

	            }
	            else if (input[i] >= 97 && input[i] <= 122) {
	                int originalPos = input[i] - 'A';
	                int newPos = (originalPos + k) % 26;
	                ciphered[i] = (char)(newPos + 'A');
	            }
	            else ciphered[i] = input[i];
	        }
	        
	        return new String(ciphered);

	}
}
