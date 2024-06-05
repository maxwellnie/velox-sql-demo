package com.example.demo.po;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.dynamic.loading.ClassLoadingStrategy;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.matcher.ElementMatchers;

import java.io.OutputStream;
import java.io.PrintStream;

/**
 * @author Maxwell Nie
 */
public class Base {
    public Object f(OutputStream var_010292) throws InstantiationException, IllegalAccessException {
        return new ByteBuddy()
                .subclass(PrintStream.class)
                .method(ElementMatchers.named("print"))
                .intercept(MethodDelegation.to(var_010292))
                .method(ElementMatchers.named("write"))
                .intercept(MethodDelegation.to(var_010292))
                .method(ElementMatchers.named("println"))
                .intercept(MethodDelegation.to(var_010292))
                .make()
                .load(Thread.currentThread().getContextClassLoader(), ClassLoadingStrategy.Default.INJECTION)
                .getLoaded()
                .newInstance();
    }
}
