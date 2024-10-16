package RentalApi;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class endToEnd {

	// public String tokens=register.getToken();
	register register = new register();

	@DataProvider(name = "token")
	public Object[][] provideToken() {
		String tokens = register.getToken();
		// Return a two-dimensional array with a single row containing the token
		return new Object[][] { { tokens } };
	}

	@Test(priority = 1)
	public void register() throws IOException {
		// register register=new register();

		register.registering();
		// tokens=register.getToken();

	}

	@Test(dataProvider = "token", priority = 2)
	public void creatingOrder(String tokens) throws IOException {
		createOrder create = new createOrder();
		create.createingOrder(tokens);
	}

	@Test(dataProvider = "token", priority = 3)
	public void gettingOrder(String tokens) {
		getOrders.getOrder(tokens);
	}

	@Test(dataProvider = "token", priority = 4)
	public void updatingOrder(String tokens) {
		updatingOrders.updateOrder(tokens);
		getOrders.getOrder(tokens);
	}

	@Test(dataProvider = "token", priority = 5)
	public void deletingOrder(String tokens) {
		deleteOrderr.deleteOrder(tokens);
		getOrders.getOrder(tokens);
	}

	// >>>>>>>>>>>to run without testNG

	/*
	 * public static void main(String[] args) throws IOException { register
	 * register=new register(); register.registering(); String
	 * tokens=register.getToken(); createOrder create=new createOrder();
	 * create.createingOrder(tokens); getOrders.getOrder(tokens);
	 * updatingOrders.updateOrder(tokens); getOrders.getOrder(tokens);
	 * deleteOrderr.deleteOrder(tokens); getOrders.getOrder(tokens); }
	 */
}
