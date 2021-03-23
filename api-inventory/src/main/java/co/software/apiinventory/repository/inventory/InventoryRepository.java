package co.software.apiinventory.repository.inventory;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.software.apiinventory.model.Product;

@Repository
public interface InventoryRepository extends CrudRepository<Product, Integer>{
	
}
