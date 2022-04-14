package com.zzm.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ProxyTest implements InvocationHandler {

    private Object target;


    public ProxyTest(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("了解该学生的学习情况");
        System.out.println("Method:"+method);
        method.invoke(target, args);
        System.out.println("鼓励下该同学");
        return null;
    }

}
