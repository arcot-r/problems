package problems;

import java.util.Stack;

public class ValidParanthesis {
	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<Character>();
		for (char c : s.toCharArray()) {
			switch (c) {
			case '(':
				stack.push(')');
				break;
			case '[':
				stack.push(']');
				break;
			case '{':
				stack.push('}');
				break;
			default:
				if (stack.isEmpty() || stack.pop() != c)
					return false;

			}
		}
		return stack.isEmpty();
	}
	public static void main(String[] args) {
		ValidParanthesis vp = new ValidParanthesis();
		System.out.println(vp.isValid("(){}}{"));
	}
}
