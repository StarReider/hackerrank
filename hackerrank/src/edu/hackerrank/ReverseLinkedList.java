package edu.hackerrank;

import java.util.ArrayList;
import java.util.List;

public class ReverseLinkedList {
    
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    
    public static ListNode reverseList2(ListNode head) {
        List<ListNode> nodes = new ArrayList<>();
        
        var curreListNode = head;
        while(curreListNode.next != null) {
            nodes.add(curreListNode);
            curreListNode = curreListNode.next;
        }
        
        if(nodes.isEmpty()) {
            return head;
        }
        
        nodes.add(curreListNode);
        
        ListNode result = nodes.get(nodes.size() - 1);
        curreListNode = result;
        for(int i = nodes.size() - 2; i >= 0; i--) {
            curreListNode.next = nodes.get(i);
            curreListNode = nodes.get(i);
        }
        
        curreListNode.next = null;
        
        return result;
    }
    
    public static ListNode reverseList(ListNode head) {
        ListNode curNode = head;
        ListNode prevNode = null;
        List<ListNode> nodes = new ArrayList<>();
        ListNode result = null;

        while(curNode != null) {
            nodes.add(curNode);
            prevNode = curNode;
            curNode = curNode.next; 
            prevNode.next = null;
        }

        if(nodes.isEmpty()) {
            return head;
        }
        
        result = nodes.get(nodes.size() - 1);
        curNode = result;

        for(int i = nodes.size() - 1; i > 0; i--) {
            curNode.next = nodes.get(i-1);
            curNode = nodes.get(i-1);
        }

        return result;
    }
    
    public static ListNode recursiveReverseList(ListNode prev, ListNode curNode) {
        if(curNode == null) {
            return null;
        }
        
        if(curNode.next != null) {
            ListNode next = curNode.next;
            if(prev != null) {
                curNode.next = prev;
            } else {
                curNode.next = null;
            }
            
            return recursiveReverseList(curNode, next);
        } else {
            curNode.next = prev;
            return curNode;
        }
    }
    
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        
        ListNode res = null;
        //res = reverseList(head);
        res = reverseList2(head);
        //ListNode res = recursiveReverseList(null, head);
        System.out.println(res);
    }

}
