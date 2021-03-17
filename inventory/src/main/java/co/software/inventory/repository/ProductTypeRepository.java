package co.software.inventory.repository;

import org.springframework.data.repository.CrudRepository;

import co.software.inventory.model.ProductType;

public interface ProductTypeRepository extends CrudRepository<ProductType, Integer>{

}
