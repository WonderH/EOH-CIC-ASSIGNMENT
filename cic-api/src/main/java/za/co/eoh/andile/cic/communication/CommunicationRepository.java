package za.co.eoh.andile.cic.communication;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CommunicationRepository extends CrudRepository<Communication, Long>{
	
	public List<Communication> findByCustomerId(long customerId);
}
