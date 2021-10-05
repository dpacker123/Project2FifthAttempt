package comp.comp152;

import java.util.ArrayList;

public class Customer {
    private ArrayList<ShippingAddress> addresses;
    private String name;
    private int CustomerID;

public Customer(String customerName, int custID){
    name = customerName;
    addresses = new ArrayList<ShippingAddress>();
    CustomerID = custID;
}
public String toString(){
    var allCustomers = addresses + name + CustomerID;
    return allCustomers;
}
public String getName(){
    return name;
}
public void addAddress(ShippingAddress newAddress){
    addresses.add(newAddress);
}
}
