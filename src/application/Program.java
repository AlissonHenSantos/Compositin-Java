package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entitis.Client;
import entitis.Order;
import entitis.OrderItem;
import entitis.Product;
import entitis.enums.OrderStatus;




public class Program {

	public static void main(String[] args) throws ParseException  {
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		
		System.out.println("Enter client data: ");
		System.out.print("Nome: ");
		String name = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.nextLine();
		System.out.print("Birth date (DD/MM/YYYY): ");
		Date date = sdf.parse(sc.next());
		Client cliente = new Client(name, email, date);
		
		
		System.out.println("Enter order data: ");
		System.out.print("Status: ");
		String status = sc.next();
		System.out.println("How many items to this order? ");
		int n = sc.nextInt();
		Product prod = new Product();
		OrderItem orderItem = new OrderItem();
		Order order = new Order();
		for(int i = 0; i < n; i++) {
			System.out.println("Enter #" + i + " item data:");
			System.out.print("Name: ");
			name = sc.next();
			System.out.print("Price: ");
			double price = sc.nextDouble();
			int quantity = sc.nextInt();
			prod.setName(name);
			prod.setPrice(price);
			orderItem.setProduct(prod);
			orderItem.setPrice(prod.getPrice());
			orderItem.setQuantity(quantity);
			order.addItem(orderItem);
		}
		Date orderMoment = sdf2.parse("20/04/2018 11:25:09");
		order.setMoment(orderMoment);
		order.setStatus(OrderStatus.valueOf(status));
		order.setClient(cliente);
		System.out.println(order);
		
		
		
	
		sc.close();
	}

}
