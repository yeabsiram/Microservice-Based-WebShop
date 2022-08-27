package client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

import java.util.Date;


@SpringBootApplication
public class ClientApplication implements CommandLineRunner {
	@Autowired
	private RestOperations  restTemplate;

	public static void main(String[] args) {
		SpringApplication.run(ClientApplication.class, args);
	}

	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Override
	public void run(String... args) throws Exception {


		AddressDTO addressDTO = new AddressDTO("Time Sq.", "Fairfield", "10000");
		CustomerDTO customerDTO = new CustomerDTO("001", "Aberra Molla", "+111222333", "abera@maharishi.com", addressDTO);
		restTemplate.postForLocation("http://localhost:8080/customers", customerDTO);
		ProductDTO productDTO1 = new ProductDTO("112", "Acer Laptop", 1200.0, "Acer", "+111222333");
		ProductDTO productDTO2 = new ProductDTO("113", "Toshiba Laptop", 1300.00, "Toshiba", "+111222333");
		restTemplate.postForLocation("http://localhost:8080/products", productDTO1);
		restTemplate.postForLocation("http://localhost:8080/products", productDTO2);
		OrderDTO orderDTO = new OrderDTO("114", new Date(), 2500.00, customerDTO.getCustomerNumber(), customerDTO.getName(), customerDTO.getEmail());
		OrderLineDTO orderLineDTO1 = new OrderLineDTO(2, productDTO1);
		OrderLineDTO orderLineDTO2 = new OrderLineDTO(4, productDTO2);
		orderDTO.addOrderLine(orderLineDTO1);
		orderDTO.addOrderLine(orderLineDTO2);
		restTemplate.postForLocation("http://localhost:8080/ordercommand", orderDTO);
		PaymentDTO paymentDTO = new PaymentDTO("114", new Date(), 3500, orderDTO.getOrderNumber(), customerDTO.getCustomerNumber());
		restTemplate.postForLocation("http://localhost:8080/payments", paymentDTO);
		OrderDTO ord = restTemplate.getForObject("http://localhost:8080/orderquery/"+orderDTO.getOrderNumber(), OrderDTO.class);
		System.out.println(  ord);
		productDTO2.setName("Sony");
		restTemplate.put("http://localhost:8080/products/"+productDTO2.getProductNumber(), productDTO2);
		paymentDTO.setAmount(7000);
		restTemplate.put("http://localhost:8080/payments/"+paymentDTO.getPaymentNumber(), paymentDTO);
		customerDTO.setEmail("molla@maharish.com");
		restTemplate.put("http://localhost:8080/customers/"+customerDTO.getCustomerNumber(), customerDTO);
		ord = restTemplate.getForObject("http://localhost:8080/orderquery/"+orderDTO.getOrderNumber(), OrderDTO.class);
		System.out.println(ord);
	}


}
