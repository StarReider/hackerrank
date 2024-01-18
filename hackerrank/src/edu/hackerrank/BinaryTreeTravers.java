package edu.hackerrank;

import java.util.ArrayDeque;
import java.util.Queue;

public class BinaryTreeTravers {

    private static class Node {
        Node left;
        Node right;
        String value;
        
        public Node(String v) {
            value=v;
        }
    }
    
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
        
        preOrder(root);
        System.out.println();
        inOrder(root);
        System.out.println();
        postOrder(root);
        System.out.println();
        dfs(root);
    }
    
    public static void preOrder(Node node) {
        System.out.print(node.value);
        
        if(node.left != null) {
            preOrder(node.left);
        }
        
        if(node.right != null) {
            preOrder(node.right);
        }
    }
    
    public static void inOrder(Node node) {
        if(node.left != null) {
            inOrder(node.left);
        }

        System.out.print(node.value);
        
        if(node.right != null) {
            inOrder(node.right);
        }
    }
    
    public static void postOrder(Node node) {
        if(node.left != null) {
            postOrder(node.left);
        }

        if(node.right != null) {
            postOrder(node.right);
        }

        System.out.print(node.value);
    }
    
    public static void dfs(Node node) {
        Queue<Node> queue = new ArrayDeque<>();
        
        queue.add(node);
        
        while(!queue.isEmpty()) {
            for(var cur : queue) {
                queue.remove(cur);
                System.out.print(cur.value);
                
                if(cur.left != null) {
                    queue.add(cur.left);
                }
                
                if(cur.right != null) {
                    queue.add(cur.right);
                }
            }
        }
    }

}
