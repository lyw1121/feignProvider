package com.example.tw;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


//测试模拟实现mybatis Mepper接口底层动态代理
public class TestProy implements InvocationHandler {
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getName().equals("say")){
            System.out.println("hello !!!!!!");
        }
        return null;
    }

    public static void main(String[] args) {
        testInvoke testIn = (testInvoke) Proxy.newProxyInstance(testInvoke.class.getClassLoader(), new Class<?>[]{testInvoke.class}, new TestProy());
                testIn.say();
    }
}
