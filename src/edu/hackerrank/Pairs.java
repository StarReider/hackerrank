package edu.hackerrank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pairs {

	public static void main(String[] args) {
		System.out.println(pairs(2, new ArrayList<Integer>(List.of(2, 5, 3, 9, 11, 1, 4))));
	}

	private static int pairs(int k, List<Integer> nums) {
		int res = 0;
		
		Collections.sort(nums);
		
		for(int i = 0; i < nums.size(); i++) {
			for(int j = i + 1; j < nums.size(); j++) {
				if(Math.abs(nums.get(i) - nums.get(j)) == k) {
					res++;
					break;
				}
			}
		}
		
		
		return res;
	}
}
