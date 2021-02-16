package col106.assignment4.HashMap;
import java.util.Vector;

public class HashMap<V> implements HashMapInterface<V> {

	public static void main(String[] args) {
		System.out.println("lil");
	}

	public HashMap(int size) {
		// write your code here
	}

	public V put(String key, V value){
		// write your code here
		int a = foo(key);
		int index = a%array.size();
		if(array.elementAt(index) == null) {
			node<V> n = new node<V>();
			n.key = key;
			n.value = value;
			array.set(index, n);
		}
		else if(array.elementAt(index).key.equals(key)){
			node<V> oldn = array.elementAt(index);
			V retval = oldn.value;
			node<V> n = new node<V>();
			n.key = oldn.key;
			n.value = value;
			array.set(index, n);
			return retval;
		}
		else {
			for(int i = 0; i < array.size(); i++) {
				if(array.elementAt((index + i)%array.size()) == null ) {
					node<V> n = new node<V>();
					n.key = key;
					n.value = value;
					array.set((index + i)%array.size(), n);
				}
			}
		}
		return null;
	}

	public V get(String key){
		// write your code here
		return null;
	}

	public boolean remove(String key){
		// write your code here
		return false;
	}

	public boolean contains(String key){
		// write your code here
		return false;
	}

	public Vector<String> keySet(){
		// write your code here
		return null;
	}
}
