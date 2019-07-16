package com.jnl.pro.mq;

import com.alibaba.fastjson.JSONObject;
import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Consumer implements Runnable{

    private final Connection conn;
    private final String queueName;

    private int i = 0;

    public Consumer(Connection conn, String queueName){
        this.conn = conn;
        this.queueName = queueName;
    }


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
        try {
            // 创建通道
            Channel channel = conn.createChannel();
            // 声明队列【参数说明：参数一：队列名称，参数二：是否持久化；参数三：是否独占模式；参数四：消费者断开连接时是否删除队列；参数五：消息其他参数】
            channel.queueDeclare(queueName, true, false, false, null);

            // 创建订阅器，并接受消息
            channel.basicConsume(queueName, false, "", new DefaultConsumer(channel) {
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties,
                                           byte[] body) throws IOException {
                    String routingKey = envelope.getRoutingKey(); // 队列名称
                    String contentType = properties.getContentType(); // 内容类型
                    String content = new String(body, "utf-8"); // 消息正文
                    JSONObject obj = JSONObject.parseObject(content);
                    int value = new Integer(obj.get("value").toString());
                    i = i+value;
                    System.out.println("消息正文：" + content);
                    System.out.println("当前I：" + i);
                    channel.basicAck(envelope.getDeliveryTag(), false); // 手动确认消息【参数说明：参数一：该消息的index；参数二：是否批量应答，true批量确认小于index的消息】
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
