package avl;

public class avl {
	node root;
	public static int max(int a, int b) {
		if(a>b)
			return a;
		else
			return b;
	}
	int bl(node node) {
		int a = height1(node.left);
		int b = height1(node.right);
		if(node.left != null) {
			a++;
		}
		if(node.right != null) {
			b++;
		}
//		System.out.println("a, b = "+a + ", " + b);
		return (a - b);
	}
	
	public int abs(int a) {
		if (a < 0)
			return a*-1;
		else
			return a;
	}
	
	void rightrotate(node y) {
		node papa  = parent(y);
		node x = y.left;
		node T2 = x.right;
		x.right = y;
		y.left = T2;
		if(papa != null)
			papa.left = x;
	}
	
	void leftrotate(node z) {
		node papa = parent (z);
		node y = z.right; 
		node T2 = y.left;
		y.left = z;
//		y.parent = z.parent;
//		z.parent = y;
		z.right = T2;
		papa.left = y;
//		T2.parent =z;
	}
	
	node parent(node n) {
		if(n == root) {
//			System.out.println("root");
			return null;
		}else if(n == null) {
			return null;
		}
		else{
			node r = root;
			node p = root;
			while (true) {
				if(r.value == n.value) {
					return p;
				}
				else if(r.value > n.value) {
					p = r;
					r = r.left;
				}
				else if(r.value < n.value) {
					p = r;
					r = r.right;
				}
			}
		}
	}
	
	public void insert(int key, int value) {
//    	hm.put(key, value);
    	int i = 0;
    	node newnode = new node();
    	newnode.key = key;
    	newnode.value = value;
    	if(root == null) {
    		root = newnode;
    	}
    	else {
    		node n = root;
    		while(i == 0) {
    			int poty = n.value;
    			if(poty < (value) ) {
    				if(n.right == null) {
    					n.right = newnode;
    					i = 1;
    				}
    				else {
    					n = n.right;
    				}
    			}
    			else {
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
    	node papa = parent(newnode);
    	node gpapa = parent(papa);
    	if(papa != null && gpapa != null) {
    		System.out.println("kuch" + newnode.value);
    		while(gpapa != null) {
    			System.out.println("lol");
    			System.out.println(bl(gpapa));
//    			System.out.println("lh = " + height1(gpapa.left) + " rh = " + height1(gpapa.right));
    			if(bl(gpapa) > 1 && papa.left == newnode) {
    				System.out.println("ha");
    				rightrotate(gpapa);
    			}
    			else if(bl(gpapa) < 1 && papa.right == newnode) {
    				leftrotate(gpapa);
    			}
    			newnode = papa;
    			papa = gpapa;
    			gpapa = parent(papa);
    		}
    	}
    }
	
	int height1(node n){ 
	        if (n == null) 
	           return 0; 
	        else if (n.left != null || n.right != null)
	        { 
	            //System.out.println("root == > " + n.val +" left = " + n.left.val + " right = " + n.right.val);
	        	int lheight = height1(n.left); 
	            int rheight = height1(n.right); 
	              
	            if (lheight > rheight) 
	                return(lheight+1); 
	            else 
	            	return(rheight+1);  
	        }
	        else {
	        	return 0;
	        }
	    } 

	void printGivenLevel (node root ,int level) 
	    { 
	        if (root == null) 
	            return; 
	        if (level == 1) 
	            System.out.println(root.key + ", " + root.value); 
	        else if (level > 1) 
	        { 
	            printGivenLevel(root.left, level-1); 
	            printGivenLevel(root.right, level-1); 
	        } 
	    } 
		
	public void printBST () {
			//write your code here
	    	int h = height1(root)+1; 
//	    	System.out.println("height==>" + h);
	        int i; 
	        for (i=1; i<=h; i++) 
	            printGivenLevel(root, i); 
	    }

	public static void main(String args[]) {
		avl avl = new avl();
		avl.insert(1, 5);
		avl.insert(2, 4);
//		System.out.println(avl.height1(avl.root));
		avl.insert(3, 3);
//		avl.insert(4, 40);
//		avl.insert(5, 50);
//		avl.insert(6, 25);
//		avl.insert(7, 5);
//		avl.insert(8, 4);
//		avl.insert(9, 3);
//		avl.insert(10, 6);
		avl.printBST();
//		node n = avl.root.right.right.right;
//		System.out.println("val = " + n.value);
//		int x  = avl.parent(n).value;
//		System.out.println("pap value = " + x);
	}
}

class node{
	int key;
	int value;
	node left;
	node right;
//	node parent;
//	node(){
//		parent = null;
//	}
	
}