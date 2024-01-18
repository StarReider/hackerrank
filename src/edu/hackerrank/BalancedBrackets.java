package edu.hackerrank;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Map;

public class BalancedBrackets {

	public static void main(String[] args) {
		System.out.println(isBalanced("{{[[(())]]}}"));
	}

	public static String isBalanced(String s) {
        String[] parenthsis = s.split("");
        Deque<String> stack = new LinkedList<>();
        Map<String, String> barcketsMap = Map.of(")", "(", "}", "{", "]", "[");
        
        for(var i = 0; i < parenthsis.length; i++) {
            if(i == 0 && !barcketsMap.values().contains(parenthsis[i])) {
                return "NO";
            }
         
            if(barcketsMap.values().contains(parenthsis[i])) {
                stack.push(parenthsis[i]);
                continue;
            }
            
            if(!barcketsMap.get(parenthsis[i]).equals(stack.poll())) {
                return "NO";
            }
        }
        
        return stack.isEmpty() ? "YES" : "NO";

    }
}
