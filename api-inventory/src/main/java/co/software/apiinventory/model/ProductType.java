package co.software.apiinventory.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "product_type")
@Getter
@NoArgsConstructor
public class ProductType {
	@Id
	@GeneratedValue
	@Column(name = "id_product_type")
	private Integer idProductType;
	
	@Column(name = "product_type_name")
	private String productTypeName;

	public ProductType(Integer idProductType, String productTypeName) {
		super();
		this.idProductType = idProductType;
		this.productTypeName = productTypeName;
	}
}
