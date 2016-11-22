package com.dbs.code;

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
	
	private Stack operationStack;
	public Calculator(){
		operationStack= new Stack();
	}
	
	private float popStack(){
		return Float.valueOf(operationStack.pop().toString());
	}
	private void pushStack(Object data){
		operationStack.push(data);
	}
	private float publishResult() throws Exception{
		if(operationStack.size()==1)
			return popStack();
		else
			throw new Exception("Please insert a valid input");
	}

	private static boolean isOperator(String data){
		Pattern p = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(data);
		boolean result = m.find();
		return result;

	}
	
	
	public static void main(String[] args) {
		
	}
	
	

	public float calculate(String expression) throws Exception{
		// TODO Auto-generated method stub
		String[] argsArr=expression.split(",");
		for(int i=0;i<argsArr.length;i++){
			
			if(!isOperator(argsArr[i]))
				pushStack(argsArr[i]);
			else
				performBinaryOperation(argsArr[i]);
		}
		
		return publishResult();
		
	}
	
	
	private void performBinaryOperation(Object operator) throws Exception{

		if(operationStack.size()<2)
			throw new Exception("Please insert a valid input");
		
		float operationResult=0;
		float firstOperand=popStack();
		float secondOperand=popStack();
		
		if(operator.toString().equals("+")){
			operationResult=firstOperand+secondOperand;
			
		}else if(operator.toString().equals("-")){
			operationResult=secondOperand-firstOperand;
			
		}else if(operator.toString().equals("/")){
			operationResult=secondOperand/firstOperand;
			
		}else if(operator.toString().equals("*")){
			operationResult=secondOperand*firstOperand;
			
		}else if(operator.toString().equals("%")){
			operationResult=secondOperand%firstOperand;
			
		}
		pushStack(operationResult);
		
	
	}
	
	
	private float calculateFactorial(String fac) throws Exception{
		// TODO Auto-generated method stub
		int fact = 0;
		if(fac.indexOf(".")!=-1)
			throw new Exception("Factorail for float number is not possible.");
		
		else{
			fact = 1;
			int num=Integer.valueOf(fac);
			for(int i= 1; i<=num;i++)
				fact = fact * i;
				
		}
		return fact;
	}

}