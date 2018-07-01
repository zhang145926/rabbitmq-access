package com.littlersmall.rabbitmqaccess.test;

import com.littlersmall.rabbitmqaccess.common.DetailRes;
import com.littlersmall.rabbitmqaccess.example.ConsumerExample;
import com.littlersmall.rabbitmqaccess.example.SenderExample;
import com.littlersmall.rabbitmqaccess.example.UserMessage;

public class TestMQ {

    public static void main(String[] args) throws Exception{

        SenderExample senderExample = new SenderExample();
        senderExample.init();

        UserMessage userMessage = new UserMessage();
        userMessage.setId(1);
        userMessage.setName("张凯停");
        senderExample.send(userMessage);

//        ConsumerExample consumerExample = new ConsumerExample();
//        consumerExample.init();
//
//        DetailRes detailRes = consumerExample.consume();
//
//        detailRes.isSuccess();

    }
}
