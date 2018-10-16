package com.sawcao.beanoperation.map;

import net.sf.cglib.beans.BeanCopier;
import net.sf.cglib.beans.BeanMap;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: caorui
 * Time: 2018/9/28
 **/
public class CachedBeanMap {

    static final Map<String, BeanMap> BEAN_MAP = new HashMap<>();

    public static <T> Map toMap(T bean) {
        Map<String, Object> map = new HashMap<>();
        String key = bean.getClass().getName();
        BeanMap beanMap = null;
        if (!BEAN_MAP.containsKey(key)) {
            beanMap = BeanMap.create(bean);
            BEAN_MAP.put(key, beanMap);
        } else {
            beanMap = BEAN_MAP.get(key);
        }
        for (Object o : beanMap.keySet()) {
            map.put(o + "", beanMap.get(o));
        }
        return map;
    }

    public static <T> T toBean(Map map,T bean){
        String key = bean.getClass().getName();
        BeanMap beanMap = null;
        if (!BEAN_MAP.containsKey(key)) {
            beanMap = BeanMap.create(bean);
            BEAN_MAP.put(key, beanMap);
        } else {
            beanMap = BEAN_MAP.get(key);
        }
        for (Object o : beanMap.keySet()) {
            map.put(o + "", beanMap.get(o));
        }
        beanMap.putAll(map);
        return (T) beanMap.getBean();
    }

}
