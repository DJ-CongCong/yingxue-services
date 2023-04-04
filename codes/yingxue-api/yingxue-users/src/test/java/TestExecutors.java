import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TestExecutors {
    public static void main(String[] args) {

        //线程池工具类
        //a.线程池一   特点: 核心线程数=最大线程数  没有救急线程    队列是Integer最大值 无界队列 
        Executors.newFixedThreadPool(2);

        //b.线程池二   特点: 没有核心线程  都是救急线程 救急线程为Integer最大值    队列是同步队列: 来一个任务处理一个任务
        Executors.newCachedThreadPool();

        //c.线程三    特点: 核心线程数=最大线程数=1  没有救急线程   队列是Integer最大值 无界队列
        Executors.newSingleThreadExecutor();

        //d.线程四    特点: 核心线程自定义   救急线程为Integer最大值 救急线程没有存活时间 用完立即销毁  DelayedWorkQueue带有时间任务队列
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);

//        scheduledExecutorService.schedule(() -> {
//            System.out.println("1");
//        }, 20, TimeUnit.SECONDS);
        scheduledExecutorService.scheduleAtFixedRate(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(new SimpleDateFormat("HH:mm:ss").format(new Date()) + "-----> 1");
        }, 10, 5, TimeUnit.SECONDS);

    }
}
