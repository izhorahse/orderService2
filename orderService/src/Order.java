public class Order {
    private Long id;
    private String customerName;
    private String adress;

    public Order()
    {

    }
    public Long getID()
    {
        return id;
    }
    public String getCustomerName()
    {
        return customerName;
    }
    public String getAdress()
    {
        return adress;
    }
    public void setID(Long new_id)
    {
        id = new_id;
    }
    public void setCustomerName(String name)
    {
        customerName = name;
    }
    public void setAdress(String adress)
    {
        this.adress = adress;
    }


}
