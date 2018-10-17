package com.rabbitmq.simple;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.util.ConnectionUtils;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Send {
    private static final String QUEUE_NAME="test_simple_queue";
    public static void main(String[] args) throws IOException, TimeoutException {
        //获取连接
        Connection connection = ConnectionUtils.getConnection();
        System.out.println("连接成功==========");
        //从连接中获取一个通道
        Channel channel = connection.createChannel();
        //创建队列声明
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);

        String msg = "hello simple!";
        channel.basicPublish("",QUEUE_NAME,null,msg.getBytes());
        System.out.println("发送的消息是："+msg);
        //用完之后需要将通道和连接都关闭
        channel.close();
        connection.close();
    }
}
