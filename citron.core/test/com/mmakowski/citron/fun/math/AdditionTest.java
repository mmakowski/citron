package com.mmakowski.citron.fun.math;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.mmakowski.citron.expression.DecimalNumber;
import com.mmakowski.citron.expression.Expression;


public class AdditionTest {

	@Test
	public void testBasicAdditionProperties() {
		assertAdditionResult("1", "0", "1");
		assertAdditionResult("-1", "1", "0");
		assertAdditionResult("0.5", "-0.25", "0.25");
	}
	
	void assertAdditionResult(String op1, String op2, String result) {
		assertEquals(op1 + " + " + op2 + " = " + result, result, new Addition(op1, op2).evaluate().toString());
	}
	
	@Test
	public void testNontrivialSubexpressionsAreEvaluated() {
		Addition add = new Addition(
				new Expression<DecimalNumber>() {
					public DecimalNumber evaluate() { return new DecimalNumber("1"); }
				},
				new Expression<DecimalNumber>() {
					public DecimalNumber evaluate() { return new DecimalNumber("2"); }
				});
		assertEquals("1 + 2 = 3", new DecimalNumber("3"), add.evaluate());
	}
	
}
