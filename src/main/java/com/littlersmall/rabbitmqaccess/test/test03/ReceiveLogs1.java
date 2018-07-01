package com.littlersmall.rabbitmqaccess.test.test03;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class ReceiveLogs1 {

    private static final String EXCHANGE_NAME = "logs";

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("123.57.17.90");
        factory.setUsername("zhangkt");
        factory.setPassword("zhangkt0411");
        factory.setPort(5672);
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.exchangeDeclare(EXCHANGE_NAME, "fanout");

        //产生一个随机的队列名称
        String queueName = channel.queueDeclare().getQueue();
        channel.queueBind(queueName, EXCHANGE_NAME, "");//对队列进行绑定

        System.out.println("ReceiveLogs1 Waiting for messages");
        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body, "UTF-8");
                System.out.println("ReceiveLogs1 Received '" + message + "'");
            }
        };
        channel.basicConsume(queueName, true, consumer);//队列会自动删除
    }
}
