package com.sawcao.beanoperation.copier;


public class CloningStrategyFactory {

	public static ICloningStrategy annotatedField(final ICloningStrategy.Strategy strategy) {
		return (toBeCloned, field) -> {
			if (toBeCloned == null) return ICloningStrategy.Strategy.IGNORE;
			if (field.getDeclaredAnnotation(CloneIngnore.class) != null) return strategy;
			return ICloningStrategy.Strategy.IGNORE;
		};
	}

}

