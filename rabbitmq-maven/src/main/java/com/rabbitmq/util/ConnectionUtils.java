package com.rabbitmq.util;


import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class ConnectionUtils {
    /**
     * 获取MQ的连接
     * @return
     */
    public static Connection getConnection() throws IOException, TimeoutException {
        //定义一个连接工厂
        ConnectionFactory connectionFactory = new ConnectionFactory();
        //设置服务地址
        connectionFactory.setHost("127.0.0.1");
        //设置端口，AMQP的端口是5672
        connectionFactory.setPort(5672);
        //vhost
        connectionFactory.setVirtualHost("test_host");
        //设置用户名
        connectionFactory.setUsername("lilu");
        //设置密码
        connectionFactory.setPassword("061221");
        Connection connection = connectionFactory.newConnection();
        return connection;
    }
}
