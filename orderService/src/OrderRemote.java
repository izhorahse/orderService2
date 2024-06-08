
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class OrderRemote
{
    private Map<Long, Order> orders = new HashMap<>();
    private Long currentID = 1L;
    public  Optional<Order> getOrderById(Long id)
        {
            return Optional.ofNullable(orders.get(id));
        }
    public Order saveOrder(Order order)
    {
        if(order != null)
        {
            order.setID(currentID++);
        }
        orders.put(order.getID(),order );
        return order;
    }
    public void deleteOrder(Long id)
    {
        orders.remove(id);
    }
}
