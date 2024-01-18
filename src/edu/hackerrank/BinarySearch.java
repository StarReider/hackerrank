package edu.hackerrank;

import java.util.Arrays;

public class BinarySearch {

    public static void main(String[] args) {
    	System.out.println(Arrays.asList("fdf fff fff".split(" ")));
        System.out.println(search(new int[] {0,1}, 1));
    }
    
    public static int search(int[] arr, int key) {    
        int low = 0;
        int high = arr.length - 1;
        
        int index = -1;
        while(low <= high) {
            int mid = (high + low) / 2;
            
            if(arr[mid] < key) {
                low = mid + 1;
            } else if (arr[mid] > key) {
                high = mid - 1;
            } else {
                index = mid;
                break;
            }
        }
        
        return index;
    }

}
