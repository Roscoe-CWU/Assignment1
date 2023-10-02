class Node{
	   int value;
	   Node left, right;
	   
	   public Node(int value){
	      this.value = value;
	      left = null;
	      right = null;
	   }

	}

	class BinarySearchTree{

	   Node root;
	  
	   
	   /*
	   recursive insert method
		
	   */
	   /*
	   inserts a node into the tree
	   */
	   public void insert(int value){
	      //tree is empty
	      if(root == null){
	         root = new Node(value);
	         return;
	      }else{
	         Node current = root;
	         Node parent = null;
	         
	         while(true){
	            parent = current;
	            
	            if(value < current.value){
	               current = current.left;
	               if(current == null){
	                  parent.left = new Node(value);
	                  return;
	               }
	            }else{
	               current = current.right;
	               if(current == null){
	                  parent.right = new Node(value);
	                  return;
	               }
	            }
	           
	         }//closing while
	      
	      }//closing main if-else 
	   }
	   
	   /*
	   pre-order traversal
	   Prints the value of every node preorder
	   */
	   	public void preOrderTraversal(Node root){
	   		// first output value of node
	   		System.out.print(root.value + ", ");
	   		// traverse left nodes
	   		if(root.left != null) {
	   			preOrderTraversal(root.left);
	   		}	   		
	   		// traverse right nodes
	   		if(root.right != null) {
	   			preOrderTraversal(root.right);
	   		}
	   	}

	   
	   
	   /*
	   in-order traversal
	   */
	   	public void inOrderTraversal(Node root){
	   		// traverse left nodes first
	   		if(root.left != null) {
	   			inOrderTraversal(root.left);
	   		}
	   		// output value of node
	   		System.out.print(root.value + ", ");
	   		// traverse right nodes
	   		if(root.right != null) {
	   			inOrderTraversal(root.right);
	   		}
	   	}
	   
	   
	   
	   /*
	   post-order traversal
	   */
	  
   		public void postOrderTraversal(Node root){
   			// traverse left nodes first
	   		if(root.left != null) {
	   			postOrderTraversal(root.left);
	   		}
	   		// traverse right nodes
	   		if(root.right != null) {
	   			postOrderTraversal(root.right);
	   		}
	   		// output value of node last
	   		System.out.print(root.value + ", ");
	   	}
	   
	   
	   
	   /*
	   a method to find the node in the tree
	   with a specific value
	   */
	   	public boolean find(Node root, int key){
   			Node current = root;
   			// while there are more nodes to check
	   		while(current != null) {
	   			// if the current node's value is equal to the key return true
	   			if (key == current.value) {
	   				return true;
	   			}
	   			// if the key is greater than the current node's value
	   			// go to the right node
	   			else if(key > current.value) {
	   				current = current.right;
	   			}
	   			// if the key is less than the current node's value
	   			// go to the left node
	   			else {
	   				current = current.left;
	   			}
	   		}
	   		
	   		
	   		return false;
	   	}
	   
	   
	   
	   /*
	   a method to find the node in the tree
	   with a smallest key
	   */
	   	public int getMin(Node root){
	   		// traverse right nodes until there are none
	   		// then return the left most node (which will be the min)
	   		Node current = root;
	   		while(current.left != null) {
	   			current = current.left;
	   		}
	   		return current.value;
	   	}
	  
	  
	  
	   /*
	   a method to find the node in the tree
	   with a largest key
	   */
	   	public int getMax(Node root){
	   		// traverse right nodes until there are none
	   		// then return the right most node (which will be the max)
	   		Node current = root;	
	   		while(current.right != null) {
	   			current = current.right;
	   		}
	   		return current.value;
	   	}
	   
	   
	   
	   /*
	   this method will not compile until getMax
	   is implemented
	   */
	   public Node delete(Node root, int key){
	      
	      if(root == null){
	         return root;
	      }else if(key < root.value){
	         root.left = delete(root.left, key);
	      }else if(key > root.value){
	         root.right = delete(root.right, key);
	      }else{
	         //node has been found
	         if(root.left==null && root.right==null){
	            //case #1: leaf node
	            root = null;
	         }else if(root.right == null){
	            //case #2 : only left child
	            root = root.left;
	         }else if(root.left == null){
	            //case #2 : only right child
	            root = root.right;
	         }else{
	            //case #3 : 2 children
	            root.value = getMax(root.left);
	            root.left = delete(root.left, root.value);
	         }
	      }
	      return root;  
	   }
	   
	   
	   
	}



	public class TreeDemov1{
	   public static void main(String[] args){
	      BinarySearchTree t1  = new BinarySearchTree();
	      t1.insert( 24);
	      t1.insert(80);
	      t1.insert(18);
	      t1.insert(9);
	      t1.insert(90);
	      t1.insert(22);
	      
	      // test in order traversal
	      System.out.print("in-order :   ");
	      t1.inOrderTraversal(t1.root);
	      System.out.println();
	      
	      // test pre order traversal
	      System.out.print("pre-order :   ");
	      t1.preOrderTraversal(t1.root);
	      System.out.println();
	      
	      // test post order traversal
	      System.out.print("post-order :   ");
	      t1.postOrderTraversal(t1.root);
	      System.out.println();
	      
	      // test find method
	      System.out.println("18 is in the tree :   " + t1.find(t1.root, 18));
	      System.out.println("99 is in the tree :   " + t1.find(t1.root, 99));
	      
	      // test getMin method
	      System.out.println("Min value :   " + t1.getMin(t1.root));
	      
	      // test getMax method
	      System.out.println("Max value :   " + t1.getMax(t1.root));
	   }  
	}
