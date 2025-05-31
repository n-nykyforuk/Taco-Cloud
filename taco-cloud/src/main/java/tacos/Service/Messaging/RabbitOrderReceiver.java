package tacos.Service.Messaging;

import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tacos.Entity.TacoOrder;
import org.springframework.amqp.core.Message;


@Component
public class RabbitOrderReceiver {

    private RabbitTemplate rabbitTemplate;
    private MessageConverter converter;

    @Autowired
    public RabbitOrderReceiver(RabbitTemplate rabbitTemplate, MessageConverter converter) {
        this.rabbitTemplate = rabbitTemplate;
        this.converter = converter;
    }

    public TacoOrder receiveOrder() {
        Message message = rabbitTemplate.receive("tacocloud.order");
        return message != null
                ? (TacoOrder) converter.fromMessage(message)
                : null;
    }
}
