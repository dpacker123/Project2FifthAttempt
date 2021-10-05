package comp.comp152;

public class Order {
    private ShippingAddress Destination;
    private Customer orderedBy;

    public String getDestination(){
        return Destination.toString();

    }

    public String getOrderer(){
        return orderedBy.toString();


    }

    public Order(ShippingAddress Destination, Customer orderedBy){
        super();
        this.Destination = Destination;
        this.orderedBy = orderedBy;
    }
}
