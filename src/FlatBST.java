
/**
 * Jorge Vega
 * Problem Solving 3 Course
 * Prof. Nayda Santiago
 * Instr. Shiva Garg
 */

class FlatBST {
  public static void main(String[] args) {
	  
	  TreeNode node1 = new TreeNode(1);
	  TreeNode node2 = new TreeNode(2);
	  TreeNode node3 = new TreeNode(3);
	  TreeNode node4 = new TreeNode(4);
	  TreeNode node5 = new TreeNode(5);
	  TreeNode node6 = new TreeNode(6);
	  
	  node1.left = node2;
	  node1.right = node5;
	  node2.left = node3;
	  node2.right = node4;
	  node5.right = node6;
  
  flatten(node1);
  System.out.println("ended");
  
  }

  public static class TreeNode {
	       int val;
	       TreeNode left;
	       TreeNode right;
	       TreeNode(int x) { val = x; }
	   }
  

  public static void flatten(TreeNode root) {

	  if (root != null) {
		  
		  TreeNode tempRight = null; //temporary node to hold the right subtree
		  if (root.left != null) {
			  tempRight = root.right;
			  root.right = root.left; //switching the left node to the right 
			  root.left = null; //making left side null to turn the tree flat
			  
			  //while loop to append the right subtree to the next available null position in the right side 
			  Boolean canAppend = true;
			  TreeNode cycleNode = root;
			  while(canAppend) {
				  if (cycleNode.right == null) {
					  cycleNode.right = tempRight;
					  canAppend = false;
				  } else {
					  cycleNode = cycleNode.right;
				  }
			  }
		  }
		  
		  if (root.right != null) {
			  flatten(root.right);
		  }
		  
	  } else {
		  System.out.println("root was null");
	  }	 
  }
}



