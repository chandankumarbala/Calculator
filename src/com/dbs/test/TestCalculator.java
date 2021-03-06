package com.dbs.test;

import org.junit.Test;

import com.dbs.code.Calculator;

import junit.framework.TestCase;

public class TestCalculator extends TestCase {
	
	Calculator cal=new Calculator();
	
	public void testAddition() throws Exception{
		String expression="15,30,+";
		assertEquals(45.0f,cal.calculate(expression));
		
	}
	public void testAdditionI() throws Exception{
		String expression="30,15,+";
		
		assertEquals(45.0f,cal.calculate(expression));
		
	}
	public void testDivision() throws Exception{
		String expression="30,15,/";
		 
		assertEquals(2.0f,cal.calculate(expression));
		
	}
	public void testDivisionI() throws Exception{
		String expression="15,30,/";
		 
		assertEquals(0.5f,cal.calculate(expression));
		
	}
	public void testMul() throws Exception{
		String expression="15,30,*";
		 
		assertEquals(450.0f,cal.calculate(expression));
		
	}
	public void testPercentile() throws Exception{
		String expression="15,30,%";
		 
		assertEquals(15.0f,cal.calculate(expression));
		
	}
	
	
	public void testAdditionIC() throws Exception{
		String expression="30,20,+";
	 
		assertEquals(50.0f,cal.calculate(expression));
		
	}
	

	public void testAdditionIE1() throws Exception{
		String expression="30,20,+,1,-";
		 
		try{
			cal.calculate(expression);
		}catch(Exception e){
		assertEquals("Please insert a valid input",e.getMessage());
		}
	}
	
	public void testAdditionIE2() throws Exception{
		String expression="30,20,+,1,-,/";
		 
		try{
			cal.calculate(expression);
		}catch(Exception e){
		assertEquals("Please insert a valid input",e.getMessage());
		}
	}
	
	
}