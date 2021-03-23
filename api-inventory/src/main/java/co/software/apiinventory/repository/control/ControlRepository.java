package co.software.apiinventory.repository.control;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.software.apiinventory.model.Transaction;

@Repository
public interface ControlRepository extends CrudRepository<Transaction, Integer>{

}
