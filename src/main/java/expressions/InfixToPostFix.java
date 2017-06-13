package expressions;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class InfixToPostFix {
	List<Character> postfix = new LinkedList<Character>();
	OperandComparator opComparator = new OperandComparator();

	public static void main(String[] args) {
		//		String exp = "a+b*(c^d-e)^(f+g*h)-i";
		String exp = "A*(B+C*D)+E";
		InfixToPostFix obj = new InfixToPostFix();

		obj.convert(exp.toCharArray());
	}

	void convert(char[] infix){
		Stack<Character> s = new Stack<>();
		for(int i=0;i<infix.length;i++){
			char c = infix[i];

			Character character = Character.valueOf(c);
			if(isOperand(c)){
				postfix.add(character);
			}else{
				if(isOpenBrace(c)){
					s.push(character);
				} else if(isClosingBrace(c)){
					while(!s.isEmpty() && !s.peek().equals(Character.valueOf('('))){
						// ! on s.peek, to not add the opening brace - it simple has to be popped out.
						postfix.add(s.pop());
					}
					if(!s.isEmpty() && s.peek().equals(Character.valueOf('('))){
						// to remove opening brace - 
						s.pop();
					}
				} else{
					// operator
					Character peek = s.size()>0 ?s.peek() : null;

					if(s.isEmpty()){
						// nothing in stack, so feel free to push the operator
						s.push(character);
					}else{
						if(!s.isEmpty() && !s.peek().equals(Character.valueOf('('))){
							int comparison = opComparator.compare(s.peek(), character);

							if(comparison <0){
								// TOS has less preceedence than this operator
								s.push(character);
							}else if(comparison == 0){
								// TOS has equals preceedence 
								Association association = getAssociation(character);
								switch(association){
								case LEFT_TO_RIGHT:
									postfix.add(s.pop());
									s.push(character);
									break;
								case RIGHT_TO_LEFT:
									s.push(character);
									break;
								}
							}else{
								// comparison > 0, TOS has greater preceedence than this operator
								postfix.add(s.pop());
								s.push(character);
							}
						}else{
							s.push(character);
						}
					}


				}
			}
		}

		postfix.stream().forEach((x) -> System.out.print(x+" "));

		while(!s.isEmpty()){
			System.out.print(s.pop()+" ");
		}
	}


	boolean isOperand(char c){
		switch(c) {
		case '+':
		case '-':
		case '*':
		case '/':
		case '^':
		case '(':
		case ')':
			return false;
		}

		return true;
	}

	boolean isBrace(char c){
		switch(c){
		case '(':
		case ')':
			return true;
		}

		return false;
	}

	boolean isOpenBrace(char c){
		return isBrace(c) && c == '(';
	}

	boolean isClosingBrace(char c){
		return isBrace(c) && c == ')';
	}

	Association getAssociation(char c){
		switch(c){
		case '+':
		case '-':
		case '*':
		case '/':
		case '^':
			return Association.LEFT_TO_RIGHT;
		}

		return Association.RIGHT_TO_LEFT;
	}

	class OperandComparator implements Comparator<Character>{
		Map<Character, Integer> preceedenceMap = new HashMap<>();
		public OperandComparator() {
			preceedenceMap.put(Character.valueOf('+'), Integer.valueOf(10));
			preceedenceMap.put(Character.valueOf('-'), Integer.valueOf(10));
			preceedenceMap.put(Character.valueOf('*'), Integer.valueOf(15));
			preceedenceMap.put(Character.valueOf('/'), Integer.valueOf(20));
			preceedenceMap.put(Character.valueOf('^'), Integer.valueOf(125));
		}

		@Override
		public int compare(Character o1, Character o2) {
			int preceedenceIndexO1 = preceedenceMap.get(o1).intValue();
			int preceedenceIndexO2 = preceedenceMap.get(o2).intValue();

			return preceedenceIndexO1 - preceedenceIndexO2;

		}

	}

	enum Association{
		LEFT_TO_RIGHT, RIGHT_TO_LEFT;
	}
}
