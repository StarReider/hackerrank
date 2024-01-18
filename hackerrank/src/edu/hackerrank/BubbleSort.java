package edu.hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BubbleSort {

	public static void main(String[] args) {
		var ar = new ArrayList<>(Arrays.asList(3,6,4,1));
		
		countSwaps(ar);
		
		System.out.println(ar);
	}
	
	public static void countSwaps(List<Integer> a) {
        for (int i = 0; i < a.size(); i++) {
    
            for (int j = 0; j < a.size() - 1; j++) {
                // Swap adjacent elements if they are in decreasing order
                if (a.get(j) > a.get(j + 1)) {
                    swap(a, j, j + 1);
                }
            }
            
        }
    }
    
    private static void swap(List<Integer> a, int i, int j) {
        int temp = a.get(j);
        a.set(j, a.get(i));
        a.set(i, temp);
    }
}
