package com.mmakowski.citron.expression;

public interface Expression<ResultType extends Value> {
	ResultType evaluate();
}
