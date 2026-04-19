package streamSampleProject;

import java.util.List;

class Order {
    private int orderId;
    private String customerName;
    private String city;
    private List<Item> items;
    private double totalAmount;
    private String status; // "DELIVERED", "CANCELLED", "PENDING"

    public Order(int orderId, String customerName, String city, List<Item> items, double totalAmount, String status) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.city = city;
        this.items = items;
        this.totalAmount = totalAmount;
        this.status = status;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
