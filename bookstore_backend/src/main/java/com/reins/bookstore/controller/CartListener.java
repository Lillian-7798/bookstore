package com.reins.bookstore.controller;

import com.reins.bookstore.service.CartService;
import com.reins.bookstore.utils.Websocket.WebsocketServer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class CartListener {
    @Autowired
    private CartService cartService;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private WebsocketServer ws;

    @KafkaListener(topics = "topic1",groupId = "test-consumer-group")
    public void topicListener(ConsumerRecord<String,String> record){
        String[] value = record.value().split(",");
        cartService.checkoutCart(value[0],Integer.valueOf(value[1]));
        kafkaTemplate.send("topic2",  "user", value[1]);
    }

    @KafkaListener(topics = "topic2", groupId = "test-consumer-group")
    public void topic2Listener(ConsumerRecord<String, String> record) {
        String value = record.value();
        System.out.println(value);
        ws.sendMessageToUser(value,"Done");
    }
}
