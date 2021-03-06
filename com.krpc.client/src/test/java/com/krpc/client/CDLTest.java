package com.krpc.client;

import org.junit.Test;

import com.krpc.client.net.ReceiverData;
import com.krpc.client.net.TCPClient;
import com.krpc.common.protocal.ProtocalConst;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

import javax.sound.sampled.ReverbType;

/**
 * @author: yangzhenkun01
 * @Date: 2018/6/19
 */
public class CDLTest {

    AtomicInteger atomicInteger = new AtomicInteger(0);
    int i = 0;

    @Test
    public void testCDL() throws InterruptedException {
        ConcurrentHashMap<Integer, Integer> map = new ConcurrentHashMap<>();
        Executor pool = Executors.newFixedThreadPool(20);
        CountDownLatch countDownLatch = new CountDownLatch(2000);

        for (int i = 0; i < 2000; i++) {
            pool.execute(new Runnable() {
                @Override
                public void run() {

                    map.put(incr(), 0);
                    countDownLatch.countDown();
                }
            });

        }


        countDownLatch.await();
//        countDownLatch.await(10,TimeUnit.DAYS);
        System.out.println("执行完毕");
        System.out.println(map.size());
    }


    private int incr() {


        return atomicInteger.incrementAndGet();
//        return i++;

    }
    
    
    @Test
    public void testIND(){
    	
    	atomicInteger.compareAndSet(0, 2);
    	
    	System.out.println(atomicInteger.incrementAndGet());
    	
    }
    
    
    @Test
    public void testByte(){
    	
    	try {
    		String start = new String(ProtocalConst.P_START_TAG);
			System.out.println(start);
			String end = new String(ProtocalConst.P_END_TAG);
			System.out.println(end);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    }
    
    
    
    
    


}
