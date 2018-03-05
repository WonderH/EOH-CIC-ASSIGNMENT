package za.co.eoh.andile.cic.communication;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import za.co.eoh.andile.cic.customer.Customer;
import za.co.eoh.andile.cic.exception.DataNotFoundException;

@RestController
public class CommunicationController {
	
	@Autowired
	private CommunicationService communicationService;
	
	@RequestMapping("/customers/{customerId}/communications")
	public List<Communication> getAllCommunications(@PathVariable long customerId){
		return communicationService.getAllCommunications(customerId);
	}
	
	@RequestMapping("/customers/{customerId}/communications/{id}")
	public Communication getCommunication(@PathVariable long id) {
		Communication communication = communicationService.getCommunication(id);
		if (communication == null) {
			throw new DataNotFoundException("Communication with id: " + id + " was not found.");
		}
		return communication;
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/customers/{customerId}/communications")
	public void addCustomer(@RequestBody Communication communication, @PathVariable long customerId) {
		communication.setCustomer(new Customer(customerId,"",""));
		communicationService.addCommunication(communication);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/customers/{customerId}/communications/{id}")
	public void updateCustomer(@RequestBody Communication communication, @PathVariable long customerId) {
		communication.setCustomer(new Customer(customerId,"",""));
		communicationService.updateCommunication(communication);
	}

}
