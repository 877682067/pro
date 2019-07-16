package com.jnl.pro.mq;

import com.rabbitmq.client.Connection;

public interface MQ {

    Connection createConnect(Config config);


}
