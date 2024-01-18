package edu.hackerrank;

import java.util.ArrayList;
import java.util.List;

public class NewYearChaos {

	public static void main(String[] args) {
		minimumBribes(new ArrayList<>(List.of(2, 1, 5, 3, 4)));
	}

	public static void minimumBribes(List<Integer> q) {
        int total = 0;
		for(int i = q.size() - 1; i >= 0; i--) {
			int bribes = 0;			
			for(int j = i; j > 0 && q.get(j-1) > q.get(j) ; j--) {
				 if(-(j + 1) + q.get(j) > 2) {
	                    System.out.println("Too chaotic");
	                    return;
	                }
				
				swap(q, j, j-1);
                bribes++;
               	                					
			}
			total += bribes;
        }
		
		System.out.println(total);
		
		System.out.println(q);
    }
	
	private static void swap(List<Integer> q, int x, int y) {
		int temp = q.get(x);
		q.set(x, q.get(y));
		q.set(y, temp);
	}
}
