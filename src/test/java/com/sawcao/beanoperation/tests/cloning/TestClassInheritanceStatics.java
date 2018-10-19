package com.sawcao.beanoperation.tests.cloning;

import com.sawcao.beanoperation.BeanHelper;
import org.junit.Test;

/**
 * @author kostas.kougios
 * Date: 12/06/17
 */
public class TestClassInheritanceStatics {

	static class Parent {
		private String instanceFieldParent;
		private static String staticFieldParent;
	}

	static class Child extends Parent {
		private String instanceFieldChild;
		private static String staticFieldChild;
	}

	@Test
	public void testStaticFields_Parent() {
		BeanHelper beanHelper = new BeanHelper();
		beanHelper.registerStaticFields(Parent.class);
		// Works fine
	}

	@Test
	public void testStaticFields_Child() {
		BeanHelper beanHelper = new BeanHelper();
		beanHelper.registerStaticFields(Child.class);
		// Fails
	}
}
