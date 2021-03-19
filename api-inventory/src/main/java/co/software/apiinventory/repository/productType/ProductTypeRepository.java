package co.software.apiinventory.repository.productType;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import co.software.apiinventory.model.ProductType;

@Repository
public interface ProductTypeRepository extends CrudRepository<ProductType, Integer>{

}
