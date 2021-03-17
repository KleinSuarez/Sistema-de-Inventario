package co.software.inventory.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name = "product_type")
@Data
@AllArgsConstructor
public class ProductType {
	@Id
	@Column(name = "id_product_type", unique = true)
	private Integer idProductType;
	
	@Column(name = "product_type_name")
	private String productTypeName;
}
