package com.sawcao.beanoperation.tests.cloning;

import com.sawcao.beanoperation.BeanHelper;
import com.sawcao.beanoperation.copier.CloneIngnore;
import com.sawcao.beanoperation.copier.CloningStrategyFactory;
import com.sawcao.beanoperation.copier.ICloningStrategy;
import org.junit.Test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static org.junit.Assert.*;

public class TestCloningStrategies {

	@Retention(RetentionPolicy.RUNTIME)
	@Target(ElementType.FIELD)
	@interface Ann {
	}

	class Data {
	}
	class AnnotatedExample {
		@CloneIngnore
		public Data o = new Data();
	}

	class NotAnnotatedExample {
		public Data o = new Data();
	}

	@Test
	public void annotatedClassPositive() {
		BeanHelper beanHelper = BeanHelper.standard();
		beanHelper.registerCloningStrategy(CloningStrategyFactory.annotatedField(ICloningStrategy.Strategy.NULL_INSTEAD_OF_CLONE));
		assertNull(beanHelper.deepClone(new AnnotatedExample()).o);
	}

	@Test
	public void annotatedClassNegative() {
		BeanHelper beanHelper = BeanHelper.standard();
		beanHelper.registerCloningStrategy(CloningStrategyFactory.annotatedField(ICloningStrategy.Strategy.NULL_INSTEAD_OF_CLONE));
		assertNotNull(beanHelper.deepClone(new NotAnnotatedExample()).o);
	}

	@Test
	public void annotatedClassSameInstancePositive() {
		BeanHelper beanHelper = BeanHelper.standard();
		beanHelper.registerCloningStrategy(CloningStrategyFactory.annotatedField(ICloningStrategy.Strategy.SAME_INSTANCE_INSTEAD_OF_CLONE));
		AnnotatedExample ae = new AnnotatedExample();
		assertSame(ae.o, beanHelper.deepClone(ae).o);
	}

	@Test
	public void annotatedClassSameInstanceNegative() {
		BeanHelper beanHelper = BeanHelper.standard();
		beanHelper.registerCloningStrategy(CloningStrategyFactory.annotatedField(ICloningStrategy.Strategy.SAME_INSTANCE_INSTEAD_OF_CLONE));
		NotAnnotatedExample ae = new NotAnnotatedExample();
		assertNotSame(ae.o, beanHelper.deepClone(ae).o);
	}
}
