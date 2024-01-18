package edu.hackerrank;

public class MergeLists {

	 static class SinglyLinkedListNode {
	          int data;
	          SinglyLinkedListNode next;
	          
	          public SinglyLinkedListNode(int data) {
				this.data = data;
	          }
	          
	          @Override
	        public String toString() {
	        	  // TODO Auto-generated method stub
	        	  return String.valueOf(data);
	        }
	      }
	 
	public static void main(String[] args) {
		SinglyLinkedListNode head1 = new SinglyLinkedListNode(1);
		head1.next = new SinglyLinkedListNode(2);
		head1.next.next = new SinglyLinkedListNode(3);
		
		SinglyLinkedListNode head2 = new SinglyLinkedListNode(2);
		head2.next = new SinglyLinkedListNode(3);
		
		SinglyLinkedListNode r = mergeLists(head1, head2);
		System.out.println(r);
		
	}
	
	static SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        if(head1 == null) {
            return head2;
        }
        
        if(head2 == null) {
            return head1;
        }
        
        SinglyLinkedListNode res = null;
        SinglyLinkedListNode cur = res;
        while(head1 != null || head2 != null) {
        	int data = 0;
        	
            if(head1 == null) {
                data = head2.data;
                head2 = head2.next;
            } else if(head2 == null) {
            	data = head1.data;
                head1 = head1.next;
            } else if(head1.data >= head2.data) {
            	data = head2.data;
                head2 = head2.next;               
            } else {
            	data = head1.data;
                head1 = head1.next;
            }
            
            if(res == null) {
            	res = new SinglyLinkedListNode(data);
            	cur = res;
            	continue;
            }
        	cur.next = new SinglyLinkedListNode(data);
        	cur = cur.next;
        }
        
        return res;
    }

}
