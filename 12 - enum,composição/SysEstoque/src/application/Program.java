package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {
public static void main(String[] args) throws ParseException {
    Locale.setDefault(Locale.US);
    Scanner sc = new Scanner(System.in);
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    System.out.println("Enter cliente data: ");
    System.out.print("Name: ");
    String clienteName = sc.nextLine();
    System.out.print("Email: ");
    String email = sc.next();
    System.out.println("Birth date: ");
    Date birthyDate = sdf.parse(sc.next());
    System.out.println();
    Client cliente = new Client(clienteName, email, birthyDate);
    System.out.println("Enter order data: ");

     System.out.println("Status: ");
     String code = sc.next();
     Order order = new Order(OrderStatus.valueOf(code), cliente );
     System.out.print("How many items to this order? ");
     int n = sc.nextInt();
     
sc.nextLine();
     for(int i = 1; i <= n ; i++){
        System.out.println("Enter #" + i + " item data: ");
        System.out.print("Product name: ");
        String prodName = sc.nextLine();
        System.out.print("Product price: ");
        double price = sc.nextDouble();
        System.out.print("Quantity: ");
        int quantity = sc.nextInt();
        Product product = new Product(prodName, price);
        OrderItem orderItem = new OrderItem(quantity, product);
        order.addItem(orderItem);

     } 
     System.out.print("Order moment: " + order.getMoment());
     System.out.println("Order status: " + order.getStatus());
     System.out.println("Client: " + order.getCliente().getName()+" "+ order.getCliente().getBirthDate()+ "_ " + order.getCliente().getEmail() );
     
     System.out.println("Order items: ");
     for (OrderItem o : order.getItemsList()) {
     
        System.out.println(o.getProduct().getName()+", " + "Quantity: " + o.getQuantity()+", "+"Subtotal: "+ o.subTotal());
     }
      System.out.println("Total price: " + order.total());
    
sc.close();

}
}
