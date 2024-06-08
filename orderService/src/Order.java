public class Order {
    private Long id;
    private String customerName;
    private String adress;
    private Status status;

    public Order(Status status) {
        this.status = status;
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
    public String getStatus()
    {
        return status.toString();
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
    public void setStatus(Status status)
    {
       this.status = status;

    }


}
