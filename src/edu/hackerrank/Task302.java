package edu.hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task302 {

	public static void main(String[] args) {
		System.out.println(countSentences(List.of("star",
				"stay",
				"tay",
				"seed",
				"dees",
				"eesd",
				"rast",
				"date",
				"ate"), 
				List.of("rast tay star")));
	}

	public static List<Long> countSentences(List<String> wordSet, List<String> sentences) {
        List<Long> res = new ArrayList<>();
        
        for(int i = 0; i < sentences.size(); i++) {
            long swaps = 1L;
            String[] words = sentences.get(i).split(" ");
            
            
            for(int j = 0; j < words.length; j++) {
               	long ahangrams = isAnagram(words[j], wordSet);
               	if(ahangrams > 0) {
               		swaps = swaps*(ahangrams+1);
               	}
            }
            
            res.add(swaps);
        }
        
        return res;
    }

    private static long isAnagram(String w1, List<String> words) {
        return words.stream().filter(w -> {
            if(w.equals(w1)) {
                return false;
            }
            
            char[] w1Ar = w1.toCharArray();
            char[] w2Ar = w.toCharArray();
            Arrays.sort(w1Ar);
            Arrays.sort(w2Ar);
        
            return Arrays.equals(w1Ar, w2Ar);
        }).count();
    }
}
