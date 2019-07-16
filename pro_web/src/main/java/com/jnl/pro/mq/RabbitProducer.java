package com.jnl.pro.mq;

import com.alibaba.fastjson.JSONObject;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class RabbitProducer implements Runnable {
    private static AtomicInteger i = new AtomicInteger(1);
    private Connection conn;
    private String queueName;

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        if (conn != null) {
            try {
                // 创建通道
                Channel channel = conn.createChannel();
                // 声明队列【参数说明：参数一：队列名称，参数二：是否持久化；参数三：是否独占模式；参数四：消费者断开连接时是否删除队列；参数五：消息其他参数】
                channel.queueDeclare(queueName, true, false, false, null);
                Map<String,Integer> ms = new HashMap<>();
                ms.put("id",i.get());
                ms.put("value",i.get());
                i.getAndAdd(1);
                String content = JSONObject.toJSONString(ms);
                // 发送内容【参数说明：参数一：交换机名称；参数二：队列名称，参数三：消息的其他属性；参数四：消息主体】
                channel.basicPublish("", queueName, null, content.getBytes("UTF-8"));
                System.out.println("已发送消息：" + content);
                // 关闭连接
                channel.close();
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public RabbitProducer(Connection conn,String queueName){
        this.conn = conn;
        this.queueName = queueName;
    }

}
