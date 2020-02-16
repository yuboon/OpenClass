package com.yuboon.springboot.exception.stack;

/**
 * @author yuboon
 * @version v1.0
 * @date 2020/01/20
 */
public class Demo3 {

    public void hello(){
        String nullString = null;
        nullString.toString();
    }

    public static void main(String[] args) {
        new Demo3().hello();
    }

}
