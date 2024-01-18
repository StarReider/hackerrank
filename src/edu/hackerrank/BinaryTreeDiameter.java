package edu.hackerrank;

import java.util.ArrayDeque;
import java.util.Queue;

public class BinaryTreeDiameter {
    
    private static class Node {
        Node left;
        Node right;
        String value;
        
        public Node(String v) {
            value=v;
        }
    }
    
    private int result = 0;
    
    public static void main(String[] args) {
        Node root = new Node("F");
        root.left = new Node("B");
        root.right = new Node("G");
        
        root.left.left = new Node("A");
        root.left.right = new Node("D");
        
        root.right.right = new Node("I");
        
        root.left.right.left = new Node("C");
        root.left.right.right = new Node("E");
        
        root.right.right.left = new Node("H");
        root.right.right.left.left = new Node("J");
        
        System.out.println(new BinaryTreeDiameter().traverseAndCalc(root));
    }
    
    public int traverseAndCalc(Node node) {
        dfs(node);
        return result;
    }

    private int dfs(Node node) {
        if(node == null) {
            return -1;
        }
        
        int l = dfs(node.left) + 1;
        int r = dfs(node.right) + 1;
        
        result = Math.max(result, l + r);
        
        return Math.max(l, r);
    }
}
