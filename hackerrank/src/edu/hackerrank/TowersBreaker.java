package edu.hackerrank;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TowersBreaker {

	public static void main(String[] args) {
		System.out.println(towerBreakers(2, 6));
	}

	public static int towerBreakers(int n, int m) {
	    // Write your code here
	        List<Integer> towers = new ArrayList<>(IntStream.of(new int[n]).map(el -> m).boxed().collect(Collectors.toList()));
	        
	        boolean isP1 = true;
	        
	        while(!towers.stream().allMatch(v -> v == 1)) {
	            for(int i = 0; i < towers.size(); i++) {
	                if(towers.get(i) != 1) {
	                    towers.set(i, towers.get(i) / 2);
	                    isP1 = !isP1;
	                    break;
	                }
	            }    
	            
	        }
	        
	        return isP1 ? 1 : 2;
	    }
}
