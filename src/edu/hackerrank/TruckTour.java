package edu.hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TruckTour {

	public static void main(String[] args) throws NumberFormatException, IOException  {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(TruckTour.class.getResourceAsStream("truck_tour.txt")));
		int n = Integer.parseInt(bufferedReader.readLine().trim());
		
		List<List<Integer>> petrolpumps = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                petrolpumps.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .toList()
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
		
		var list = List.of(List.of(1,5), List.of(10, 3), List.of(3,4));
		System.out.println(truckTour(petrolpumps));
	}

	public static int truckTour(List<List<Integer>> petrolpumps) {
	    // Write your code here
	        int res = 0;
	        for(int i = 0; i < petrolpumps.size(); i++) {
	            int petrol = 0;
	            int stops = 0;
	            for(int j = i; j <= petrolpumps.size() && j >=0; j++) {
	                if(j == petrolpumps.size()) {
	                    j = 0;
	                }
	                
	                if(stops == petrolpumps.size()) {
	                    break;
	                }
	                
	                int distance = petrolpumps.get(j).get(1);
	                int pumpAmount = petrolpumps.get(j).get(0);
	                
	                System.out.println("pump N" + j + ": distance=" + distance + ",oilAmount=" + pumpAmount);
	                if(petrol + pumpAmount >= distance) {
	                    petrol = (petrol + pumpAmount - distance);
	                    System.out.println("oil left:" + petrol);
		                
	                    stops++;
	                } else {
	                	System.out.println("Not enough oil, check next pump");
	                	petrol = 0;
	                	break;
	                }
	                
	            }
	            
	            if(petrol > 0) {
	                return i;
	            }
	        }
	        
	        return res;
	    }
}
