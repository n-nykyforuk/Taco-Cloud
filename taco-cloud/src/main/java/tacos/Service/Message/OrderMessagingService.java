package tacos.Service.Message;

import tacos.Entity.TacoOrder;

public interface OrderMessagingService {
    void sendOrder(TacoOrder order);
}
