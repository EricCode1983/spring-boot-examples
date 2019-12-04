package com.springboot.springbootioc;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class IocContainer {


    private Map<String,Object> beans = new ConcurrentHashMap<String, Object>();

    /**
     * 根据beanId 获取一个Bean
     *
     */
    /
    private Object getBean(String beanId){
        return  beans.get(beanId);
    }

    /**
     * 委托IOC 容器创建一个bean
     *
     */
    /
    public void setBeans(Class<?> clazz,String beanId,String... paramBeanIds)  {

        //1. 组装构造方法所需要的参数值

        Object[] paramValues=new Object[paramBeanIds.length];
        for (int i = 0; i < paramBeanIds.length; i++) {
           paramValues[i]=beans.get(paramBeanIds[i]);
        }
        //2. 调用构造方法实例化bean
        Object bean=null;
        for (Constructor<?> constructor : clazz.getConstructors()) {
            try {
                bean=constructor.newInstance(paramValues);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }

        }

        if (bean==null){
            throw  new RuntimeException("找不到合适的方法实例化bean");
        }

        //3. 将实例化的bean放入beans
        beans.put(beanId,bean);
    }
}
