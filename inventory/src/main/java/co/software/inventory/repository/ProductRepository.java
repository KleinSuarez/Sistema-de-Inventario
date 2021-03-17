package co.software.inventory.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.software.inventory.model.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, String>{
	List<Product> findAll();
}
