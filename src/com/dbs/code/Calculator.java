package com.dbs.code;

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

	private static boolean detectOperation(String data){
		Pattern p = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(data);
		boolean result = m.find();
		return result;

	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String data="30,40,+";//args[0];
	}
	
	

	public float calculate(String expression) throws Exception{
		// TODO Auto-generated method stub
		
		String trimmedString=expression.trim();
		if(trimmedString.length()<3){
			throw new Exception("Please insert the data in form of operand,operand,operator");
		}
		String[] argsArr=expression.split(",");
		if(detectOperation(argsArr[argsArr.length-1]) && detectOperation(argsArr[argsArr.length-2])){
			throw new Exception("Please insert a valid input");
		}
		
		Float result;	
		
		Stack operationStack = new Stack();
		for(int i=0;i<argsArr.length;i++){
			float temp;
			if(!detectOperation(argsArr[i])){
				operationStack.push(argsArr[i]);
				
			}else if(argsArr[i].equals("!")){
				temp=calculateFactorial(operationStack.pop().toString());
				
				
			}
			else{
				float stOperand=Float.valueOf(operationStack.pop().toString());
				float ndoperand=Float.valueOf(operationStack.pop().toString());
				if(argsArr[i].toString().equals("+")){
					temp=stOperand+ndoperand;
					operationStack.push(temp);
				}else if(argsArr[i].toString().equals("-")){
					temp=ndoperand-stOperand;
					operationStack.push(temp);
				}else if(argsArr[i].toString().equals("/")){
					temp=ndoperand/stOperand;
					operationStack.push(temp);
				}else if(argsArr[i].toString().equals("*")){
					temp=ndoperand*stOperand;
					operationStack.push(temp);
				}else if(argsArr[i].toString().equals("%")){
					temp=ndoperand%stOperand;
					operationStack.push(temp);
				}
				
				
			}
		}
		
		if(operationStack.size()!=1)
			throw new Exception("Please insert a valid input");
		
		result=(Float)operationStack.pop();
		return result;
		
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