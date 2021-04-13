package co.software.apiinventory.repository.product;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.software.apiinventory.model.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer>{
	
}
