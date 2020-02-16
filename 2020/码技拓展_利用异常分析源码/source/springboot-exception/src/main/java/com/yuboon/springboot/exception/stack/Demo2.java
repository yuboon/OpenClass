package com.yuboon.springboot.exception.stack;

/**
 * @author yuboon
 * @version v1.0
 * @date 2020/01/20
 */
public class Demo2 {

    public void hello(){
        String nullString = null;
        nullString.toString();
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        for(StackTraceElement element : stackTraceElements){
            System.out.println(Thread.currentThread().getName() + " " + element.getMethodName());
        }
    }

    public static void main(String[] args) {
        //new Demo2().hello();

        System.out.println("-------------------------------");

        new Thread(() -> {
            new Demo2().hello();
        }).start();
    }

}
