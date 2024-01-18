package edu.hackerrank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class MostFrequentElements {

    public static void main(String[] args) {
        System.out.println(findElements(new String[] {"1","2","3","2","2","1","4","5","6","1","2","3"}));
    }

    public static List<String> findElements(String[] arr) {
        HashMap<String, Integer> uniqueElementsWithCount = new HashMap<>(arr.length); 
        
        for(int i = 0; i < arr.length; i++) {
            uniqueElementsWithCount.put(arr[i], uniqueElementsWithCount.getOrDefault(arr[i], 1) + 1);
        }
        
        PriorityQueue<String> queue = new PriorityQueue<>((a,b) -> uniqueElementsWithCount.get(b) - uniqueElementsWithCount.get(a));
        queue.addAll(uniqueElementsWithCount.keySet());
        
        List<String> result = new ArrayList<>();
        for(int i = 0; i < uniqueElementsWithCount.size() && !queue.isEmpty(); i++) {
            result.add(queue.poll());
        }
        return result;
    }
}
