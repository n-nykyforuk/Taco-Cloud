/*
package tacos.Service.Message;

import jakarta.jms.JMSException;
import jakarta.jms.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;
import org.springframework.jms.support.converter.MessageConverter;
import tacos.Entity.TacoOrder;

@Component
public class JmsOrderReceiver implements OrderReceiver {

    private JmsTemplate jmsTemplate;
    private MessageConverter converter;

    @Autowired
    public JmsOrderReceiver(JmsTemplate jmsTemplate, MessageConverter converter) {
        this.jmsTemplate = jmsTemplate;
        this.converter = converter;
    }

    @Override
    public TacoOrder receiveOrder() throws JMSException {
        Message message = jmsTemplate.receive("tacocloud.order.queue");
        return (TacoOrder) converter.fromMessage(message);
    }
}
*/