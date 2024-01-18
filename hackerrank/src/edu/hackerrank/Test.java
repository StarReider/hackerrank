package edu.hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Test {

    public static void main(String[] args) {
        String s = 
                "race a car";
        //System.out.println("'" + s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase() + "'");
        //System.out.println(isPalindrome(s));
        
        System.out.println(validParenthsis("{[]}"));
        
        List<Integer> arr = List.of(63, 25	, 73, 1, 98, 73, 56, 84, 86, 1);
        
        List<Integer> freq = IntStream.of(new int[100])
                .boxed()
                .collect(Collectors.toList());
            
            for(int i = 0; i < arr.size(); i++) {
                int value = arr.get(i);
                if(freq.get(value) == null) {
                    freq.set(value, 1);
                } else {
                    freq.set(value, freq.get(value) + 1);
                }
            }
            
            char[] ar = "abc".toCharArray();
            for(int i = 0; i < ar.length; i++) {
            	System.out.println((char)(ar[i]+3));
            }
            
         System.out.println("abc".toCharArray());
     }
    
    public static boolean validParenthsis(String s) {
        String[] parenthsis = s.split("");
        Deque<String> stack = new LinkedList<>();
        Map<String, String> barcketsMap = Map.of(")", "(", "}", "{", "]", "[");
        
        for(var i = 0; i < parenthsis.length; i++) {
            if(i == 0 && !barcketsMap.values().contains(parenthsis[i])) {
                return false;
            }
         
            if(barcketsMap.values().contains(parenthsis[i])) {
                stack.push(parenthsis[i]);
                continue;
            }
            
            if(!barcketsMap.get(parenthsis[i]).equals(stack.poll())) {
                return false;
            }
        }
        
        return stack.isEmpty();
    }
    
    public static boolean isPalindrome(String s) {
        String parsedString = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        if(parsedString.isEmpty()) {
            return true;
        }

        char[] originalArr = parsedString.toCharArray();
        char[] palindromeArr = new char[originalArr.length];
        for(int i = originalArr.length - 1, j=0; i >= 0; i--, j++) {
            palindromeArr[j] = originalArr[i];
        }
        
        System.out.println(new String(palindromeArr));

        return new String(palindromeArr).equals(parsedString);
    }
    
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];
        
        for(int i = 0; i < nums.length; i++) {
            int secondValue = target - nums[i];
            
            if(map.containsKey(secondValue)) {
                result[0] = i;
                result[1] = map.get(secondValue);
                
                break;
            } else {
                map.put(nums[i], i);
            }
        }
        
        return result;
    }
}
