package za.co.eoh.andile.cic.communication;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CommunicationService {
	
	@Autowired
	private CommunicationRepository communicationRepository;

	public List<Communication> getAllCommunications(long customerId){
		List<Communication> communications = new ArrayList<>();
		communicationRepository.findByCustomerId(customerId)
						  .forEach(communications::add);
		return communications;
	}
	
	public Communication getCommunication(long id) {
		return communicationRepository.findById(id).get();
	}

	public void addCommunication(Communication communication) {
		communicationRepository.save(communication);
	}

	public void updateCommunication(Communication communication) {
		communicationRepository.save(communication);	
	}
}

