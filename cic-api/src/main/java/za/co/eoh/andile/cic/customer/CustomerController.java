package za.co.eoh.andile.cic.customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import za.co.eoh.andile.cic.exception.DataNotFoundException;

@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping("/customers")
	public List<Customer> getAllCustomers(){
		return customerService.getAllCustomers();
	}
	
	@RequestMapping("/customers/{id}")
	public Customer getCustomer(@PathVariable long id) {
		Customer customer = customerService.getCustomer(id);
		if (customer == null) {
			throw new DataNotFoundException("Customer with id: " + id + " was not found.");
		}
		return customer;
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/customers")
	public void addCustomer(@RequestBody Customer customer) {
		customerService.addCustomer(customer);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/customers/{id}")
	public void updateCustomer(@PathVariable long id, @RequestBody Customer customer) {
		customerService.updateCustomer(id, customer);
	}

}
