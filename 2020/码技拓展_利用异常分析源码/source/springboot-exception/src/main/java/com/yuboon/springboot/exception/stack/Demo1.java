package com.yuboon.springboot.exception.stack;

/**
 * @author yuboon
 * @version v1.0
 * @date 2020/01/20
 */
public class Demo1 {

    public void hello(){
        // JVM指令集
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        for(StackTraceElement element : stackTraceElements){
            //System.out.println(element.getMethodName() + " " + element.getLineNumber() + " " + element.getClassName());
            System.out.println(element.getClassName() + "." + element.getMethodName() + "(" + element.getClassName() + ".java" + ":" + element.getLineNumber()+ ")");
        }
    }

    public static void main(String[] args) {
        new Demo1().hello();
}

}
