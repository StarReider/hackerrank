package edu.hackerrank;

import java.util.List;

public class FlipMatrix {

	public static void main(String[] args) {
		System.out.println(flipMatrix(List.of(List.of(112,42,83,119),List.of(56,125,56,49),List.of(15,78,101,43),List.of(62,98,114,108))));
	}
	
	public static int flipMatrix(List<List<Integer>> matrix) {
		int res = 0;
		int max = 0;
		int n = matrix.size() / 2;
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				max = 0;
				max = Math.max(max, matrix.get(i).get(j));
				max = Math.max(max, matrix.get(i).get(2 * n - 1 - j));
				max = Math.max(max, matrix.get(2 * n - 1 - i).get(j));
				max = Math.max(max, matrix.get(2 * n - 1 - i).get(2 * n - 1 - j));
				
				res += max;
			}
		}
		
		return res;
	}

}
