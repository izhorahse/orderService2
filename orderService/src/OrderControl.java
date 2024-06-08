import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.net.InetSocketAddress;


public class OrderControl
{
    private OrderService service = new OrderService();

    public static void main(String[] args) throws IOException
    {
        OrderControl controlRequest = new OrderControl();
        controlRequest.start();
    }

    private void start() throws IOException
    {

        Long port_number = 8989L;
        HttpServer server = HttpServer.create(new InetSocketAddress(8080),0);
        server.createContext("/orders", new OrderHandler());
        server.setExecutor(null);
        server.start();
        System.out.println("Server init ");

    }
}
