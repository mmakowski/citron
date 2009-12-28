package com.mmakowski.citron.ui.android;

import com.mmakowski.citron.expression.Expression;
import com.mmakowski.citron.expression.Value;
import com.mmakowski.citron.parser.Parser;


/**
 * A thread that calculates the expression. 
 *
 */
class CalculationThread extends Thread {
	ExpressionEntry activity;
	String expressionStr;
	
	CalculationThread(ExpressionEntry activity, String expressionStr) {
		this.activity = activity;
		this.expressionStr = expressionStr;
	}
	
	@Override
	public void run() {
		Parser parser = new Parser();
		Expression<Value> expression = parser.parse(expressionStr);
		Value value = null;
		try {
			value = expression.evaluate();
		} catch (Throwable t) {
			activity.setResultFromNonUIThread("ERROR: " + t.getMessage());
		}
		activity.setResultFromNonUIThread(value.toString());
	}
		
}
