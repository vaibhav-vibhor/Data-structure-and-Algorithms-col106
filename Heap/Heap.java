package col106.assignment3.Heap;
import java.util.HashMap;
import java.util.Vector;

public class Heap<T, E extends Comparable<E>> implements HeapInterface <T, E> {
	/* 
	 * Do not touch the code inside the upcoming block 
	 * If anything tempered your marks will be directly cut to zero
	*/
	
	public Vector<E> array = new Vector<E>();
	public int size = 0;
	public HashMap<T, E> hm = new HashMap<T,E>();

	
	public static void main() {
		HeapDriverCode HDC = new HeapDriverCode();
		System.setOut(HDC.fileout());
	}
	
	public static void main(String args[]) {
		
	}
	
	public int size() {
		return size;
	}
	
	void swap(Vector<E> array, int i, int j) {
		E a = array.elementAt(i);
//		T ak = retkey(hm, a);
		E b = array.elementAt(j);
//		T bk = retkey(hm, a);
		array.set(i, b);
		array.set(j, a);
	}
	
	public void insert(T key, E value) {
		//write your code here
		
		hm.put(key, value);
		array.add(size, value);
		size++;
		int i = size-1;
		while(Math.floorDiv((i-1), 2) >= 0 && array.elementAt(i).compareTo(array.elementAt(Math.floorDiv((i-1), 2))) > 0){
			swap(array, i, Math.floorDiv((i-1), 2));
			i = Math.floorDiv((i-1), 2);
		}		
	}

	T retkey(HashMap<T,E> hm, E value) {
		for(T key : hm.keySet()){
			if(value.equals(hm.get(key))) {
				return key;
			}
		}
		return null;
	}
	
	public E extractMax() {
		//write your code here
		E waste = array.elementAt(0);
		E lully = array.elementAt(0);
		T lullykey = retkey(hm, lully);
		//System.out.println(lullykey);
		delete(lullykey);
		hm.remove(lullykey);
		return waste;
	}

	public T extractMax1() {
		//write your code here
		E lully = array.elementAt(0);
		T lullykey = retkey(hm, lully);
		//System.out.println(lullykey);
		delete(lullykey);
		hm.remove(lullykey);
		return lullykey;
	}
	
	public void delete(T key) {
		//write your code here
		E temp = array.elementAt(size - 1);
		int index = array.indexOf(hm.get(key));
		//System.out.println("index = "+index);
//		System.out.println(hmi.get(key));
//		System.out.println("index = " + index + " key = " + key );
		array.set(index, temp);
		//System.out.println("temp key = " + retkey(hm, temp));
		hm.remove(key);
		array.remove(size - 1);
		size--;
		if(size == 0) {
//			System.out.println("heap empty");
			return;
		}
		int x;
		if(2*index + 2 < size) {
			if(array.elementAt(2*index+1).compareTo(array.elementAt(2*index + 2)) > 0){
				x = 2*index+1;
			}
			else {
				x = 2*index + 2;
			}
			while(x < size && array.elementAt(index).compareTo(array.elementAt(x)) < 0 ) {
				swap(array, index, x);
				index = x;
				//yaha check if 2*index is < size
				if(2*index +1 >= size) {
					break;
				}
				else if(2*index+1 < size && 2*index+2 >= size) {
					x = 2*index+1;
				}
				else if(array.elementAt(2*index+1).compareTo(array.elementAt(2*index + 2)) > 0){  //yaha nhi kuch gadbad hai
					x = 2*index+1;
				}
				else if(array.elementAt(2*index+1).compareTo(array.elementAt(2*index + 2)) < 0){
					x = 2*index + 2;
				}
			}
		}	
		else if(2*index + 2 >= size && 2*index + 1 < size) {
			x = 2*index + 1;
			if(x < size && array.elementAt(index).compareTo(array.elementAt(x)) < 0) {
				swap(array, index, x);
			}
		}
	}

	public void increaseKey(T key, E value) {
		//write your code here
		int t = array.indexOf(hm.get(key));
		hm.replace(key, value);
		//System.out.println(t);
		array.set(t, value);
		//System.out.println(t + " " + value);
		int i = t;
		while(Math.floorDiv((i-1), 2) >= 0 && array.elementAt(i).compareTo(array.elementAt(Math.floorDiv((i-1), 2))) > 0){
			swap(array, i, Math.floorDiv((i-1), 2));
			i = Math.floorDiv((i-1), 2);
		}
	}

	public void printHeap() {
		//write your code here
		for(int i = 0; i < size; i++) {
			System.out.println(retkey(hm, array.elementAt(i)) + ", " + array.elementAt(i));
		}
	}	
}
