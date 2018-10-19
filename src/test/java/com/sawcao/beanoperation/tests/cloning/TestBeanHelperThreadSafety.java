package com.sawcao.beanoperation.tests.cloning;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;
import java.util.TreeMap;

import com.sawcao.beanoperation.BeanHelper;
import junit.extensions.ActiveTestSuite;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * test thread safety of BEAN_HELPER
 * 
 *
 *
 * 18 Jan 2009
 */
public class TestBeanHelperThreadSafety extends TestCase
{
	private static final BeanHelper BEAN_HELPER = new BeanHelper(); // use 1 BEAN_HELPER for all tests (all threads)

	public void testCloner()
	{
		final Random r = new Random();
		for (int i = 0; i < 10000; i++)
		{
			final Calendar cal = Calendar.getInstance();
			final Calendar clone = BEAN_HELPER.deepClone(cal);
			assertNotSame(cal, clone);
			assertNotSame(cal.getTime(), clone.getTime());
			assertTrue(cal.equals(clone));

			if (r.nextBoolean())
			{
				Thread.yield();
			}
			final List<Calendar> l = new ArrayList<Calendar>();
			l.add(cal);
			l.add(Calendar.getInstance());
			final List<Calendar> lClone = BEAN_HELPER.deepClone(l);
			assertNotSame(l, lClone);
			assertEquals(l.size(), lClone.size());
			assertEquals(l.get(0), lClone.get(0));
			assertEquals(l.get(1), lClone.get(1));
			if (r.nextBoolean())
			{
				Thread.yield();
			}
			try
			{
				final URL url = new URL("http://localhost");
				assertEquals(url, BEAN_HELPER.deepClone(url));
			} catch (final MalformedURLException e)
			{
				throw new RuntimeException(e);
			}
			final TreeMap<String, Object> m = new TreeMap<String, Object>();
			m.put("cal", cal);
			m.put("clone", clone);
			final TreeMap<String, Object> dm = BEAN_HELPER.deepClone(m);
			assertEquals(m.size(), dm.size());
			assertNotSame(m.get("cal"), dm.get("cal"));
			assertEquals(m.get("cal"), dm.get("cal"));
			assertNotSame(m.get("clone"), dm.get("clone"));
			assertEquals(m.get("clone"), dm.get("clone"));
			if (r.nextBoolean())
			{
				Thread.yield();
			}
		}
	}

	public static Test suite()
	{
		final TestSuite testSuite = new TestSuite();
		for (int i = 0; i < 80; i++)
		{
			testSuite.addTest(new ActiveTestSuite(TestBeanHelperThreadSafety.class));
		}
		return testSuite;
	}
}
