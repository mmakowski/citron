package com.mmakowski.citron.ui.android;


/**
 * A thread that calculates the expression. 
 *
 */
class CalculationThread extends Thread {
	ExpressionEntry activity;
	String expression;
	
	CalculationThread(ExpressionEntry activity, String expression) {
		this.activity = activity;
		this.expression = expression;
	}
	
	@Override
	public void run() {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// ignore
		}
		activity.setResultFromNonUIThread("dupa");
	}
		
}
