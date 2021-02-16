import java.util.HashMap;


public class rb_bst<T, E extends Comparable<E>> {
    public node<T, E> root = null;
    HashMap<T,E> hm = new HashMap<>();

    public static void main(String[] args) {
        rb_bst<Integer,Integer> rbbst = new rb_bst<>();
        rbbst.insert(1,10);
        rbbst.insert(2,18);
        rbbst.insert(3,7);
        rbbst.insert(4,15);
        rbbst.insert(5,16);
        rbbst.insert(6,30);
        rbbst.insert(7,25);
        rbbst.insert(8,40);
        rbbst.insert(9,60);
        rbbst.insert(10,2);
        rbbst.insert(11,1);
        rbbst.insert(12,70);
        rbbst.print_rb_BST();
    }

    public void insert(T key, E value) {
        hm.put(key, value);
        int i = 0;
        node<T, E> newnode = new node<T,E>(key, value);
        if(root == null) {
            root = newnode;
            newnode.color = "black";
        }
        else {
            node<T,E> n = root;
            newnode.color = "red";
            while(i == 0) {
                E poty = n.value;
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
            if (conflict(newnode)){
                if (sib_red(parent(newnode))){
                    fix_one(newnode);
                }else {
                    fix_two(newnode);
                }
            }
        }
    }

    node<T,E> parent(node<T,E> n){
        node<T, E> papa = root;
        node<T, E> temp = root;
//        System.out.println("n key, val " + n.key +", " + n.val);
        if (n == root){
//            System.out.println("teri maa");
            return null;
        }else {
            while (temp.value.compareTo(n.value) != 0) {
                if (temp.value.compareTo(n.value) > 0) {
                    papa = temp;
                    temp = temp.left;
                } else if (temp.value.compareTo(n.value) < 0) {
                    papa = temp;
                    temp = temp.right;
                }
            }
            return papa;
        }
    }

    boolean conflict(node<T,E> n){
        return n.color.compareTo("red") == 0 && parent(n).color.compareTo("red") == 0;
    }

    boolean sib_red(node<T,E> n){
        node<T,E> sib = sibling(n);
        if (sib == null)
            return false;
        return sib.color.compareTo("red") == 0;
    }

    node<T,E> sibling(node<T,E> n){
        node<T,E> papa = parent(n);
        node<T,E> sib;
        if(n == papa.left)
            sib = papa.right;
        else
            sib= papa.left;
        return sib;
    }

    void color_switch(node<T,E> n){
        if (n.color.compareTo("red") == 0)
            n.color = "black";
        else
            n.color = "red";
    }

    void fix_one(node<T,E> r){
        parent(r).color = "black";
        sibling(parent(r)).color = "black";
        if (parent(parent(r)) != root)
            color_switch(parent(parent(r)));
        if(parent(parent(r)) != root && conflict(parent(parent(r)))){
            if(sib_red(parent(parent(parent(r))))){
                fix_one(parent(parent(r)));
            }
            else
                fix_two(parent(parent(r)));
        }
    }

    void fix_two(node<T,E> r){
        if(r == parent(r).right && parent(r) == parent(parent(r)).right){
            left_rotate(parent(parent(r)));
            color_switch(parent(r));
            color_switch(sibling(r));
        }
        else if(r == parent(r).right && parent(r) == parent(parent(r)).left){
            left_rotate(parent(r));
            right_rotate(parent(r));
            color_switch(r);
            color_switch(r.right);
        }
        else if(r == parent(r).left && parent(r) == parent(parent(r)).right){
            right_rotate(parent(r));
            left_rotate(parent(r));
            color_switch(r);
            color_switch(r.left);
        }
        else if (r == parent(r).left && parent(r) == parent(parent(r)).left){
            right_rotate(parent(parent(r)));
            color_switch(parent(r));
            color_switch(sibling(r));
        }
    }

    void right_rotate(node<T,E> z){
        node<T,E> y = z.left;
        node<T,E> x = y.left;
        node<T,E> papa = parent(z);
        if (papa != null) {
            if (papa.left == z) {
                papa.left = y;
            } else {
                papa.right = y;
            }
        }else {
            root = y;
        }
        z.left = y.right;
        y.right = z;
    }

    void left_rotate(node<T,E> z){
        node<T,E> y = z.right;
        node<T,E> x = y.right;
        node<T,E> papa = parent(z);
        if (papa != null) {
            if (papa.left == z) {
                papa.left = y;
            } else {
                papa.right = y;
            }
        }else {
            root = y;
        }
        z.right = y.left;
        y.left = z;
    }

    public int height(node<T, E> n){
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

    public void print_rb_BST () {
        //write your code here
        int h = height(root)+1;
//    	System.out.println("height==>" + h);
        int i;
        for (i=1; i<=h; i++)
            printGivenLevel(root, i);
        System.out.println("tree height = " + height(root));
    }

    void printGivenLevel (node<T, E> root ,int level)
    {
        if (root == null)
            return;
        if (level == 1)
            System.out.println(root.key + ", " + root.value + ", " + root.color);
        else if (level > 1)
        {
            printGivenLevel(root.left, level-1);
            printGivenLevel(root.right, level-1);
        }
    }

}

class node<T,E>{
    T key;
    E value;
    String color;
    node<T,E> left;
    node<T,E> right;
    node(T key, E value){
        this.key = key;
        this.value = value;
        this.left = null;
        this.right = null;
        this.color = null;
    }
}
