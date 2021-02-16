
class EmptyStackException extends Exception{
	public EmptyStackException(String s)
	{
	// Call constructor of parent Exception
		super(s);
		}
}

public class MyStack<T>{
	Object[] a;
	int stackSize = 0;
	
	public MyStack(){                                   //constructor
		a = new Object[1];
	}
	void push(T value) {                                //push function
		if(a.length <= stackSize) {
			int p = a.length;
			Object[] b = new Object[2*p];
			for (int i = 0; i < p; i++) {
				b[i] = a[i];
			}
			b[p] = value;
			stackSize ++;
			a = b;
		}
		else{
			a[stackSize] = value;
			stackSize++;
		}
	}
	@SuppressWarnings("unchecked")
	T valAt(int i) {                                     // gets value at
		return (T) a[i];
	}
	T pop() throws EmptyStackException {                 //pops and returns
		if(stackSize != 0) {
			@SuppressWarnings("unchecked")
			T x = (T) a[stackSize - 1];
			stackSize --;
			return x;
		}
		else {
			throw new EmptyStackException("the stack is empty!!");
		}
	}
	int size() {                                        //returns size (int)
		return stackSize;
	}
	@SuppressWarnings("unchecked")
	T top() throws EmptyStackException{                 //returns top element
		if(stackSize != 0) {
			return (T) a[stackSize-1];
		}else {
			throw new EmptyStackException("stack empty!!");
		}
		
	}
	boolean isEmpty() {                                 // isEmpty boolean
		if(stackSize == 0) {
			return true;
		}
		else{return false;}
	}
	
	void PrintStack() {
		
	}
	
}
