package col106.assignment3.BST;

import java.util.HashMap;

public class BST<T, E extends Comparable<E>> implements BSTInterface<T, E>  {
	
	public Node<T, E> root = null;
	HashMap<T, E> hm = new HashMap<T,E>();
	
	public static void main() {
		BSTDriverCode BDC = new BSTDriverCode();
		System.setOut(BDC.fileout());
	}
	
	public static void main(String args[]) {
		BST<Integer, Integer> bst = new BST<Integer, Integer>();
		bst.insert(1, 15);
		bst.insert(2, 5);
		bst.insert(3, 1);
		bst.insert(4, 6);
		bst.insert(5, 20);
		bst.insert(6, 16);
		bst.insert(7, 25);
		bst.insert(8, 21);
		bst.insert(9, 26);
//		bst.insert(9, 26);
//		bst.insert(10, 17);
		bst.delete(1);
//		bst.update(9, 300);
		
		bst.printBST();
		
	}
	
    @SuppressWarnings({ "unchecked"})
	public void insert(T key, E value) {
    	hm.put(key, value);
    	int i = 0;
    	Node<T, E> newnode = new Node<T,E>(key, value);
    	if(root == null) {
    		root = newnode;
    	}
    	else {
    		Node<T,E> n = root;
    		//System.out.println(n.key + " " + n.val);
//    		if(n != null) {
//    			System.out.println("teri ma ki chut");
//    		}
    		while(i == 0) {
    			E poty = n.val;
    			if(poty.compareTo(value) < 0) {
    				//System.out.println("root val less than value");
    				if(n.right == null) {
    					n.right = newnode;
    					i = 1;
    				}
    				else {
    					n = n.right;
    				}
    			}
    			else {
    				//System.out.println("root val more than value");
    				if(n.left == null) {
    					n.left = newnode;
    					i = 1;
    				}
    				else {
    					n = n.left;
    				}
    			}
    		}
    	}    	
    }
    
    public int height(Node<T, E> n){ 
        if (n == null) 
           return 0; 
        else if (n.left != null || n.right != null)
        { 
            //System.out.println("root == > " + n.val +" left = " + n.left.val + " right = " + n.right.val);
        	int lheight = height(n.left); 
            int rheight = height(n.right); 
              
            if (lheight > rheight) 
                return(lheight+1); 
            else 
            	return(rheight+1);  
        }
        else {
        	return 0;
        }
    } 

	void printGivenLevel (Node<T, E> root ,int level) 
    { 
        if (root == null) 
            return; 
        if (level == 1) 
            System.out.println(root.key + ", " + root.val); 
        else if (level > 1) 
        { 
            printGivenLevel(root.left, level-1); 
            printGivenLevel(root.right, level-1); 
        } 
    } 
	
	
    
    public void update(T key, E value) {
    	delete(key);
    	hm.remove(key);
    	insert(key, value);
    	hm.put(key, value);
    }
    
