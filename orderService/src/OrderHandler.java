import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Optional;
import java.io.BufferedReader;
import java.util.stream.Collectors;

public class OrderHandler implements HttpHandler
{
    private OrderService orderService = new OrderService();
    private  Gson gson = new Gson();

    @Override
    public void handle(HttpExchange exchange) throws IOException {
       String method = exchange.getRequestMethod();
       String path = exchange.getRequestURI().getPath();
       String response = "";


       if("GET".equals(method) && path.matches("/order/\\d+"))
       {
           Long id  = Long.parseLong(path.split("/")[2]);
           Optional<Order> order = orderService.getOrderById(id);
           if(order.isPresent()) {
               response = "found" + gson.toJson(order.get()).toString();
               System.out.println("found");
               System.out.println(response);
               exchange.sendResponseHeaders(200, response.length());
           }
           else
           {
               System.out.println("not found");
               exchange.sendResponseHeaders(404, response.length());
           }
       }
       else if("POST".equals(method) && path.matches("/order"))
       {
           InputStreamReader stream = new InputStreamReader(exchange.getRequestBody(), "utf-8");
           String  body = new BufferedReader(stream).lines().collect(Collectors.joining("\n"));
           Order order = gson.fromJson(body, Order.class);
           orderService.saveOrder(order);
           response = "created" + order.getCustomerName();
           System.out.println("created");
           exchange.sendResponseHeaders(201, response.length());
       }
    }
}


//git overview
/*
git pull
git checkout -b  ss/main
jk/main
ss/main
git --set-upstream-to origin/ss/master
git push
*/

