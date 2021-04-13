package com.bowerstechnologies.seamstress.repositories;

import com.bowerstechnologies.seamstress.entities.ClientOrder;
import com.bowerstechnologies.seamstress.entities.Client;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientOrderRepository extends CrudRepository<ClientOrder, Long> {
    
//    List<ClientOrder> findByClient(Client client);
    
}
