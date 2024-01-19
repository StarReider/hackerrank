package edu.hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.stream.IntStream;

public class SimpleTextEditor {
	public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine().trim());
        StringBuilder s = new StringBuilder();
        Stack<String> states = new Stack<>();
        
        IntStream.range(0, t).forEach(tItr -> {
            try {
                String op = bufferedReader.readLine();
                String res = runEditor(s.toString(), op, states);
                s.replace(0, s.length(), res);
            }
            catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }
    
    private static String runEditor(String s, String op, Stack<String> states) {
            int opNum = Integer.valueOf(op.split(" ")[0]);
            String res = s;
            switch(opNum) {
                case 1: {
                    states.add(s);
                    res = s + op.split(" ")[1];
                    break;
                }
                case 2: {
                    states.add(s);
                    
                    int del = Integer.valueOf(op.split(" ")[1]);
                    res = s.substring(0, s.length() - del);
                    break;
                }
                case 3: {
                    int toPrint = Integer.valueOf(op.split(" ")[1]);
                    System.out.println(s.charAt(toPrint - 1));
                    break;
                }
                case 4: {
                	res = states.pop();
                }
            }
            
            return res;
    }
}
