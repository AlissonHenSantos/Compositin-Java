package entitis;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entitis.enums.OrderStatus;

public class Order {
		static private SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		private Date moment;
		private OrderStatus status;
		private List<OrderItem> OrderItens = new ArrayList<>();
		private Client client;
		
		public Order() {
			
		}
		public Order(Date moment, OrderStatus status, Client client) {
			this.moment = moment;
			this.status = status;
			this.client = client;
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
		public List<OrderItem> getOrderItens() {
			return OrderItens;
		}
		
		public void addItem(OrderItem item) {
			OrderItens.add(item);
		}
		public void removeItem(OrderItem item) {
			OrderItens.remove(item);
		}
		public Client getClient() {
			return client;
		}
		public void setClient(Client client) {
			this.client = client;
		}
		
		public double total(List<OrderItem> itens) {
			double sum = 0;
			for (OrderItem oI : itens) {
				sum += oI.getPrice();
			}
			return sum;
		}
		@Override
		public String toString() {
		 StringBuilder sb = new StringBuilder();
		 			sb.append("ORDER SUMARY: \n");
					sb.append("Order moment: " + sdf2.format(moment) + "\n");
					sb.append("Order status: " + status + "\n");
					sb.append("Client" + client + "\n");
					sb.append("Order items: \n");
					for(OrderItem o: OrderItens) {
						sb.append(o + "\n");
					}
					sb.append("Total price: " + total(OrderItens));
					return sb.toString();
						
		}
		
		
		
}
