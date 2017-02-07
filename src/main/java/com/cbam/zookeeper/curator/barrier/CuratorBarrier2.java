package com.cbam.zookeeper.curator.barrier;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.atomic.AtomicValue;
import org.apache.curator.framework.recipes.atomic.DistributedAtomicInteger;
import org.apache.curator.framework.recipes.barriers.DistributedBarrier;
import org.apache.curator.framework.recipes.queue.DistributedQueue;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.curator.retry.RetryNTimes;

/**
 * Curator提供了三种Watcher(Cache)来监听结点的变化：

 Path Cache：监视一个路径下1）孩子结点的创建、2）删除，3）以及结点数据的更新。产生的事件会传递给注册的PathChildrenCacheListener。
 Node Cache：监视一个结点的创建、更新、删除，并将结点的数据缓存在本地。
 Tree Cache：Path Cache和Node Cache的“合体”，监视路径下的创建、更新、删除事件，并缓存路径下所有孩子结点的数据。
 */
public class CuratorBarrier2 {

	/** zookeeper地址 */
	static final String CONNECT_ADDR = "192.168.1.171:2181,192.168.1.172:2181,192.168.1.173:2181";
	/** session超时时间 */
	static final int SESSION_OUTTIME = 5000;//ms 
	
	static DistributedBarrier barrier = null;
	
	public static void main(String[] args) throws Exception {
		
		
		
		for(int i = 0; i < 5; i++){
			new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 10);
						CuratorFramework cf = CuratorFrameworkFactory.builder()
									.connectString(CONNECT_ADDR)
									.sessionTimeoutMs(SESSION_OUTTIME)
									.retryPolicy(retryPolicy)
									.build();
						cf.start();
						barrier = new DistributedBarrier(cf, "/super");
						System.out.println(Thread.currentThread().getName() + "设置barrier!");
						barrier.setBarrier();	//设置
						barrier.waitOnBarrier();	//等待
						System.out.println("---------开始执行程序----------");
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			},"t" + i).start();
		}

		Thread.sleep(5000);
		barrier.removeBarrier();	//释放
		
		
	}
}
