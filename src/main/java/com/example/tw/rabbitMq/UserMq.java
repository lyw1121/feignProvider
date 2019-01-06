package com.example.tw.rabbitMq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public class UserMq {
    @Autowired
    AmqpTemplate rabbitTemplate;
    public void send(){
        String Msg= "tw被调用";
        System.out.println("发送"+Msg);
        this.rabbitTemplate.convertAndSend("directExchange","testHello",Msg);
    }

}
