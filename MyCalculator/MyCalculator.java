import java.util.Arrays;

public class MyCalculator {
		
		public void PrintArray(String[] c) {
//			System.out.print("array ==>");
//			for(int i = 0; i < c.length; i++) {
//				System.out.print(c[i] + ", ");
//			}
//			System.out.println("");
		}
		public MyCalculator() {
			//constructor
		}
		
		boolean ZeroBrackets(String[] c) {
			for(int i = 0; i < c.length; i++) {
				if(c[i].equals("(")) {
					return false;
				}
			}
			return true;
		}
		
		boolean isDigit(String s) {
			try {
				Integer.parseInt(s); 
	            return true; 
			}
			catch (NumberFormatException e)  
	        { 
	            return false; 
	        } 
		}
		
		int StackSolver(String[] c ) throws EmptyStackException {
			MyStack<Integer> ints = new MyStack<Integer>();
			MyStack<Character> chars = new MyStack<Character>();
			String str = "";
			int sum = 0;
			for(int i = 0; i < c.length; i++) {
				//System.out.println("c[i] = " + c[i]);
				//System.out.println("isDigit = "+isDigit(c[i]));				
				if(isDigit(c[i])) {
					ints.push(Integer.parseInt(c[i]));
				}
				else {
					if(c[i].equals("+")) {
						if(chars.size() != 0 && chars.top() == '-') {
							if(chars.top() == '-') {
								int a = ints.pop();
								ints.push(a*-1);
								chars.pop();
								chars.push('+');
								chars.push('+');
//								chars.PrintStack();
//								System.out.println("----");
//								ints.PrintStack();
							}
						}
						else if(chars.size() != 0 && chars.top() == '*') {
							if(chars.top() == '*') {
								int a = ints.pop();
								int b = ints.pop();
								int k = a*b;
								System.out.println("k ==> " + k);
								ints.push(k);
								chars.pop();
								chars.push('+');
//								chars.PrintStack();
//								System.out.println("----");
//								ints.PrintStack();
							}
						}
						else {
							chars.push('+');
//							chars.PrintStack();
//							System.out.println("----");
//							ints.PrintStack();
						}
					}
					if(c[i].equals("-")) {
						
						if(chars.size() != 0 && chars.top() == '*') {
							if(chars.top() == '*') {
								int a = ints.pop();
								int b = ints.pop();
								int k = a*b;
								System.out.println("k ==> " + k);
								ints.push(k);
								chars.pop();
								chars.push('-');
//								chars.PrintStack();
//								System.out.println("----");
//								ints.PrintStack();
							}
						}
						else if(chars.size() != 0 && chars.top() == '-') {
							if(chars.top() == '-') {
								int a = ints.pop();
								ints.push(a*-1);
								chars.pop();
								chars.push('+');
								chars.push('-');
//								chars.PrintStack();
//								System.out.println("----");
//								ints.PrintStack();
							}
						}
						else {
							chars.push('-');
//							chars.PrintStack();
//							System.out.println("----");
//							ints.PrintStack();
						}
					}
					if(c[i].equals("*")) {
						if(chars.size() != 0 && chars.top() == '-') {
							if(chars.top() == '-') {
								int a = ints.pop();
								ints.push(a*-1);
								chars.pop();
								chars.push('+');
								chars.push('*');
//								chars.PrintStack();
//								System.out.println("----");
//								ints.PrintStack();
							}
						}
						else if(chars.size() != 0 && chars.top() == '*') {
							if(chars.top() == '*') {
								int a = ints.pop();
								int b = ints.pop();
								int k = a*b;
								System.out.println("k ==> " + k);
								ints.push(k);
								chars.pop();
								chars.push('*');
//								chars.PrintStack();
//								System.out.println("----");
//								ints.PrintStack();
							}
						}
						else {
							chars.push('*');
//							chars.PrintStack();
//							System.out.println("----");
//							ints.PrintStack();
						}
					}
				}
				if( i == c.length - 1) {
					//int z1 = Integer.parseInt(str);
					//System.out.println("i="+ i +" z="+z1);
					if(chars.size() == 0 && ints.size() == 1) {
						return ints.top();
					}
//					else if(chars.top() == '+') {
//						ints.push(z1);
//					}
					else if(chars.top() == '*') {
						int a = ints.pop();
						int b = ints.pop();
						ints.push(a*b);
						chars.pop();
					}
					else if(chars.top() == '-') {
						int z1 = ints.pop();
						ints.push(z1*-1);
						chars.pop();
						chars.push('+');
					}
				}
			}
//			chars.PrintStack();
//			System.out.println("====");
//			ints.PrintStack();
			while(ints.size() != 1) {
				int a = ints.pop();
				int b = ints.pop();
				ints.push(a+b);
			}
			sum = ints.top();
			//System.out.println("answer to subarray is ==> " + sum);
			return sum;			
		}
		
