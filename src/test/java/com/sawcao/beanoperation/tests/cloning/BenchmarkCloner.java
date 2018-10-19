package com.sawcao.beanoperation.tests.cloning;

import com.sawcao.beanoperation.BeanHelper;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

/**
 *
 *
 * 7 Nov 2008
 */
public class BenchmarkCloner
{

	public static void main(final String[] args) throws MalformedURLException
	{
		final long start = System.currentTimeMillis();
		final BeanHelper beanHelper = new BeanHelper();
        int j = 30000000;
        final Calendar gc = Calendar.getInstance();

        // data
        final URL url = new URL("http://localhost");
        final HashMap<String, Integer> m = new HashMap<String, Integer>();
        m.put("kostas", 100);
        m.put("tina", 120);
        m.put("george", 150);

        A a = new A();

        // benchmark
        while (j-- > 0)
		{
			final ArrayList<URL> l = new ArrayList<URL>();
			for (int i = 0; i < 5; i++)
			{
				l.add(url);
			}
/*			final URL clone = beanHelper.deepClone(url);
			l.add(clone);
			final ArrayList<URL> clonedList = beanHelper.deepClone(l);
			clonedList.add(url);
			beanHelper.deepClone(clonedList);
			beanHelper.deepClone(gc);

			beanHelper.deepClone(m);

            beanHelper.deepClone(a);
            beanHelper.deepClone(a);
            beanHelper.deepClone(a);
            beanHelper.deepClone(a);*/
        }
		System.out.println("dt=" + (System.currentTimeMillis() - start));
	}

    static class B {
        public String s = "this is b";
    }

    static class A {
        public int x = 5;
        public B b = new B();
    }
}
