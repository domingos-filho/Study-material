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
import entities_enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner entrada = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				
		System.out.println("Enter cliente data:");
		System.out.print("Name: ");
		String name = entrada.nextLine();
		System.out.print("Email: ");
		String email = entrada.nextLine();
		System.out.print("Birth date (DD/MM/YYYY): ");
		Date birthDate = sdf.parse(entrada.next());
		
		Client client = new Client(name, email, birthDate);
				
		System.out.println("Enter order data:");
		System.out.print("Status: ");
		OrderStatus status = OrderStatus.valueOf(entrada.next());
		
		Order order = new Order(new Date(), status, client);
		
		System.out.print("How many items to this order? ");
		int itens = entrada.nextInt();
		for (int i=1; i<=itens; i++) {
			System.out.println("Enter #" + i + " item data:");
			System.out.print("Product name: ");
			entrada.nextLine();
			String nameProd = entrada.nextLine();
			System.out.print("Product price: ");
			double price = entrada.nextDouble();
			
			Product product = new Product(nameProd, price);
			
			System.out.print("Quantity: ");
			int quantity = entrada.nextInt();
			
			OrderItem orderItem = new OrderItem(quantity, price, product);
			
			order.addItem(orderItem);
		}
			
		System.out.println();
		System.out.println("ORDER SUMARY:");
		System.out.println(order);
		
		entrada.close();
	}

}