	public void delete(T key) {
		//write your code here
    	E value = hm.get(key);
    	
    	Node<T, E> n = root;
    	Node<T, E> papa = root;
    	int j = 0;
    	while(j == 0) {
    		if(n.val.compareTo(value) > 0) {
    			papa = n;
    			n = n.left;
    		}
    		else if(n.val.compareTo(value) < 0) {
    			papa = n;
    			n = n.right;
    		}
    		if(n.val.compareTo(value) == 0) {
    			j = 1;
    			if(n.left == null && n.right == null) {               //no children
//    				System.out.println("no child delete case");
    				if(papa.left == n) {
    					papa.left = null;
    				}
    				else if(papa.right == n) {
    					papa.right = null;
    				}
    				else if(n == root) {
    					System.out.println("tree is empty!!");
    				}
    			}
    			else if(n.left == null) {                                //one child, right only
//    				System.out.println("one child delete case");
    				if(papa.left == n) {
    					papa.left = n.right;
    				}
    				else if(papa.right == n) {
    					papa.right = n.right;
    				}
    				else if(papa == n) {
    					root = n.right;
    				}
    				
    			}
    			else if(n.right == null) {                               //one child
//    				System.out.println("one child delete case, right null");
    				if(papa.left == n) {
    					papa.left = n.left;
    				}
    				else if(papa.right == n) {
    					papa.right = n.left;
    				}
    				else if(papa == n) {
    					root = n.left;
    				}
    			}
    			else if(n.right != null && n.left != null){                // two children
//    				System.out.println("two child delete case");
    				Node<T, E> succ;
    				Node<T, E> rgt = n.right;
    				int i = 0;
    				while(i == 0) {
    					succ = rgt.left;
    					if(succ == null) {
    						i = 1;
    						if(papa.left == n) {
    	    					papa.left = rgt;
    	    					rgt.left = n.left;
//    	    					succ.right = n.right;
    	    				}
    	    				else if(papa.right == n) {
    	    					papa.right = rgt;
    	    					rgt.left = n.left;
//    	    					rgt.right = n.right;
    	    				}
    	    				else if(papa == n && n == root) {
    	    					root = rgt;
    	    					rgt.left = n.left;
    	    				}
    					}
    					else if(succ.left == null) {  
//    						System.out.println("succ val = " + succ.val);
    						i = 1;
    						
    						if(succ.right == null) {                       //(no children)
//	    						System.out.println("nullwa");
    							if(papa.left == n) {
	    	    					papa.left = succ;
	    	    					succ.left = n.left;
	    	    					succ.right = n.right;
	    	    					rgt.left = null;
	    	    				}
	    	    				else if(papa.right == n) {
//	    	    					System.out.println("accha");
	    	    					papa.right = succ;
	    	    					succ.left = n.left;
	    	    					succ.right = n.right;
	    	    					rgt.left = null;
//	    	    					System.out.println("papa ==> "+ papa.val + " left = " + papa.left.val + " right = " + papa.right.val);
//	    	    					System.out.println("succ ==> "+ succ.val + " left = " + succ.left.val + " right = " + succ.right.val);
//	    	    					System.out.println("rgt ==> "+ rgt.val  + " right = " + rgt.right.val);
//	    	    					if(rgt.left == null) {
//	    	    						System.out.println("rgt left null");
//	    	    					}
	    	    				}
//	    	    				else if(papa == n && n != root) {
//    								papa = succ;
//    								succ.left = n.left;
//	    	    					succ.right = n.right;
//	    	    					rgt.left = null;
////	    	    					System.out.println(papa.val + " " + papa.right.val + " " + papa.left.val);
//    							}
	    	    				else if(papa == n && n == root) {
    								papa = succ;
    								succ.left = n.left;
	    	    					succ.right = n.right;
	    	    					rgt.left = null;
//	    	    					System.out.println(papa.val + " " + papa.right.val + " " + papa.left.val);
	    	    					root = papa;
    							}
    						}
    						else if(succ.right != null) {						//(1 child)
    							rgt.left = succ.right;
    							if(papa.left == n) {
	    	    					papa.left = succ;
	    	    					succ.left = n.left;
	    	    					succ.right = n.right;
	    	    				}
	    	    				else if(papa.right == n) {
	    	    					papa.right = succ;
	    	    					succ.left = n.left;
	    	    					succ.right = n.right;
	    	    				}
//	    	    				else if(papa == n && n != root) {
//    								papa = succ;
//    								succ.left = n.left;
//	    	    					succ.right = n.right;
////	    	    					System.out.println(papa.val + " " + papa.right.val + " " + papa.left.val);
//    							}
	    	    				else if(papa == n && n == root) {
    								papa = succ;
    								succ.left = n.left;
	    	    					succ.right = n.right;
//	    	    					System.out.println(papa.val + " " + papa.right.val + " " + papa.left.val);
	    	    					root = papa;
    							}
    						}
    					}
    					else {
    						rgt = rgt.left;
    					}
    				}	
    			}
    		}
    	}
    }

    public void printBST () {
		//write your code here
    	int h = height(root)+1; 
//    	System.out.println("height==>" + h);
        int i; 
        for (i=1; i<=h; i++) 
            printGivenLevel(root, i); 
    } 
}