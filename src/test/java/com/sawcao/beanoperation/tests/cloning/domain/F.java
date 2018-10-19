package com.sawcao.beanoperation.tests.cloning.domain;

import com.sawcao.beanoperation.copier.IFreezable;

/**
 *
 *
 * 15 Nov 2010
 */
public class F implements IFreezable
{
	private boolean	frozen	= false;

	public void setFrozen(final boolean frozen)
	{
		this.frozen = frozen;
	}

	public boolean isFrozen()
	{
		return frozen;
	}
}
