package com.mmakowski.citron.fun.math;

import com.mmakowski.citron.expression.DecimalNumber;
import com.mmakowski.citron.expression.Expression;
import com.mmakowski.citron.expression.FunctionApplication;


public class Addition implements FunctionApplication<DecimalNumber> {
	private Expression<DecimalNumber> op1, op2;
	
	public Addition(Expression<DecimalNumber> op1, Expression<DecimalNumber> op2) {
		this.op1 = op1;
		this.op2 = op2;
	}
	
	@Override
	public DecimalNumber evaluate() {
		return new DecimalNumber(op1.evaluate().toBigDecimal().add(op2.evaluate().toBigDecimal()));
	}

}
