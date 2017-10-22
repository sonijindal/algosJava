package practice;

import java.util.Stack;

public class StackTest {

	Stack<Integer> dataStack = new Stack<Integer>();
	Stack<Integer> minElemStack = new Stack<Integer>();

	public void push(int x) {
		if (dataStack.empty()) {
			minElemStack.push(x);
		}
		else if (x < dataStack.peek()) {
			minElemStack.push(x);
		}
		dataStack.push(x);
	}

	public void pop() {
		int val = dataStack.pop();
		if (!dataStack.empty() && val == minElemStack.peek()) {
			minElemStack.pop();
		}
	}

	public int top() {
		return dataStack.pop();
	}

	public int getMin() {
		return minElemStack.peek();
	}
	public static boolean isOpening(char ch) {
		if (ch == '(' || ch == '{' || ch == '[') {
			return true;
		} else {
			return false;
		}
		}
		public static boolean isCompliment(char left, char right) {
			switch(left) {
			case '(':
				if (right == ')')
					return true;
				break;
			case '[':
				if (right == ']')
					return true;
				break;
			case '{':
				if (right == '}')
					return true;
				break;
			default:
				return false;
			}
			return false;
		}
		/* Check if the set of parantheses is valid */
		public static boolean isValid(String s) {
			Stack<Character> st = new Stack<Character>();

			for (int i = 0; i < s.length(); ++i) {

				if (isOpening(s.charAt(i))) {
					// Push to stack 
					st.push(s.charAt(i));
				} else {
					if (st.isEmpty() == true)
						return false;
					char ch = st.peek();

					if (isCompliment(ch, s.charAt(i)) == true) {
						//	System.out.println(ch + " at i " + s.charAt(i));
						st.pop();
					} else {
						return false;
					}
				}
			}
			if (st.size() != 0)
				return false;
			return true;
		}
}
