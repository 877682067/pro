package com.jnl.pro.mq;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class RabbitMq implements MQ{

    private Connection conn;

    @Override
    public Connection createConnect(Config config) {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setUsername(config.getUserName());
        factory.setPassword(config.getPassWord());
        factory.setHost(config.getHost());
        factory.setPort(config.getPort());
        factory.setVirtualHost("/");
        Connection conn = null;
        try {
            conn = factory.newConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.conn = conn;
        return conn;
    }
}
