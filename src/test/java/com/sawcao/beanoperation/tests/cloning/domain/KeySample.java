package com.sawcao.beanoperation.tests.cloning.domain;

/**
 * Created by IntelliJ IDEA.
 * User: caorui
 * Time: 2018/10/10
 **/
import com.sawcao.beanoperation.BeanHelper;
import jdk.nashorn.api.scripting.ClassFilter;
import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.core.KeyFactory;

import java.io.IOException;

public class KeySample {


    private interface MyFactory {
        public Object newInstance(int a, char[] b, String d);
    }
    public static void main(String[] args) {
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "D:\\code");
        MyFactory f = (MyFactory)KeyFactory.create(MyFactory.class);
        Object key1 = f.newInstance(20, new char[]{ 'a', 'b' }, "hello");
        Object key2 = f.newInstance(20, new char[]{ 'a', 'b' }, "hello");
        Object key3 = f.newInstance(20, new char[]{ 'a', '_' }, "hello");
        System.out.println(key1.equals(key2));
        System.out.println(key1.toString());
        System.out.println(key2.equals(key3));

    }
}
