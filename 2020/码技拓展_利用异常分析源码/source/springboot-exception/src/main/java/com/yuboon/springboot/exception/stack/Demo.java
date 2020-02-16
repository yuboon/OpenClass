package com.yuboon.springboot.exception.stack;

/**
 * @author yuboon
 * @version v1.0
 * @date 2020/01/20
 */
public class Demo {

    public void hello(){
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        for(StackTraceElement element : stackTraceElements){
            System.out.println(element.getMethodName() + "," + element.getLineNumber());
        }
    }

    public static void main(String[] args) {
        new Demo().hello();
    }

}