		int calculate( String s) throws EmptyStackException {
			s = s.replaceAll("\\s", "");
			System.out.println(s);
			int p = s.length();
			//System.out.println("p = "+p);
			String[] charray = new String[2*100000];
			int sum = 0;
			int cl = 0;
			String poop = "";
			for (int i = 0; i < p; i++) {
				//System.out.println("s.charAt(i) = " + s.charAt(i));
				if(s.charAt(i) != ')' && s.charAt(i) != '(' && s.charAt(i) != '*' && s.charAt(i) != '+' && s.charAt(i) != '-') {
					poop += s.charAt(i);
					//System.out.println("poop = " + poop);
				}
				else {
					if(poop != "") {
						charray[cl] = poop;
						//System.out.println("cl = " + cl);
						poop = "";
						cl++;
					}
					charray[cl] = Character.toString(s.charAt(i));
					cl++;
				}
				if(i == p-1 && s.charAt(i) != ')' ) {
					//System.out.println("lauda");
					charray[cl] = poop;
					cl++;
				}
			}
			//PrintArray(charray);
			//System.out.println("cl = " + cl);
			String[] cut = new String[cl];
			for(int i = 0; i < cl; i++) {
				cut[i] = charray[i];
			}
			charray = cut;
			PrintArray(charray);
			//StackSolver(charray);
			for(int i = 0; i < charray.length; i++) {
//				if(i == 0 ) {
//					System.out.println(i);
//				}
				//System.out.println(i);
				//System.out.println(ZeroBrackets(charray));
				if(ZeroBrackets(charray)) {
					sum = StackSolver(charray);
					break;
				}
				if(charray[i].equals(")") ) {
					int y = i;
					//System.out.println("y = " + y);
					for(int j = y; j >= 0; j--) {
						if(charray[j].equals("(")) {
							int x = j;
							//System.out.println("x = " + x);
							String[] subarray = new String[y-x-1];
							subarray = Arrays.copyOfRange(charray, x+1, y);
							//PrintArray(subarray);
							int res = StackSolver(subarray);
							//System.out.println("res = " + res);
							//int sss = Integer.toString(res).length();
							String[] newarr = new String[charray.length - (y - x)];
							//System.out.println("newarr size =" + (charray.length - (y - x)));
							int pp = 0;
							int q = 0;
							for(int k = 0; k < charray.length; k++ ) {
								if( k >= x && k <= y && pp == 0) {
									newarr[k] = Integer.toString(res);
									q = k;
									pp++;
								}else if(k > y) {
									q++;
									newarr[q] = charray[k];
									//System.out.println("q = " + q + " k = " + k);
									
								}else if(k < x) {
									newarr[k] = charray[k];
								}
							}
							PrintArray(newarr);
							charray = newarr;
							PrintArray(charray);
							break;
						}
					}	
					i = -1;
				}
				
			}
			System.out.println("final answer = " + sum);
			return sum;
		} 
		
		
}
