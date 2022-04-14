package com.zzm.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Tset {

    public static void main(String[] args) {
        Person realStu = new Student();

        //传入被代理对象，最后通过被代理对象调用方法
        InvocationHandler handler = new ProxyTest(realStu);

        Person proxyStu = (Person) Proxy.newProxyInstance(handler.getClass().getClassLoader(),
                realStu.getClass().getInterfaces(), handler);

        System.out.println(proxyStu.getClass().getName());

        proxyStu.giveMoney("李林");
        proxyStu.Money();
    }
}
