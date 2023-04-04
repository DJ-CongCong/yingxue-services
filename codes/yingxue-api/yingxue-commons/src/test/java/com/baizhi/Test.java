package com.baizhi;

import java.util.concurrent.*;

public class Test {
    public static void main(String[] args) {


    }

    public void play() {
        main(new String[]{":"});
    }
}

class Animal {
    private String name;

    public void eat() {
    }

    public Animal() {
        System.out.println("==========");
    }
}

class Dog extends Animal {
    public void eat() {
    }

    public void play() {
    }
}

class Cat extends Animal {
    public void eat() {
    }

    public void runing() {
    }

    public static void main(String[] args) {

    }
}

class TestThread {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        //1.使用
//        new MyThread().start();
//
//        //2.实现runnable
//        new Thread(new MyTask()).start();
//
//        //3.线程池
//        //new ThreadPoolExecutor();
//        ExecutorService executorService = Executors.newFixedThreadPool(1);
//        Future<?> submit = executorService.submit(() -> {
//            System.out.println("thread: " + Thread.currentThread().getName());
//        });
//        executorService.execute(() -> {
//            System.out.println("thread: " + Thread.currentThread().getName());
//        });
//
//        //4.callable 接口
//        FutureTask<Integer> integerFutureTask = new FutureTask<>(new MyCallable());
//        new Thread(integerFutureTask).start();
//
//        System.out.println(integerFutureTask.get());
//

        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(User.getInstance());
               /* try {
                    System.out.println(Emp.getInstance());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
            }).start();
        }

    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("thread: " + Thread.currentThread().getName());
    }
}

class MyTask implements Runnable {
    @Override
    public void run() {
        System.out.println("thread: " + Thread.currentThread().getName());
    }
}

class MyCallable implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println("thread callable: " + Thread.currentThread().getName());
        return 12;
    }
}

//恶汉式
class User {
    private static User user = new User();

    private User() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static User getInstance() {
        return user;
    }
}

//懒汉式
class Emp {
    private static Emp emp;

    private Emp() throws InterruptedException {
        Thread.sleep(1000);
    }

    //t1  222 t2  111
    public static Emp getInstance() throws InterruptedException {
        synchronized (Emp.class) {
            if (emp == null) { //t1
                emp = new Emp();
            }
            return emp;
        }
    }
}