package com.dbs.test;

import org.junit.Test;

import com.dbs.code.Calculator;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.TestCase;

public class TestCalculator extends TestCase {
	

	public void testAddition() throws Exception{
		String expression="15,30,+";
		Calculator cal=new Calculator();
		assertEquals(45.0f,cal.calculate(expression));
		
	}
	public void testAdditionI() throws Exception{
		String expression="30,15,+";
		Calculator cal=new Calculator();
		assertEquals(45.0f,cal.calculate(expression));
		
	}
	public void testDivision() throws Exception{
		String expression="30,15,/";
		Calculator cal=new Calculator();
		assertEquals(2.0f,cal.calculate(expression));
		
	}
	public void testDivisionI() throws Exception{
		String expression="15,30,/";
		Calculator cal=new Calculator();
		assertEquals(0.5f,cal.calculate(expression));
		
	}
	public void testMul() throws Exception{
		String expression="15,30,*";
		Calculator cal=new Calculator();
		assertEquals(450.0f,cal.calculate(expression));
		
	}
	public void testPercentile() throws Exception{
		String expression="15,30,%";
		Calculator cal=new Calculator();
		assertEquals(15.0f,cal.calculate(expression));
		
	}
	
	
	public void testAdditionIC() throws Exception{
		String expression="30,20,+";
		Calculator cal=new Calculator();
		assertEquals(50.0f,cal.calculate(expression));
		
	}
	
	
	public void testAdditionIE() throws Exception{
		String expression="";
		Calculator cal=new Calculator();
		try{
			cal.calculate(expression);
		}catch(Exception e){
		assertEquals("Please insert the data in form of operand,operand,operator",e.getMessage());
		}
	}
	public void testAdditionIE1() throws Exception{
		String expression="30,20,+,1,-";
		Calculator cal=new Calculator();
		try{
			cal.calculate(expression);
		}catch(Exception e){
		assertEquals("Please insert a valid input",e.getMessage());
		}
	}
	
	public void testAdditionIE2() throws Exception{
		String expression="30,20,+,1,-,/";
		Calculator cal=new Calculator();
		try{
			cal.calculate(expression);
		}catch(Exception e){
		assertEquals("Please insert a valid input",e.getMessage());
		}
	}
	
	
}