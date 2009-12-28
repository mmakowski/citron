package com.mmakowski.citron.expression;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

public class DecimalNumberTest {
	
	@Test
	public void toBigDecimalReturnsInitialValue() {
		BigDecimal value = new BigDecimal("999998123132102.123419099349582"); 
		DecimalNumber num = new DecimalNumber(value);
		assertEquals("wrapped value", value, num.toBigDecimal());
	}
	
	@Test
	public void evaluatesToEqualDecimal() {
		DecimalNumber num = new DecimalNumber(new BigDecimal("999998123132102.123419099349582"));
		assertEquals("evaluated decimal", num, num.evaluate());
	}
	
	@Test
	public void toStringFormatIsCorrect() {
		String expected = "0";
		assertEquals("zero", expected, new DecimalNumber("0").toString());
		assertEquals("zero", expected, new DecimalNumber("0.0").toString());
		expected = "999998123132102.123419099349582";
		assertEquals("long decimal", expected, new DecimalNumber(expected).toString());
	}
}
