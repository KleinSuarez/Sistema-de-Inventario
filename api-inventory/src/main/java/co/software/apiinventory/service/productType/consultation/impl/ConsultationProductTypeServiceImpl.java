package co.software.apiinventory.service.productType.consultation.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.software.apiinventory.model.ProductType;
import co.software.apiinventory.repository.productType.ProductTypeRepository;
import co.software.apiinventory.service.productType.consultation.ConsultationProductTypeService;

@Service
public class ConsultationProductTypeServiceImpl implements ConsultationProductTypeService{

	@Autowired
	private ProductTypeRepository productTypeRepository;
	
	@Override
	public Iterable<ProductType> findAll() {
		return productTypeRepository.findAll();
	}

}
