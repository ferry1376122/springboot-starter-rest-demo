package com.study.springbootstarterrestdemo.controller;

/**
 * @Author 来苏
 * 懒汉式单例设计模式
 * 两个问题：
 * 1、两次检查对象是否被实例化的原因能否明白？
 * 回答：当有多个线程同时进入getInstance方法的时候，同时通过了第一层的判断，然后进入到锁环节，有一个
 * 线程获取到了锁资源，然后进去构建了一个对象，然后释放锁，那么其他的线程进入到锁代码块中，如果不进行
 * 一次非空判断的话，将会每个线程都创建出一个对象出来；
 * 2、为instance变量加上volatitle关键字的目的是什么？如果不加，会让该单例设计模式失效吗？
 * 回答：不加，不会让单例模式失效，不加的话问题在哪里，加锁和volatile关键字都能够保证变量的可见性，但是
 * 这两个保证变量可见性的方式是有些不一样的，volatile是在使用的时候去内存中重新加载，而锁是要进入到共享
 * 资源的时候，去内存中重新加载，放在我们这个案例中，如果不加的话，就是当有大量的并发请求到达getInstance
 * 方法的时候，这些请求就会都卡在synchronized代码块的地方去等待抢夺CPU资源，当抢夺到的时候再去判断instance
 * 的最新的值，这样的话，就会造成了拥堵，大量线程堵在synchronize的地方，如果你加了volatile的话，那么这些
 * 并发线程在进入到getInstance方法的时候，就会发现instance的最新值，从而直接结束方法，不会一起在锁附近拥堵
 *
 */
public class Singleton {
    private static volatile Singleton instance;

    private Singleton(){
    }

    public Singleton getInstance(){
        //第一次检查对象是否实例化了
        if (instance==null){
            synchronized (this){
                //第二次检查对象是否实例化了
                if (instance==null){
                    //创建实例
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
