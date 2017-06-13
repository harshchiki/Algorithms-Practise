package expressions;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class PostfixEvaluation {
	public static void main(String[] args) {
		List<String> postfix = new LinkedList<>();
		postfix.add("2");
		postfix.add("3");
		postfix.add("1");
		postfix.add("*");
		postfix.add("+");
		postfix.add("9");
		postfix.add("-");
		
		new PostfixEvaluation().evaluation(postfix);
	}

	void evaluation(List<String> postfix){
		Stack<String> s = new Stack<>();

		for(int i = 0;i<postfix.size();i++){
			String c = postfix.get(i);

			if(isOperator(c)){
				if(s.size()>1){
					int operand2 = Integer.parseInt(s.pop());
					int operand1 = Integer.parseInt(s.pop());
					s.push(String.valueOf(getResult(operand1, operand2, c)));
				}
			}else{
				s.push(c);
			}
			logTrace(c, s, i);
		}
		
		if(s.size() == 1){
			System.out.println(s.pop());
		}
	}
	
	void logTrace(String cFound, Stack<String> s, int index){
		System.out.print("Found = "+cFound+" at index "+ index+" Stack: ");
		s.stream().forEach((x) -> System.out.print(x));
		System.out.println();
	}

	int getResult(int op1, int op2, String op){
		if(op.length()>1){
			throw new RuntimeException("Bad operator! "+op);
		}
		char operator = op.toCharArray()[0];
		switch(operator){
		case '+':
			return op1 + op2;
		case '-':
			return op1 - op2;
		case '*':
			return op1 * op2;
		case '/':
			return op1 / op2;
		}
		return 0;
	}

	boolean isOperator(String c){
		if(c.length() > 1){
			return false;
		}else{
			char value =c.toCharArray()[0];
			switch(value){
			case '+':
			case '-':
			case '*':
			case '/':
				return true;
			}
		}
		return false;
	}
}
