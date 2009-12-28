package com.mmakowski.citron.expression;

import java.math.BigDecimal;

public class DecimalNumber implements Value, Expression<DecimalNumber> {
	private final BigDecimal value;
	
	public DecimalNumber(String value) {
		this.value = new BigDecimal(value);
	}
	
	public DecimalNumber(BigDecimal value) {
		this.value = value;
	}
	
	public BigDecimal toBigDecimal() {
		return value;
	}

	@Override
	public DecimalNumber evaluate() {
		return this;
	}
	
	@Override
	public boolean equals(Object o) {
		if (!(o instanceof DecimalNumber)) return false;
		return value.equals(((DecimalNumber) o).toBigDecimal());
	}
	
	@Override
	public int hashCode() {
		return value.hashCode();
	}
	
	@Override
	public String toString() {
		String str = value.toString();
		return str.endsWith(".0") ? str.substring(0, str.length() - 2) : str;
	}
}
