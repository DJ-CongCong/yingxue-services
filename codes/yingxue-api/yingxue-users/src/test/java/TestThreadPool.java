import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;

public class TestThreadPool {

    public static void main(String[] args) {

        //创建线程池
//
//        /**
//         *
//         * int corePoolSize              核心线程数         线程池在创建过程中预先创建好的线程   2
//         * int maximumPoolSize           最大线程数         线程池可容纳最大线程数  3           救急线程个数 1  = 最大线程数 - 核心线程数
//         * long keepAliveTime            救急线程活跃时间
//         * TimeUnit unit                 救急线程存活时间单位
//         * BlockingQueue<Runnable> workQueue 线程等待队列  2
//         * ThreadFactory threadFactory       线程工厂     通过线程工厂附加操作
//         * RejectedExecutionHandler handler  拒绝策略     指定线程池中核心线程数满了  队列满了  救急线程满了  在过来请求执行什么操作
//         *
//         */
//        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
//                2,
//                3,  //3-2 = 1
//                10,
//                TimeUnit.MINUTES,
//                new ArrayBlockingQueue<Runnable>(2),
//                new ThreadFactory() {
//                    @Override
//                    public Thread newThread(Runnable r) {
//                        return new Thread(r);
//                    }
//                },
//                new ThreadPoolExecutor.AbortPolicy()   //拒绝并抛出异常  dubbo:  一直等待
//        );
//
//        //线程池方法 execute 没有获取任务执行结果 submit可以获取任务执行结果
//        for (int i = 0; i < 5; i++) {
//            threadPoolExecutor.submit(() -> {
//                System.out.println("thread: " + Thread.currentThread().getName());
//            });
//        }

        Map<String, String> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put("name", "xiaochen");

        //String[] str;
        //Node[] nodes;
        //Student[] students;


    }
}
