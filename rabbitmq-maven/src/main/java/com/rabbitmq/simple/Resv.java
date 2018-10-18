package com.rabbitmq.simple;

import com.rabbitmq.client.*;
import com.rabbitmq.util.ConnectionUtils;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * 消费者消费消息
 */
//fsdagasgg1111
public class Resv {
    private static final String QUEUE_NAME="test_simple_queue";
    public static void main(String[] args) throws IOException, TimeoutException {
        //获取连接
        Connection connection = ConnectionUtils.getConnection();
        //创建通道
        Channel channel = connection.createChannel();
        //队列声明
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);
        DefaultConsumer consumer = new DefaultConsumer(channel) {
            //获取到达消息
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {

                String msgString = new String(body, "utf-8");
                System.out.println("消费的消息：" + msgString);

            }
        };
        //监听队列
        channel.basicConsume(QUEUE_NAME,true,consumer);

    }
}
