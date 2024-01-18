package edu.hackerrank;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Task105 {

	public static void main(String[] args) {
		System.out.println(compressedString("abaasass"));
	}

	public static String compressedString(String message) {
        char[] ar = message.toCharArray();
        
        
        int count = 0;
        
        
        List<List<String>> arr = null;
        IntStream.range(0, 1).boxed().collect(Collectors.toMap(i -> arr.get(i), i -> i));
        Collections.sort(arr, (a,b) -> a.get(count));
        StringBuilder res = new StringBuilder("" + message.charAt(0));
        char prev = ar[0];
        
        for(int i = 1; i < ar.length; i++) {
        	System.out.println("i=" + i);
        	System.out.println("a=" + ar[i]);
        	System.out.println("prev=" + prev);
        	System.out.println("count=" + count);
            if(prev == ar[i]) {
            	System.out.println("inside if ");
                count++;
                prev = ar[i];
                continue;
            }
            
            if(count == 0) {
                res.append(message.charAt(i));
            }
            else {
                res.append(String.valueOf(count+1)); 
                res.append(String.valueOf(message.charAt(i))); 
                count = 0;
            }

            prev = ar[i];
        }
        
        if(count != 0) {
        	res.append(String.valueOf(count+1)); 
        }
        
        Collections.reverse(arr);
        
        return res.toString();
    }
}
