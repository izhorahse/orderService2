import java.util.Optional;

public class OrderService {
    private OrderRemote orderRemote = new OrderRemote();

    public Optional<Order> getOrderById(Long id) {
        return orderRemote.getOrderById(id);
    }

    public Order saveOrder(Order order) {
        return orderRemote.saveOrder(order);
    }

    public void deleteOrder(Long id)
    {
        orderRemote.deleteOrder(id);
    }
}
