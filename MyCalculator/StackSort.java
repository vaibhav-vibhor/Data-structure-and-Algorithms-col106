import java.util.*;

public class StackSort {
	
	static void PrintIntArray(int[] arr) {
		System.out.print("int array = ");
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ",");
		}
	}
	
	public StackSort() {
		//constructor
	}
	
	public static void PrintArray(String[] c) {
		System.out.print("array ==>");
		for(int i = 0; i < c.length; i++) {
			System.out.print(c[i] + ", ");
		}
		System.out.println("");
	}
	
	public static String[] sort(int[] nums) throws EmptyStackException{
	int p = 0;
	int q = 0;
	int z;
	String[] s = new String[2*nums.length];
	int[] poty = new int[nums.length];
	MyStack<Integer> stack =  new MyStack<Integer>();
	for (int i = 0; i < nums.length; i++) {
		System.out.println("\nnums[i] = " + nums[i]);
		if(stack.isEmpty()) {
			stack.push(nums[i]);
			s[p] = "PUSH";
			p++;
			stack.PrintStack();
			PrintArray(s);
		}
		else if(nums[i] < stack.top()) {
			stack.push(nums[i]);
			s[p] = "PUSH";
			p++;
			stack.PrintStack();
			PrintArray(s);
		}
		else if( nums[i] >= stack.top()) {
			if(nums[i] > stack.top()) {
				while(nums[i] > stack.top()) {
					int b;
					b = stack.pop();
					stack.PrintStack();
					System.out.println("b = " + b);
					s[p] = "POP";
					p++;
					poty[q] = b;
					q++;
					for( int j = i; j < nums.length; j++) {
						if(nums[j] < b) {
							String[] ss = new String[1];
							ss[0] = "NOTPOSSIBLE";
							return ss;
						}
					}
					System.out.println("sex");
					stack.PrintStack();
					PrintArray(s);
					PrintIntArray(poty);
					System.out.println();
					if(stack.isEmpty()) {
						break;
					}
				}
				stack.push(nums[i]);
				s[p] = "PUSH";
				p++;
				stack.PrintStack();
				PrintArray(s);
			}
			else if( nums[i] == stack.top()) {
				stack.push(nums[i]);
				s[p] = "PUSH";
				p++;
			}
		}
	}
	if(!stack.isEmpty()){
		while(!stack.isEmpty()) {
			int a = stack.pop();
			s[p] = "POP";
			p++;
			poty[q] = a;
			q++;
			PrintIntArray(poty);
			System.out.println();
			if(stack.isEmpty()) {
				break;
			}
		}
	}
	for(int i = 0; i < poty.length; i++) {
		System.out.print( poty[i] + "," );
	}
	System.out.println();
	return s;
	}
	
	public static String[] lolsort(int[] nums) throws EmptyStackException{
		int p = 0;
		int q = 0;
		int z;
		String[] s = new String[2*nums.length];
		int[] poty = new int[nums.length];
		MyStack<Integer> stack =  new MyStack<Integer>();
		for (int i = 0; i < nums.length; i++) {
//			System.out.println("\nnums[i] = " + nums[i]);
			if(stack.isEmpty()) {
				stack.push(nums[i]);
				s[p] = "PUSH";
				p++;
//				stack.PrintStack();
//				PrintArray(s);
			}
			else if(nums[i] < stack.top()) {
				stack.push(nums[i]);
				s[p] = "PUSH";
				p++;
//				stack.PrintStack();
//				PrintArray(s);
			}
			else if( nums[i] >= stack.top()) {
				if(nums[i] > stack.top()) {
					while(nums[i] > stack.top()) {
						int b;
						b = stack.pop();
//						stack.PrintStack();
//						System.out.println("b = " + b);
						s[p] = "POP";
						p++;
						poty[q] = b;
						q++;
//						for( int j = i; j < nums.length; j++) {
//							if(nums[j] < b) {
//								return s;
//							}
//						}
//						System.out.println("sex");
//						stack.PrintStack();
//						PrintArray(s);
//						PrintIntArray(poty);
						System.out.println();
						if(stack.isEmpty()) {
							break;
						}
					}
					stack.push(nums[i]);
					s[p] = "PUSH";
					p++;
//					stack.PrintStack();
//					PrintArray(s);
				}
				else if( nums[i] == stack.top()) {
					stack.push(nums[i]);
					s[p] = "PUSH";
					p++;
				}
			}
		}
		if(!stack.isEmpty()){
			while(!stack.isEmpty()) {
				int a = stack.pop();
				s[p] = "POP";
				p++;
				poty[q] = a;
				q++;
//				PrintIntArray(poty);
//				System.out.println();
				if(stack.isEmpty()) {
					break;
				}
			}
		}
//		for(int i = 0; i < poty.length; i++) {
//			System.out.print( poty[i] + "," );
//		}
//		System.out.println();
		return s;
		}
	
	public static int[] lolsort2(int[] nums) throws EmptyStackException{
		int p = 0;
		int q = 0;
		int z;
		String[] s = new String[2*nums.length];
		int[] poty = new int[nums.length];
		MyStack<Integer> stack =  new MyStack<Integer>();
		for (int i = 0; i < nums.length; i++) {
			//System.out.println("\nnums[i] = " + nums[i]);
			if(stack.isEmpty()) {
				stack.push(nums[i]);
				s[p] = "PUSH";
				p++;
//				stack.PrintStack();
//				PrintArray(s);
			}
			else if(nums[i] < stack.top()) {
				stack.push(nums[i]);
				s[p] = "PUSH";
				p++;
//				stack.PrintStack();
//				PrintArray(s);
			}
			else if( nums[i] >= stack.top()) {
				if(nums[i] > stack.top()) {
					while(nums[i] > stack.top()) {
						int b;
						b = stack.pop();
//						stack.PrintStack();
//						System.out.println("b = " + b);
						s[p] = "POP";
						p++;
						poty[q] = b;
						q++;
//						for( int j = i; j < nums.length; j++) {
//							if(nums[j] < b) {
//								return s;
//							}
//						}
//						System.out.println("sex");
//						stack.PrintStack();
//						PrintArray(s);
//						PrintIntArray(poty);
//						System.out.println();
						if(stack.isEmpty()) {
							break;
						}
					}
					stack.push(nums[i]);
					s[p] = "PUSH";
					p++;
//					stack.PrintStack();
//					PrintArray(s);
				}
				else if( nums[i] == stack.top()) {
					stack.push(nums[i]);
					s[p] = "PUSH";
					p++;
				}
			}
		}
		if(!stack.isEmpty()){
			while(!stack.isEmpty()) {
				int a = stack.pop();
				s[p] = "POP";
				p++;
				poty[q] = a;
				q++;
//				PrintIntArray(poty);
//				System.out.println();
				if(stack.isEmpty()) {
					break;
				}
			}
		}
//		for(int i = 0; i < poty.length; i++) {
//			System.out.print( poty[i] + "," );
//		}
//		System.out.println();
		return poty;
		}
	
	
	public static String[][] kSort(int nums[]) throws EmptyStackException{
		String [][] sexy = new String[1000000][2*nums.length];
		int[] comp = nums.clone();
		Arrays.sort(comp);
		System.out.print("comp = ");
		PrintIntArray(comp);
		System.out.print("intitial nums = ");
		PrintIntArray(nums);
		int k = 0;
		while(true) {
			sexy[k] = lolsort(nums);
			System.out.print("nums = ");
			PrintIntArray(nums);
			System.out.print("sexy[k] = ");
			PrintArray(sexy[k]);
			k++;
			nums = lolsort2(nums);
			System.out.print("nums new = ");
			PrintIntArray(nums);
			if(Arrays.equals(nums, comp)) {
				System.out.println( " k = " + k);
				break;
			}
		}
		String[][] foo = new String[k][2*nums.length];
		for(int i = 0; i < k; i++ ) {
			foo[i] = sexy[i]; 
		}
		return foo;
	}
}


// expected 150