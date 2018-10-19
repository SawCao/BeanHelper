package com.sawcao.beanoperation.tests.cloning;

import com.sawcao.beanoperation.BeanHelper;
import org.junit.Test;

import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;

/**
 *
 * 23 Sep 2012
 */
public class CloneInnerAnonTest
{
	class TestInner
	{
		public Object o = new Object();

		public CloneInnerAnonTest parent = CloneInnerAnonTest.this;

		public CloneInnerAnonTest getParent()
		{
			return CloneInnerAnonTest.this;
		}
	}

	@Test
	public void dontCloneParentOfInnerClassesPositive()
	{

		final BeanHelper cl = new BeanHelper();
		cl.setCloneAnonymousParent(false);

		final TestInner test = new TestInner();
		final TestInner testCloned = cl.deepClone(test);
		assertNotSame(this, testCloned.parent);
		assertNotSame(test.o, testCloned.o);
		assertSame(test.getParent(), testCloned.getParent());
	}

	@Test
	public void dontCloneParentOfInnerClassesNegative()
	{

		final BeanHelper cl = new BeanHelper();
		cl.setCloneAnonymousParent(true);

		final TestInner test = new TestInner();
		final TestInner testCloned = cl.deepClone(test);
		assertNotSame(this, testCloned.parent);
		assertNotSame(test.o, testCloned.o);
		assertNotSame(test.getParent(), testCloned.getParent());
	}
}
