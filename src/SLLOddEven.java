/**
 * Jorge Vega
 * Problem Solving 3 Course
 * Prof. Nayda Santiago
 * Instr. Shiva Garg
 */

class SLLOddEven {
  public static void main(String[] args) {

  ListNode node1 = new ListNode(1);
  ListNode node2 = new ListNode(2);
  ListNode node3 = new ListNode(3);
  ListNode node4 = new ListNode(4);
  ListNode node5 = new ListNode(5);

  node1.next = node2; node2.next = node3; node3.next = node4; node4.next = node5; node5.next = null;

  ListNode current = node1;

  System.out.println("Original List: ");
  
  while (current != null){
    System.out.print(current.val + "->");
    current = current.next;  
  }
  System.out.println("null");

  ListNode sortedNode = oddEvenList(node1);

  System.out.println("Odds/Evens grouped: ");

  current = sortedNode;

  while (current != null){
    System.out.print(current.val + "->");
    current = current.next;  
  }
  System.out.print("null");

  }

  public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

  public static ListNode oddEvenList(ListNode head) {
	  
	  	// handling worst cases 
	    if (head == null) { return null;}
        if (head.next == null) { return head;}
	  
        int index = 0; //index to keep track of which nodes are odd/even
        ListNode currentNode = head;
        ListNode nextNode = head.next;
        ListNode firstEven = head.next; //saving a reference to the first 'even' node 
        Boolean greenLight = true; //boolean condition to keep traversing the list 
        
        while (greenLight) {
        	if (nextNode.next == null) { //stopping condition checks if there's two nodes before the null, so as to have a reference to the last odd and even nodes 
        		if (index % 2 == 0) {
        			currentNode.next = firstEven; //here we link the end of the 'odd list' to the beginning of the 'even list'
        		} else {
        			currentNode.next = null; //in this case we also need to end the 'even list' and set its last node's next to null
        			nextNode.next = firstEven; 
        		}
        		greenLight = false;
        	} else { 
        		currentNode.next = nextNode.next; //this sets the next of each node to its next's next, grouping odds and evens together
        	}
            
        	//this part to traverse the list
            currentNode = nextNode; 
            nextNode = nextNode.next;            
            index++;
        }
        
        return head; 
    }
}



