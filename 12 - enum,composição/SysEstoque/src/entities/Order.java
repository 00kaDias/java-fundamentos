package entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {
    private Date moment = new Date();
    private OrderStatus status;
    private List<OrderItem> itemsList = new ArrayList<>();
    private Client cliente;
    
    public Order() {
    }

    public Order(OrderStatus status, Client cliente) {
        this.status = status;
        this.cliente = cliente;
    }
    public Date getMoment() {
        return moment;
    }

    public void setMoment(Date moment) {
        this.moment = moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public List<OrderItem> getItemsList() {
        return itemsList;
    }

    public void setItemsList(List<OrderItem> itemsList) {
        this.itemsList = itemsList;
    }

    public void addItem(OrderItem item) {
        itemsList.add(item);
    }

    public void removeItem(OrderItem item) {
        itemsList.remove(item);
    }

    public Double total() {
        double sum = 0;
        for (OrderItem o : itemsList) {
            sum += o.subTotal();
        }
        return sum;
    }

    public Client getCliente() {
        return cliente;
    }

    public void setCliente(Client cliente) {
        this.cliente = cliente;
    }
}
