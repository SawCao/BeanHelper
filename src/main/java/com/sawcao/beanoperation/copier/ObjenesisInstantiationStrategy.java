package com.sawcao.beanoperation.copier;

import org.objenesis.Objenesis;
import org.objenesis.ObjenesisStd;

/**
 *
 *
 * 17 Jul 2012
 */
public class ObjenesisInstantiationStrategy implements IInstantiationStrategy
{
	private final Objenesis	objenesis	= new ObjenesisStd();

	public <T> T newInstance(Class<T> c)
	{
		return objenesis.newInstance(c);
	}

	private static ObjenesisInstantiationStrategy	instance	= new ObjenesisInstantiationStrategy();

	public static ObjenesisInstantiationStrategy getInstance()
	{
		return instance;
	}
}
