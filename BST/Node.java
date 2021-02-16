package col106.assignment3.BST;

public class Node<T, E extends Comparable<E>>{
	public T key;
	public E val;
	public Node<T,E> left;
	public Node<T,E> right;
	public Node(T key, E value){
		this.key = key;
		this.val = value;
		this.left = null;
		this.right = null;
	}
}