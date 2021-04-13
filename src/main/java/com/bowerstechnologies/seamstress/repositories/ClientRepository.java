package com.bowerstechnologies.seamstress.repositories;

import com.bowerstechnologies.seamstress.entities.Client;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {
    
    List<Client> findByName(String name);
    
}
