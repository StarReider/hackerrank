package edu.hackerrank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinMax {

	public static void main(String[] args) {
		miniMaxSum(new ArrayList<>(List.of(256741038, 623958417, 467905213, 714532089, 938071625)));
	}

    public static void miniMaxSum(List<Integer> arr) {
    	// Write your code here
        Collections.sort(arr);
        long min = arr.get(0) + arr.get(1) + arr.get(2) + arr.get(3);
        Collections.reverse(arr);
        System.out.println(arr);
        long max = arr.get(0) + (long)arr.get(1) + arr.get(2) + arr.get(3);
        System.out.println(max);
        System.out.print(min + " " + max);
    }
}
