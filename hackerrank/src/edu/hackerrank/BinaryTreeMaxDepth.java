package edu.hackerrank;

import java.util.AbstractMap;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class BinaryTreeMaxDepth {


      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
          
          @Override
        public String toString() {
            // TODO Auto-generated method stub
            return String.valueOf(val);
        }
      }
    
    public static void main(String[] args) {
        TreeNode root = new BinaryTreeMaxDepth().new TreeNode(0);
        root.left = new BinaryTreeMaxDepth().new TreeNode(2);
        root.right = new BinaryTreeMaxDepth().new TreeNode(4);
        
        root.left.left = new BinaryTreeMaxDepth().new TreeNode(1);
        root.left.right = null;      
        root.right.left = new BinaryTreeMaxDepth().new TreeNode(3);
        root.right.right = new BinaryTreeMaxDepth().new TreeNode(-1);
        
        root.left.left.left = new BinaryTreeMaxDepth().new TreeNode(5);
        root.left.left.right = new BinaryTreeMaxDepth().new TreeNode(1);
        root.right.left.left = null;
        root.right.left.right = new BinaryTreeMaxDepth().new TreeNode(6);
        root.right.right.right = new BinaryTreeMaxDepth().new TreeNode(8);
        
        System.out.println(new BinaryTreeMaxDepth().maxDepthDFS(root));
        System.out.println(new BinaryTreeMaxDepth().maxDepthBFS(root));
        System.out.println(new BinaryTreeMaxDepth().maxPreOrder(root));
    }
    
    public int maxPreOrder(TreeNode root) {
        if(root == null) {
            return 0;
        }
        
        int result = 1;
        
        Stack<AbstractMap.SimpleEntry<TreeNode, Integer>> stack = new Stack<>();
        stack.add(new AbstractMap.SimpleEntry<BinaryTreeMaxDepth.TreeNode, Integer>(root, 1));
        
        while(!stack.isEmpty()) {
            var entry = stack.pop();
            
            if(entry != null) {
                result = Math.max(result, entry.getValue());
                
                if(entry.getKey().left != null)
                    stack.add(new AbstractMap.SimpleEntry<BinaryTreeMaxDepth.TreeNode, Integer>(entry.getKey().left, entry.getValue() + 1));
                
                if(entry.getKey().right != null)
                    stack.add(new AbstractMap.SimpleEntry<BinaryTreeMaxDepth.TreeNode, Integer>(entry.getKey().right, entry.getValue() + 1));
            }
        }
        
        return result;
                
    }
    
    public int maxDepthBFS(TreeNode root) {
        if(root == null) {
            return 0;
        }
        
        Queue<TreeNode> fifo = new ArrayDeque<>();
        fifo.add(root);
        
        int level = 0;
        
        while(!fifo.isEmpty()) {
            
            int size = fifo.size();
            for(int i = 0; i < size; i++) {
                TreeNode node = fifo.poll();
                
                if(node.left != null) {
                    fifo.add(node.left);
                }
                
                if(node.right != null) {
                    fifo.add(node.right);
                }
            }
            
            level++;
        }
        
        return level;
    }
    
    public int maxDepthDFS(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int leftSubTreeSize = find(root.left, 1);
        int rightSubTreeSize = find(root.right, 1);

        return Math.max(leftSubTreeSize, rightSubTreeSize);
    }

    public int find(TreeNode node, int level) {
        if(node == null) {
            return level;
        }

        return Math.max(find(node.left, level+1), find(node.right, level+1));
    }

}
