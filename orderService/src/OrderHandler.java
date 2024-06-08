import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.util.Optional;

public class OrderHandler implements HttpHandler
{

    @Override
    public void handle(HttpExchange exchange) throws IOException {
       String method = exchange.getRequestMethod();
       String path = exchange.getRequestURI().getPath();
       String response = "";


       if("GET".equals(method) && path.matches("/order/\\d+"))
       {
           Long id  = Long.parseLong(path.split("/")[2]);
           OrderService orderService = new OrderService();
           Optional<Order> order = orderService.getOrderById(id);
           if(order.isPresent()) {
               response = "found" + order.get().getCustomerName();
               exchange.sendResponseHeaders(200, response.length());
           }


           // Patch, Delete, Post
       }
    }
}
