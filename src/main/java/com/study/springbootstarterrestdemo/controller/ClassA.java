package com.study.springbootstarterrestdemo.controller;

/**
 * @Author 来苏
 */
public class ClassA {
    private static int a = 0;

    public synchronized void do1(){ //锁的是this对象
        a++;
    }
    public static synchronized void do2(){//锁的是ClassA.class对象
        a++;
    }

    public static void main(String[] args) {
        ClassA classA = new ClassA();
        new Thread(()-> classA.do1()).start();
        new Thread(()-> classA.do2()).start();
    }
}
