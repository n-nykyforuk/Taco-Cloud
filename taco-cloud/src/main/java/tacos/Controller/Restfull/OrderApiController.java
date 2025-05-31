
package tacos.Controller.Restfull;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tacos.Entity.TacoOrder;
import tacos.Repository.OrderRepository;
import tacos.Service.Message.OrderMessagingService;

@Slf4j
@RestController
@RequestMapping(path="/api/orders",
        produces="application/json")
@CrossOrigin(origins="http://localhost:8080")
public class OrderApiController {

    private OrderRepository repo;
    private OrderMessagingService messageService;

    public OrderApiController(OrderRepository repo, OrderMessagingService messageService) {
        this.repo = repo;
        this.messageService = messageService;
    }

    @PostMapping(consumes="application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public TacoOrder postOrder(@RequestBody TacoOrder order) {
        messageService.sendOrder(order);
        return repo.save(order);
    }
}
