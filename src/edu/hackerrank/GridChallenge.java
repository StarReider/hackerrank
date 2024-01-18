package edu.hackerrank;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GridChallenge {

	public static void main(String[] args) {
		System.out.println(gridChallenge(List.of("eabcd", "fghij", "olkmn", "trpqs", "dywuv")));
	System.out.println("ewe".split("").length);
	}

	public static String gridChallenge(List<String> grid) {
		String res = "YES";
		
		List<String> gridSorted = grid.stream().map(String::toCharArray)
				.map(chars -> {Arrays.sort(chars); return new String(chars);})
				.collect(Collectors.toList());
		
		for(int i = 0; i < gridSorted.get(0).length(); i++) {
			for (int j = 0; j < gridSorted.size() - 1; j++) {
				if(gridSorted.get(j).charAt(i) > gridSorted.get(j+1).charAt(i)) {
					return "NO";
				}
			}
		}

        
        return res;
    }
}
